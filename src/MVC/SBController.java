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
import GUI.GroupInfoGUI;
import GUI.SBAddFriend;
import GUI.SBCreateGroupGUI;
import GUI.SBLoginGUI;
import GUI.SBMainGUI;
import GUI.SBNewAccountFormGUI;
import GUI.SBNewEmailForm;
import MAIN.SBMain;
import java.io.File;
import java.lang.invoke.MethodHandles;
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
import javafx.scene.layout.HBox;
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
    GroupInfoGUI giGUI = new GroupInfoGUI();

    ObservableList olist = FXCollections.observableArrayList(gdm1.getGrouplist());

    Image utrgvimage = new Image("UTRGV.png");
    ImageView utrgviv = new ImageView(utrgvimage);

    Image tscimage = new Image("tsclogo.png");
    ImageView tsciv = new ImageView(tscimage);

    Image stcimage = new Image("STC.png");
    ImageView stc = new ImageView(stcimage);
    
    Image sblogo0 = new Image("sblogo0.JPG");
    ImageView sblogo0iv = new ImageView(sblogo0);
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

        utrgviv.setFitWidth(100);
        utrgviv.setFitHeight(50);
        stc.setFitWidth(100);
        stc.setFitHeight(50);
        tsciv.setFitWidth(100);
        tsciv.setFitHeight(50);

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
                                    mGUI.getGrouptable().setStyle(  " -fx-background-color: green;");
                                    HBox myhbox1 = new HBox();
                                    myhbox1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;" + "-fx-border-color: orange;");
                                    mGUI.setStyle("-fx-background-color: #80e5ff");
                               mGUI.getAppvbox().setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;" + "-fx-border-color: orange;");
                                    mGUI.getWelcomeLBL().setGraphic(utrgviv);
                                    myhbox1.getChildren().addAll(mGUI.getWelcomeLBL());
                                    myhbox1.setAlignment(Pos.CENTER);
                                   
                              
                                    sblogo0iv.setFitHeight(100);
                                    sblogo0iv.setFitWidth(200);
                                    mGUI.add(myhbox1, 3, 0);
                                    mGUI.add(sblogo0iv,4,0);
                                    mGUI.add(mGUI.getApphbox(),3,1);
                                    mGUI.add(mGUI.getAppvbox(),4,1);
                                }
                                if(school2.equals(myrs1.getString("school")))
                                {
                                                               mGUI.getGrouptable().setStyle(  " -fx-background-color: green;");
                                    HBox myhbox1 = new HBox();
                                    myhbox1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;" + "-fx-border-color: orange;");
                                    mGUI.setStyle("-fx-background-color: #80e5ff");
                               mGUI.getAppvbox().setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;" + "-fx-border-color: orange;");
                                    mGUI.getWelcomeLBL().setGraphic(stc);
                                    myhbox1.getChildren().addAll(mGUI.getWelcomeLBL());
                                    myhbox1.setAlignment(Pos.CENTER);
                                   
                               
                                    sblogo0iv.setFitHeight(100);
                                    sblogo0iv.setFitWidth(200);
                                    mGUI.add(myhbox1, 3, 0);
                                    mGUI.add(sblogo0iv,4,0);
                                    mGUI.add(mGUI.getApphbox(),3,1);
                                    mGUI.add(mGUI.getAppvbox(),4,1);
                                }
                                if(school3.equals(myrs1.getString("school")))
                                {
                                                          mGUI.getGrouptable().setStyle(  " -fx-background-color: green;");
                                    HBox myhbox1 = new HBox();
                                    myhbox1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;" + "-fx-border-color: orange;");
                                    mGUI.setStyle("-fx-background-color: #80e5ff");
                               mGUI.getAppvbox().setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
        + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
        + "-fx-border-radius: 5;" + "-fx-border-color: orange;");
                                    mGUI.getWelcomeLBL().setGraphic(tsciv);
                                    myhbox1.getChildren().addAll(mGUI.getWelcomeLBL());
                                    myhbox1.setAlignment(Pos.CENTER);
                                   
                            
                                    sblogo0iv.setFitHeight(100);
                                    sblogo0iv.setFitWidth(200);
                                    mGUI.add(myhbox1, 3, 0);
                                    mGUI.add(sblogo0iv,4,0);
                                    mGUI.add(mGUI.getApphbox(),3,1);
                                    mGUI.add(mGUI.getAppvbox(),4,1);
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
                                    Group gr = new Group(gname, cname, dow, cid);

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
                                
                                ResultSet myrs2 = stmt.executeQuery("SELECT distinct username from student,  friend where idFriend2 = student.studentid and idfriend1='"+currentUserId+"'");
                                
                               
                                
                                while (myrs2.next())
                                {
                                    System.out.println("username = " + myrs2.getString("username"));
                          
                           
                                    
                                    listView1.getItems().add(myrs2.getString("username"));
                                    
                                }
                                mGUI.updateFriendList(listView1);
                                

                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                            BorderPane root = new BorderPane();
                            root.setCenter(mGUI);
                   
                       

                            Scene scene3 = new Scene(root, 1000,600);
                            primaryStage.setResizable(false);

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
                mGUI.setGvalue("");
                  giGUI.getMemlist().getItems().clear();
                gdm1 = new GroupDataModel();
                olist = FXCollections.observableArrayList(gdm1.getGrouplist());
                ListView<String> newlist = new ListView();
                mGUI.setSlist(newlist);
                currentuser = "";

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
                
                try {
                 
                     boolean exists = false;
                    Database mydb3 = Database.getSingletonOfdatabase();
                    Connection conn = mydb3.getConn();
                    Statement mystmt = conn.createStatement();
                    ResultSet myrs = mystmt.executeQuery("SELECT groupname from studygroup");
                    
                    while(myrs.next())
                    {
                        if (sbcreategroup.getGnameTF().getText().equals(myrs.getString("groupname")))
                        {
                            exists = true; 
                                    errorAlert.setHeaderText("ERROR DUPLICATE GROUP NAME");
                            errorAlert.setContentText("The groupname you entered already exists@");

                            errorAlert.showAndWait();
                            snafGUI.clearFields();
                            break;
                       
                            
                        }
                    }
                
                
                System.out.println("ok");
                ObservableList olist1 = FXCollections.observableArrayList(gdm1.getGrouplist());

         
                String gname = sbcreategroup.getGnameTF().getText();
                int cid = Integer.parseInt(sbcreategroup.getCidTF().getText());
                String ginst = sbcreategroup.getGinstructorTF().getText();
                String gsub = sbcreategroup.getSubTF().getText();

                Group gr = new Group(gname, gsub, ginst, cid);

                gdm1.setGroup(gr);

                mGUI.getGroupname().setCellValueFactory(
                        new PropertyValueFactory<Group, String>("gname"));


                mGUI.getGroupsub().setCellValueFactory(
                        new PropertyValueFactory<Group, String>("gsubject"));

                mGUI.getGroupinst().setCellValueFactory(
                        new PropertyValueFactory<Group, String>("daysofweek"));

                mGUI.getGroupcid().setCellValueFactory(
                        new PropertyValueFactory<Group, Integer>("cid"));
                olist1.add(gr);
                mGUI.getGrouptable().setItems(olist1);
              
                

               

                    Database mydb5 = Database.getSingletonOfdatabase();
                    Connection Conn = mydb5.getConn();
                    PreparedStatement pstmt = Conn.prepareStatement("INSERT into studygroup(groupname,coursename,daysofweek,course_id) VALUES(?,?,?,?)");

           
                    pstmt.setString(1, gname);
                    pstmt.setString(2, gsub);
                    pstmt.setString(3, ginst);
                    pstmt.setInt(4, cid);

                    pstmt.executeUpdate();
                      System.out.println("gname before is " + gname);
                    int cgroupid = 0; 
              
              
                  Statement stmt7 = Conn.createStatement();
                  ResultSet myrs7 = stmt7.executeQuery("SELECT groupname, groupid from studygroup where groupname = '"+ sbcreategroup.getGnameTF().getText()+"'");

             if(myrs7.next()){
                  
                
                  cgroupid = myrs7.getInt("groupid");
             }
             
             
                  
              
  System.out.println("cid = "+ cgroupid);
  
  
   Connection Conn2 = mydb5.getConn();
   PreparedStatement pstmt2 = Conn2.prepareStatement("INSERT into belong Values(?,?)");
   pstmt2.setInt(1,currentUserId);
   pstmt2.setInt(2, cgroupid);
   pstmt2.executeUpdate();
  
  
  
  
  
  
  
  
  
  
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
                               snafGUI.clearFields();
                            break;

                        }

                      
                        
                        if (snafGUI.getEmailTF().getText().indexOf('@') >= 0)
                        {
                                                        Alert errorAlert = new Alert(AlertType.ERROR);
                            errorAlert.setHeaderText("ERROR in email format");
                            errorAlert.setContentText("Sorry the email entered wasn't valid (email must be in formac acb@yahoo.com etc)");

                            errorAlert.showAndWait();
                            exist = true;
                               snafGUI.clearFields();

                            break;
                        }
                        
                        
                        
                        

                        if (snafGUI.isEmpty(snafGUI.getFnameTF(), snafGUI.getLnameTF(), snafGUI.getUnameTF(),  snafGUI.getPassTF()) == true)
                        {
                            errorAlert.setHeaderText("ERROR EMPTY FIELD");
                            errorAlert.setContentText("One or more of the fields were left blank !");

                            errorAlert.showAndWait();
                            snafGUI.clearFields();
                            exist = true;

                            break;
                        }

                    }

                    if (exist == false)
                    {
                       
                 

                        ChoiceBox<String> cemail = snafGUI.getEmailBox();

                        ChoiceBox<String> schoice = snafGUI.getSchoolBox();
                        
                        ChoiceBox<String> cmajor = snafGUI.getMajorBox();
                        String firstname = snafGUI.getFnameTF().getText();
                        String lastname = snafGUI.getLnameTF().getText();
                        String major = snafGUI.getSchoolChoice(cmajor);

                        String school = snafGUI.getSchoolChoice(schoice);
                        String email = snafGUI.getEmailTF().getText() + snafGUI.getSchoolChoice(cemail);
                        String username = snafGUI.getUnameTF().getText();
                        String password = snafGUI.getPassTF().getText();
                        snafGUI.clearFields();
                        PreparedStatement pstmt = Conn.prepareStatement("INSERT into student(firstname,lastname,major,school,email,username,sbpassword) VALUES(?,?,?,?,?,?,?)");

                        
                        pstmt.setString(1, firstname);
                        pstmt.setString(2, lastname);
                        pstmt.setString(3, major);
                        pstmt.setString(4, school);
                        pstmt.setString(5, email);
                        pstmt.setString(6, username);
                        pstmt.setString(7, password);

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

        
        
          mGUI.getViewGroupInfoBTN().setOnAction(
                new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Stage window = new Stage();

                BorderPane root = new BorderPane();
                giGUI.getGrouplabel().setText(mGUI.getGvalue());
                  giGUI.getMemlist().getItems().clear();
                     try
                            {
                                Database mydb4 = Database.getSingletonOfdatabase();
                  
                                
                                Connection Conn = mydb4.getConn();
                                Statement stmt = Conn.createStatement();
                                
                                ResultSet myrs2 = stmt.executeQuery("SELECT distinct username,major from student,belong,studygroup where groupname='"+mGUI.getGvalue()+"'and group_id = groupid and studentid=student_id and studentid!='"+currentUserId+"'");
                                
                               
                                int groupcount = 0; 
                                int cscount = 0;
                                int cmpecount = 0;
                                int artcount = 0; 
                                int engcount = 0; 
                                int mathcount = 0; 
                                while (myrs2.next())
                                {
                                    System.out.println("groupusername = " + myrs2.getString("username"));
                          
                                      
                                   groupcount++; 
                                  giGUI.getMemlist().getItems().add(myrs2.getString("username"));
                                  
                                  if(myrs2.getString("major").equals("CSCI"))
                                  {
                                     cscount++;
                                      
                                  }
                                    if(myrs2.getString("major").equals("ENG"))
                                  {
                                    engcount++;
                                      
                                  }
                                      if(myrs2.getString("major").equals("MATH"))
                                  {
                                    mathcount++; 
                                      
                                  }
                                    
                                         if(myrs2.getString("major").equals("ART"))
                                  {
                                    artcount++; 
                                      
                                  }
                                         
                                              if(myrs2.getString("major").equals("CMPE"))
                                  {
                                    cmpecount++; 
                                      
                                  }       
                                         
                                         
                                    
                                }
                      
                             giGUI.getPieChartData().get(0).setPieValue(cscount);
                             giGUI.getPieChartData().get(1).setPieValue(artcount);
                             giGUI.getPieChartData().get(2).setPieValue(cmpecount);
                             giGUI.getPieChartData().get(3).setPieValue(mathcount);
                             giGUI.getPieChartData().get(4).setPieValue(engcount);

                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                
                
                
                
                
                root.setCenter(giGUI);

                Scene scene3 = new Scene(root, 500,800);

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
                boolean fexist = false; 
                try
                {
                    
                
                

                    String searchuser = sbaf.getFriendTF().getText();
                    int friend1 = 0;
                    int friend2 = 0;
                    ListView<String> listView = mGUI.getSlist();
                    Connection Conn = mydb2.getConn();
                
                    Statement stmt = Conn.createStatement();
                   ResultSet myrs2 = stmt.executeQuery("SELECT distinct username from student inner join  friend on idFriend2 = student.studentid and username !='"+currentuser+"'");
               while(myrs2.next()){
              
                    if(searchuser.equals(myrs2.getString("username")))
                    {
                   
                              System.out.println("current friend is " + myrs2.getString("username"));
                    System.out.println("current input is " + sbaf.getFriendTF().getText());
                          Alert errorAlert = new Alert(AlertType.ERROR);
                        errorAlert.setHeaderText("EXISTING FRIEND");
                        errorAlert.setContentText("The friend you are trying to add is already in your friends list!");
                      errorAlert.showAndWait();
                      break; 
              
                    }
               }
                } catch(Exception e){}
                
                
                try {
                    int friend1=0;
                    int friend2 = 0; 
                   Connection Conn3 = mydb2.getConn();
                   Statement stmt1 =Conn3.createStatement();
                ResultSet myrs3 =  stmt1.executeQuery("SELECT studentid from student where username ='"+currentuser+"'");
                  myrs3.next();
                    friend1 = myrs3.getInt("studentid");
                    System.out.println("my student id is " + myrs3.getInt("studentid"));
                  
                
                       Connection Conn4 = mydb2.getConn();
                
                    Statement stmt2 = Conn4.createStatement();
                    ResultSet myrs4 = stmt2.executeQuery("SELECT username, studentid  from student left join friend on idFriend2=studentid where idFriend2 is null");
                    if(myrs4.next())
                    {   
                        if(sbaf.getFriendTF().getText().equals(myrs4.getString("username")))
                        {
                        System.out.println("final username is " + myrs4.getString("username"));
                        mGUI.getSlist().getItems().add(myrs4.getString("username"));
                        friend2 = myrs4.getInt("studentid"); 
                        PreparedStatement pstmt = Conn4.prepareStatement("INSERT into friend VALUES (?,?)");
                    pstmt.setInt(1, friend1);
                    pstmt.setInt(2, friend2);
                    pstmt.executeUpdate();
                        }
                    }

                  
               
                    
               
            
               
             
                } catch (Exception e)
                {
                }
                
                ;
            }
        }
        );

    }

}

