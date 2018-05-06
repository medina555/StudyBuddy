/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import DATABASE.Database;
import DATAMODEL.Group;
import DATAMODEL.GroupDataModel;
import DATAMODEL.Student;
import DATAMODEL.StudentDataModel;
import EMAIL.EmailAttachmentSender;
import GUI.SBAddFriend;
import GUI.SBCreateGroupGUI;
import GUI.SBLoginGUI;
import GUI.SBMainGUI;
import GUI.SBNewAccountFormGUI;
import GUI.SBNewEmailForm;
import MAIN.SBMain;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Andrew
 */
public class SBController
{

    /**
     * @return the currentuser
     */
    public String getCurrentuser()
    {
        return currentuser;
    }

    /**
     * @param currentuser the currentuser to set
     */
    public void setCurrentuser(String currentuser)
    {
        this.currentuser = currentuser;
    }
    Scene myscene;

    public Stage primaryStage;

    public void setPrimaryStage(Stage stage)
    {
        this.primaryStage = stage;
    }

    public void setScene(Scene scene)
    {
        this.myscene = scene;
    }

    SBMainGUI mGUI = new SBMainGUI();
    SBCreateGroupGUI sbcreategroup = new SBCreateGroupGUI();
    SBNewEmailForm sbcreateemail = new SBNewEmailForm();
    StudentDataModel sdm;
    SBLoginGUI lGUI;
    SBNewAccountFormGUI snafGUI;
    SBMain main;
    SBAddFriend sbaf;
    private String currentuser;
    GroupDataModel gdm1 = new GroupDataModel();
    GroupController gcontroller;

    ObservableList olist = FXCollections.observableArrayList(gdm1.getGrouplist());

    Image utrgvimage = new Image("UTRGV.png");
    ImageView utrgviv = new ImageView(utrgvimage);

    Image tscimage = new Image("tsclogo.png");
    ImageView tsciv = new ImageView(tscimage);

    Image stcimage = new Image("STC.png");
    ImageView stc = new ImageView(stcimage);
    Alert errorAlert = new Alert(AlertType.ERROR);
    
    int currentUserId = 0;

    public SBController(SBMainGUI maingui, StudentDataModel studentdm, SBLoginGUI sblgui, SBNewAccountFormGUI sbnagui, SBAddFriend sbaf)
    {
        this.sdm = studentdm;
        this.mGUI = maingui;
        this.lGUI = sblgui;
        this.snafGUI = sbnagui;
        this.sbaf = sbaf;
        attachHandlers();
    }

    public void attachHandlers()
    {

        utrgviv.setFitWidth(700);
        utrgviv.setFitHeight(500);
        stc.setFitWidth(700);
        stc.setFitHeight(500);
        tsciv.setFitWidth(700);
        tsciv.setFitHeight(500);

        mGUI.getHideFriendBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Database mydb = sdm.getMydb();

                try
                {

                    ResultSet myRs = mydb.getMyRs();
                    while (myRs.next())
                    {

                    }

                } catch (Exception e)
                {
                }

            }
        }
        );

        lGUI.getLoginBTN().setOnAction(
                new EventHandler<ActionEvent>()

        {
            @Override
            public void handle(ActionEvent event)
            {
                boolean found = false;
                Database mydb = Database.getSingletonOfdatabase();

                try
                {

                    Connection conn = mydb.getConn();
                    Statement mystmt = conn.createStatement();

                    String school1 = "UTRGV";
                    String school2 = "STC";
                    String school3 = "TSC";
                    currentuser = lGUI.getUserNameTF().getText();
                    if (!lGUI.getUserNameTF().getText().isEmpty() && !lGUI.getPasswordTF().getText().isEmpty())
                    {
                        System.out.println("current user is " + currentuser);

                        ResultSet myrs1 = mystmt.executeQuery("SELECT username,sbpassword,school, studentid FROM student");

                        while (myrs1.next())
                        {

                            if ((lGUI.getUserNameTF().getText().equals(myrs1.getString("username"))) && (lGUI.getPasswordTF().getText().equals(myrs1.getString("sbpassword"))))
                            {
                                found = true;
                                
                                currentUserId = Integer.parseInt(myrs1.getString("studentid"));
                                System.out.println("My id is: "+currentUserId);
                                
                                mGUI.getChildren().clear();
                                mGUI.getWelcomeLBL().setText("Welcome " + lGUI.getUserNameTF().getText());
                                
                                if(school1.equals(myrs1.getString("school")))
                                {
                                    VBox myvbox1 = new VBox();
                                    mGUI.setStyle("-fx-background-color: #FAD7A0");
                                    mGUI.getAppvbox().setStyle("-fx-background-color: #52C286");
                                    myvbox1.getChildren().addAll(mGUI.getWelcomeLBL(), utrgviv, mGUI.getApphbox());
                                    myvbox1.setAlignment(Pos.CENTER);
                                    myvbox1.setPadding(new Insets(0, 0, 0, 300));
                                    mGUI.add(myvbox1, 3, 0);
                                }
                                if(school2.equals(myrs1.getString("school")))
                                {
                                    VBox myvbox2 = new VBox();
                                    mGUI.setStyle("-fx-background-color: #BB8FCE");
                                    mGUI.getAppvbox().setStyle("-fx-background-color: #AB98D9");
                                    myvbox2.getChildren().addAll(mGUI.getWelcomeLBL(), stc, mGUI.getApphbox());
                                    myvbox2.setAlignment(Pos.CENTER);
                                    myvbox2.setPadding(new Insets(0, 0, 0, 300));
                                    mGUI.add(myvbox2, 3, 0);
                                }
                                if(school3.equals(myrs1.getString("school")))
                                {
                                    VBox myvbox3 = new VBox();
                                    //mGUI.getFriendSearchBTN().setStyle("-fx-font: 12 arial; -fx-base: #F29F51");
                                    //mGUI.getCreateAppBTN().setStyle("-fx-font: 12 arial; -fx-base: #F29F51");
                                    mGUI.setStyle("-fx-background-color: #99c2ff");
                                    mGUI.getAppvbox().setStyle("-fx-background-color: #ffb380");
                                    myvbox3.getChildren().addAll(mGUI.getWelcomeLBL(), tsciv, mGUI.getApphbox());
                                    myvbox3.setAlignment(Pos.CENTER);
                                    myvbox3.setPadding(new Insets(0, 0, 0, 300));
                                    mGUI.add(myvbox3, 3, 0);
                                }
                                mGUI.getApphbox().setAlignment(Pos.TOP_RIGHT);
                            }

                        }

                        if (found == true)
                        {

                            Database mydb4 = Database.getSingletonOfdatabase();

                            try
                            {

                                Connection conn4 = mydb4.getConn();
                                Statement mystmt4 = conn4.createStatement();
                                ResultSet myrs4 = mystmt4.executeQuery("SELECT * FROM studygroup, belong WHERE "
                                        + "student_id="+currentUserId+" AND groupid = group_id");
                                
                                //cleaning the observable list for groups
                                System.out.println("olist has "+olist.size()+" elements");
                                olist.remove(0, olist.size()-1);
                                System.out.println("now it has "+olist.size()+" elements");
                                mGUI.getGrouptable().setItems(olist);
                                while (myrs4.next())
                                {
                                    System.out.println(myrs4.getString("groupname"));
                                    int gid = myrs4.getInt("groupid");
                                    System.out.println(gid);
                                    String gname = myrs4.getString("groupname");
                                    String cname = myrs4.getString("coursename");
                                    String dow = myrs4.getString("daysofweek");
                                    int cid = myrs4.getInt("course_id");
                                    System.out.println("my int is " + gid);
                                    Group gr = new Group(gname, gid, cname, dow, cid);

                                    mGUI.getGroupname().setCellValueFactory(
                                            new PropertyValueFactory<Group, String>("gname"));

                                    mGUI.getGroupid().setCellValueFactory(
                                            new PropertyValueFactory<Group, String>("gid"));

                                    mGUI.getGroupsub().setCellValueFactory(
                                            new PropertyValueFactory<Group, String>("gsubject"));

                                    mGUI.getGroupinst().setCellValueFactory(
                                            new PropertyValueFactory<Group, String>("daysofweek"));

                                    mGUI.getGroupcid().setCellValueFactory(
                                            new PropertyValueFactory<Group, String>("gname"));

                                    gdm1.setGroup(gr);

                                    olist.add(gr);
                                    mGUI.getGrouptable().setItems(olist);
                                }
                                System.out.println("now olist hast "+olist.size()+" elements");
                                mGUI.updateGroupTable(mGUI.getGrouptable());
                                

                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                            try
                            {
                                ListView<String> listView1 = mGUI.getSlist();
                                Connection Conn = mydb.getConn();
                                Statement stmt = Conn.createStatement();
                                
                                ResultSet myrs2 = stmt.executeQuery("SELECT DISTINCT studentid, firstname, idfriend1, idfriend2 from "
                                        + "student, friend WHERE (idfriend1 = "+currentUserId+" AND idfriend2 = studentid) OR "
                                                + "(idfriend2 = "+currentUserId+" AND idfriend1 = studentid)");
                                
                                listView1.getItems().remove(0, listView1.getItems().size()-1);
                                
                                while (myrs2.next())
                                {
                                    System.out.println("username = " + myrs2.getString("firstname"));
                                    listView1.getItems().add(myrs2.getString("firstname"));
                                }
                                mGUI.updateFriendList(listView1);
                                

                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                            BorderPane root = new BorderPane();
                            root.setCenter(mGUI);
                            root.setRight(mGUI.getAppvbox());

                            Scene scene3 = new Scene(root, 1200, 1000);

                            primaryStage.setScene(scene3);
                            lGUI.clearfieldslogin(lGUI.getUserNameTF(), lGUI.getPasswordTF());

                        }
                        if (found == false)
                        {
                            lGUI.clearfieldslogin(lGUI.getUserNameTF(), lGUI.getPasswordTF());
                            Alert errorAlert = new Alert(AlertType.ERROR);
                            errorAlert.setHeaderText("INVALID USERNAME/PASSWORD");
                            errorAlert.setContentText("The USERNAME/PASSWORD YOU ENTERED IS INVALID");

                            errorAlert.showAndWait();
                        }

                    }
                    else
                    {
                        Alert errorAlert = new Alert(AlertType.ERROR);
                        errorAlert.setHeaderText("BLANK FIELD");
                        errorAlert.setContentText("One of the fields was left blank@@");

                        errorAlert.showAndWait();

                    }

                } catch (Exception e)
                {
                }

            }
        }
        );

        mGUI.getUploadFileBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

                FileChooser chooser = new FileChooser();
                chooser.setTitle("Open File");
                File file = chooser.showOpenDialog(new Stage());
            }
        }
        );

        mGUI.getAddGroupBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String fstring = mGUI.getFvalue();

            }

        }
        );

        mGUI.getLogoutBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                gdm1 = new GroupDataModel();
                olist = FXCollections.observableArrayList(gdm1.getGrouplist());
                ListView<String> newlist = new ListView();
                mGUI.setSlist(newlist);

                primaryStage.setScene(myscene);

            }

        }
        );

        lGUI.getCreateAccountBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Stage window = new Stage();

                BorderPane root = new BorderPane();
                root.setCenter(mGUI);
                root.setRight(mGUI.getAppvbox());
                root.setLeft(mGUI.getFriendBox());

                BorderPane root2 = new BorderPane();
                root2.setCenter(snafGUI);

                Scene scene3 = new Scene(root2, 1000, 1000);

                window.setTitle("Study Buddy");

                window.setScene(scene3);
                window.show();

            }
        }
        );

        sbcreategroup.getSubmitBTN().setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.out.println("ok");
                ObservableList olist1 = FXCollections.observableArrayList(gdm1.getGrouplist());

                int gid = Integer.parseInt(sbcreategroup.getGidTF().getText());
                String gname = sbcreategroup.getGnameTF().getText();
                int cid = Integer.parseInt(sbcreategroup.getCidTF().getText());
                String ginst = sbcreategroup.getGinstructorTF().getText();
                String gsub = sbcreategroup.getSubTF().getText();

                Group gr = new Group(gname, gid, gsub, ginst, cid);

                gdm1.setGroup(gr);

                mGUI.getGroupname().setCellValueFactory(
                        new PropertyValueFactory<Group, String>("gname"));

                mGUI.getGroupid().setCellValueFactory(
                        new PropertyValueFactory<Group, String>("gid"));

                mGUI.getGroupsub().setCellValueFactory(
                        new PropertyValueFactory<Group, String>("gsubject"));

                mGUI.getGroupinst().setCellValueFactory(
                        new PropertyValueFactory<Group, String>("daysofweek"));

                mGUI.getGroupcid().setCellValueFactory(
                        new PropertyValueFactory<Group, String>("gname"));
                olist1.add(gr);
                mGUI.getGrouptable().setItems(olist1);

                try
                {

                    Database mydb5 = Database.getSingletonOfdatabase();
                    Connection Conn = mydb5.getConn();
                    PreparedStatement pstmt = Conn.prepareStatement("INSERT into studygroup VALUES(?,?,?,?,?)");

                    pstmt.setInt(1, gid);
                    pstmt.setString(2, gname);
                    pstmt.setString(3, gsub);
                    pstmt.setString(4, ginst);
                    pstmt.setInt(5, cid);

                    pstmt.executeUpdate();

                } catch (Exception e)
                {
                }

            }
        }
        );

        mGUI.getCreateGroupBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Stage window = new Stage();
                VBox gvbox = sbcreategroup;

                BorderPane root2 = new BorderPane();
                root2.setCenter(gvbox);

                Scene scene3 = new Scene(root2, 1000, 1000);

                window.setTitle("Create New Group");

                window.setScene(scene3);
                window.show();

            }
        }
        );

        mGUI.getCreateAppBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Stage window = new Stage();
                VBox gvbox2 = sbcreateemail;

                BorderPane root2 = new BorderPane();
                root2.setCenter(gvbox2);

                Scene scene3 = new Scene(root2, 1000, 1000);

                window.setTitle("Create New Group");

                window.setScene(scene3);
                window.show();

            }
        }
        );

        sbcreateemail.geteSubmitBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    String host = "smtp.outlook.com";
                    String eport = "587";
                    String emailFrom = "amed55@live.com";
                    String epassword = "chiodos5";

                    // message info
                    String emailTo = sbcreateemail.getEtoTF().getText();
                    String esubject = sbcreateemail.getEsubTF().getText();
                    String emessage = sbcreateemail.getEmessageTF().getText();

                    // attachments
                    String[] eattachFiles = new String[1];
                    eattachFiles[0] = sbcreateemail.getFileTF().getText();

                    //attachFiles[2] = "e:/Test/Video.mp4";
                    // CC emails
                    String[] ccEmails =
                    {
                        ""
                    };
                    EmailAttachmentSender.sendEmailWithAttachments(host, eport, emailFrom, epassword, emailTo,
                            esubject, emessage, eattachFiles);
                    System.out.println("Email sent.");
                } catch (Exception ex)
                {
                    System.out.println("Could not send email.");
                    ex.printStackTrace();
                }

            }
        }
        );

        snafGUI.getCreateAccBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

                try
                {
                    boolean exist = false;
                    Connection Conn = Database.getSingletonOfdatabase().getConn();
                    Statement mystmt = Conn.createStatement();
                    ResultSet myrs = mystmt.executeQuery("SELECT username,studentid from student");
                    myrs.beforeFirst();

                    while (myrs.next())
                    {
                        if (snafGUI.getUnameTF().getText().equals(myrs.getString("username")))
                        {
                            Alert errorAlert = new Alert(AlertType.ERROR);
                            errorAlert.setHeaderText("USERNAME ALREADY EXISTS");
                            errorAlert.setContentText("Sorry that username is already taken!!");

                            errorAlert.showAndWait();
                            exist = true;
                            break;

                        }

                        if (Integer.parseInt(snafGUI.getSBidTF().getText()) == myrs.getInt("studentid"))
                        {
                            Alert errorAlert = new Alert(AlertType.ERROR);
                            errorAlert.setHeaderText("ID ALREADY EXISTS");
                            errorAlert.setContentText("Sorry that id is already taken !");

                            errorAlert.showAndWait();
                            exist = true;

                            break;

                        }

                        if (snafGUI.isEmpty(snafGUI.getFnameTF(), snafGUI.getLnameTF(), snafGUI.getUnameTF(), snafGUI.getMajorlabelTF(), snafGUI.getPassTF(), snafGUI.getSBidTF()) == true)
                        {
                            errorAlert.setHeaderText("ERROR EMPTY FIELD");
                            errorAlert.setContentText("One of the fields was left blank !");

                            errorAlert.showAndWait();
                            exist = true;

                            break;
                        }

                    }

                    if (exist == false)
                    {

                        int x = 0;
                        x = Integer.parseInt(snafGUI.getSBidTF().getText());

                        ChoiceBox<String> cemail = snafGUI.getEmailBox();

                        ChoiceBox<String> schoice = snafGUI.getSchoolBox();
                        String firstname = snafGUI.getFnameTF().getText();
                        String lastname = snafGUI.getLnameTF().getText();
                        String major = snafGUI.getMajorlabelTF().getText();

                        String school = snafGUI.getSchoolChoice(schoice);
                        String email = snafGUI.getEmailTF().getText() + snafGUI.getSchoolChoice(cemail);
                        String username = snafGUI.getUnameTF().getText();
                        String password = snafGUI.getPassTF().getText();

                        PreparedStatement pstmt = Conn.prepareStatement("INSERT into student VALUES(?,?,?,?,?,?,?,?)");

                        pstmt.setInt(1, x);
                        pstmt.setString(2, firstname);
                        pstmt.setString(3, lastname);
                        pstmt.setString(4, major);
                        pstmt.setString(5, school);
                        pstmt.setString(6, email);
                        pstmt.setString(7, username);
                        pstmt.setString(8, password);

                        pstmt.executeUpdate();

                        Alert errorAlert = new Alert(AlertType.INFORMATION);
                        errorAlert.setHeaderText("ACCOUNT CREATED SUCESSFULLY");
                        errorAlert.setContentText("You can now log in with your new information");

                        errorAlert.showAndWait();

                    }

                } catch (Exception e)
                {
                }
            }

        }
        );

        mGUI.getFriendSearchBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Stage window = new Stage();

                BorderPane root = new BorderPane();
                root.setCenter(sbaf);

                Scene scene3 = new Scene(root, 500, 200);

                window.setTitle("Study Buddy");

                window.setScene(scene3);
                window.show();
                ;
            }
        }
        );

        sbaf.getAddfriendBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {

                Database mydb2 = Database.getSingletonOfdatabase();
                try
                {

                    String searchuser = sbaf.getFriendTF().getText();
                    int friend1 = 0;
                    int friend2 = 0;
                    ListView<String> listView = mGUI.getSlist();
                    Connection Conn = mydb2.getConn();

                    Statement stmt = Conn.createStatement();

                    ResultSet myrs = stmt.executeQuery("SELECT username,studentid from student where username ='" + currentuser + "'");
                    myrs.next();
                    System.out.println("current user is " + currentuser);

                    friend1 = myrs.getInt("studentid");
                    System.out.println("friend 1 is " + friend1);

                    ListView<String> listView1 = mGUI.getSlist();

                    ResultSet myrs2 = stmt.executeQuery("SELECT DISTINCT (username),studentid from student, friend where idFriend2!='" + friend1 + "' and username='" + searchuser + "'");
                    while (myrs2.next())
                    {
                        System.out.println("username is " + myrs2.getString("username"));
                        mGUI.getSlist().getItems().add(myrs2.getString("username"));
                        friend2 = myrs2.getInt("studentid");
                    }

                    PreparedStatement pstmt = Conn.prepareStatement("INSERT into friend VALUES (?,?)");
                    pstmt.setInt(1, friend1);
                    pstmt.setInt(2, friend2);
                    pstmt.executeUpdate();
                } catch (Exception e)
                {
                }
                ;
            }
        }
        );

    }

}

