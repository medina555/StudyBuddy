/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import DATABASE.Database;
import DATAMODEL.Student;
import DATAMODEL.StudentDataModel;
import EMAIL.EmailAttachmentSender;
import GUI.SBAddFriend;
import GUI.SBCreateGroupGUI;
import GUI.SBLoginGUI;
import GUI.SBMainGUI;
import GUI.SBNewAccountFormGUI;
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
import javafx.scene.control.TextField;
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
public class SBController {
        Scene myscene; 
   

  public Stage primaryStage;
  
  public void setPrimaryStage(Stage stage)
  {
      this.primaryStage = stage; 
  }
 
   SBMainGUI mGUI = new SBMainGUI();
   StudentDataModel sdm;
   SBLoginGUI lGUI ;
   SBNewAccountFormGUI snafGUI;
   SBMain main;
   SBAddFriend sbaf;
   
   
  
   Image utrgvimage = new Image("UTRGV.png");
    ImageView utrgviv = new ImageView(utrgvimage);
   
  
    Image tscimage= new Image("tsclogo.png");
    ImageView tsciv = new ImageView(tscimage);
  
   Image stcimage = new Image("STC.png");
   ImageView stc = new ImageView(stcimage);
   Alert errorAlert = new Alert(AlertType.ERROR);
    
    	public SBController(SBMainGUI maingui, StudentDataModel studentdm, SBLoginGUI sblgui, SBNewAccountFormGUI sbnagui, SBAddFriend sbaf) {
		this.sdm= studentdm;
		this.mGUI = maingui;
                this.lGUI =sblgui; 
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
             public void handle (ActionEvent event)
             {
                 Database mydb = sdm.getMydb();
             
                 try
                 {
                     
                     ResultSet myRs = mydb.getMyRs();
                         while(myRs.next())
                     {
                        
                         

                     }
                     
                 }
                 catch(Exception e){}
                 
             }
             }
                 
             );
           
           
           
           
           
           
           
           
                   lGUI.getLoginBTN().setOnAction(
                          
                           new EventHandler<ActionEvent>()
                            
                             {
             @Override
             public void handle (ActionEvent event)
             { 
                boolean found = false; 
     Database mydb = Database.getSingletonOfdatabase();
   
      
     try{
   
         Connection conn=  mydb.getConn();
         Statement mystmt = conn.createStatement();
        
        String school1 = "UTRGV";
     String school2 = "STC";
     String school3 = "TSC";
     
      if (!lGUI.getUserNameTF().getText().isEmpty() && !lGUI.getPasswordTF().getText().isEmpty())
     { 
       
     ResultSet myrs1 = mystmt.executeQuery("SELECT username,sbpassword,school FROM student");
    
       
         
         while(myrs1.next()){
             
       if ((lGUI.getUserNameTF().getText().equals(myrs1.getString("username"))) && (lGUI.getPasswordTF().getText().equals(myrs1.getString("sbpassword")))&&
              (school1.equals(myrs1.getString("school"))))
       {
           found =true; 
           
                   System.out.println("pass");
               
                 mGUI.getWelcomeLBL().setText("Welcome " + lGUI.getUserNameTF().getText());
                   mGUI.setStyle("-fx-background-color: #FAD7A0");
           mGUI.getAppvbox().setStyle("-fx-background-color: #52C286");
           mGUI.getApphbox().setAlignment(Pos.TOP_RIGHT);
        
      VBox myvbox = new VBox();
      myvbox.getChildren().addAll(mGUI.getWelcomeLBL(),utrgviv,mGUI.getApphbox());
       myvbox.setAlignment(Pos.CENTER);
          myvbox.setPadding(new Insets(0, 0, 0, 300));
     mGUI.add(myvbox, 3, 0); 
     
       }
       
   
    
      if ((lGUI.getUserNameTF().getText().equals(myrs1.getString("username"))) && (lGUI.getPasswordTF().getText().equals(myrs1.getString("sbpassword")))&&
              (school2.equals(myrs1.getString("school"))))
       {
           found = true; 
           mGUI.setStyle("-fx-background-color: #BB8FCE");
           mGUI.getAppvbox().setStyle("-fx-background-color: #AB98D9");
           mGUI.getWelcomeLBL().setText("Welcome " + lGUI.getUserNameTF().getText());
       
              VBox myvbox2 = new VBox();
              myvbox2.setAlignment(Pos.CENTER);
      myvbox2.getChildren().addAll(mGUI.getWelcomeLBL(),stc,mGUI.getApphbox());
         myvbox2.setPadding(new Insets(0, 0, 0, 300));
     mGUI.add(myvbox2, 3, 0);
     
       }
 
       
           if ((lGUI.getUserNameTF().getText().equals(myrs1.getString("username"))) && (lGUI.getPasswordTF().getText().equals(myrs1.getString("sbpassword")))&&
              (school3.equals(myrs1.getString("school"))))
       {
                     found = true; 
            mGUI.getFriendSearchBTN().setStyle("-fx-font: 12 arial; -fx-base: #F29F51");
         mGUI.getCreateAppBTN().setStyle("-fx-font: 12 arial; -fx-base: #F29F51");          
           mGUI.setStyle("-fx-background-color: #99c2ff");
           mGUI.getAppvbox().setStyle("-fx-background-color: #ffb380");
           mGUI.getWelcomeLBL().setText("Welcome " + lGUI.getUserNameTF().getText());
       
              VBox myvbox2 = new VBox();
              myvbox2.setAlignment(Pos.CENTER);
      myvbox2.getChildren().addAll(mGUI.getWelcomeLBL(),tsciv,mGUI.getApphbox());
      myvbox2.setPadding(new Insets(0, 0, 0, 300));
     mGUI.add(myvbox2, 3, 0);
     
       }
       
      
      
       
  
      
       }
         
            
      
     
  if (found == true) {
         primaryStage.close();
       Stage window = new Stage();
       
       
    
       
		 BorderPane root = new BorderPane();
                 root.setCenter(mGUI);
                 root.setRight(mGUI.getAppvbox());
                
           
               
	
             Scene   scene3 = new Scene(root,1200,1000);
                
		
	    
        
       window.setTitle("Study Buddy");
       
        window.setScene(scene3);
        window.show(); 
         
       
  }
    if (found ==false)
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
                 
     }catch (Exception e){}    
                     
             
                
             
             }
         }    
             );
           
           
                  mGUI.getUploadFileBTN().setOnAction(
                    
                    new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
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
             public void handle (ActionEvent event)
             {
                     String fstring = mGUI.getFvalue();
                     
                     System.out.println(fstring + "has been added to group");
  
               
              
        
             }
         }
                            );
                  
                  
                  
          
                  
                  
                  
             
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                       
                 lGUI.getCreateAccountBTN().setOnAction(
                    
                    new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             {
                    Stage window = new Stage();
       
       
    
       
		 BorderPane root = new BorderPane();
                 root.setCenter(mGUI);
                 root.setRight(mGUI.getAppvbox());
                 root.setLeft(mGUI.getFriendBox());
               
                 BorderPane root2 = new BorderPane();
                 root2.setCenter(snafGUI);
	
             Scene   scene3 = new Scene(root2,1000,1000);
                
		
	    
        
       window.setTitle("Study Buddy");
       
        window.setScene(scene3);
        window.show();
              
          
             }
         }
                            );
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
           
           
           
            snafGUI.getCreateAccBTN().setOnAction(
                 
                    new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             {
                 
                 
                 try {
                      boolean exist = false; 
                       Connection Conn = Database.getSingletonOfdatabase().getConn();
                   Statement mystmt = Conn.createStatement();
                   ResultSet myrs = mystmt.executeQuery("SELECT username,studentid from student");
                   myrs.beforeFirst();
                     
                   while(myrs.next())
                   {
                               if(snafGUI.getUnameTF().getText().equals(myrs.getString("username")))
                                       {
                                                Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("USERNAME ALREADY EXISTS");
                    errorAlert.setContentText("Sorry that username is already taken!!");
                        
                    errorAlert.showAndWait();
                    exist =true; 
                    break;
                 
                                         
                              
                                       }
                               
             
                               
                               
                              if(Integer.parseInt(snafGUI.getSBidTF().getText()) == myrs.getInt("studentid"))
                                       {
                                                Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("ID ALREADY EXISTS");
                    errorAlert.setContentText("Sorry that id is already taken !");
                        
                    errorAlert.showAndWait();
                    exist = true; 
                
                             break;            
                                  
                                       }  
                            
                               
                      if (snafGUI.isEmpty(snafGUI.getFnameTF(), snafGUI.getLnameTF(),snafGUI.getUnameTF(), snafGUI.getMajorlabelTF(), snafGUI.getPassTF(), snafGUI.getSBidTF())==true)
                      {
                               errorAlert.setHeaderText("ERROR EMPTY FIELD");
                    errorAlert.setContentText("One of the fields was left blank !");
                        
                    errorAlert.showAndWait();
                    exist = true; 
                
                             break; 
                      }
  
                    
                        
                             
                  
                             
                   
                } 
                  
                 
                       if( exist == false){
                
          
                                 int x = 0; 
                                    x = Integer.parseInt(snafGUI.getSBidTF().getText());
                               
                                          ChoiceBox<String> cemail= snafGUI.getEmailBox();
                                 
                                     ChoiceBox<String> schoice = snafGUI.getSchoolBox();
                                     String firstname = snafGUI.getFnameTF().getText();
                                     String lastname = snafGUI.getLnameTF().getText();
                                     String major = snafGUI.getMajorlabelTF().getText();

                                     String school= snafGUI.getSchoolChoice(schoice);
                                     String email = snafGUI.getEmailTF().getText() +snafGUI.getSchoolChoice(cemail);
                                     String username = snafGUI.getUnameTF().getText();
                                     String password = snafGUI.getPassTF().getText();
                                            
                      PreparedStatement pstmt= Conn.prepareStatement("INSERT into student VALUES(?,?,?,?,?,?,?,?)");
                      
                   
                      
                    pstmt.setInt(1,x );
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
            
                          
                                        try
        {        String host = "smtp.outlook.com";
		String eport = "587";
		String emailFrom = "amed55@live.com";
		String epassword = "chiodos5555";

		// message info
		String emailTo = email;
		String esubject = "Welcome to Study Buddy!";
		String emessage = " Your new login information is  " + "username: "+ username + "\n" +"password" + password;

		// attachments
		String[] eattachFiles = new String[1];
		eattachFiles[0] = "UTRGV.png";
                
		//attachFiles[2] = "e:/Test/Video.mp4";
		
		// CC emails
		String[] ccEmails ={""};
			EmailAttachmentSender.sendEmailWithAttachments(host, eport, emailFrom, epassword, emailTo,
				esubject, emessage, eattachFiles);
			System.out.println("Email sent.");
        }
           catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}

	
                           }  
         
                 
                 
                 
                 
                 
             
         } 
             catch(Exception e){}  
         }
             
         }
             );
           
     
           
               
               
      
           
               
               
                  
                        mGUI.getFriendSearchBTN().setOnAction(
                   
                    new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             {
                           Stage window = new Stage();
       
       
    
       
		 BorderPane root = new BorderPane();
                 root.setCenter(sbaf);
              
               
              
	
             Scene   scene3 = new Scene(root,100,100);
                
		
	    
        
       window.setTitle("Study Buddy");
       
        window.setScene(scene3);
        window.show();
        
                  
;
             }
         }
                            );
               
               
               
         
               
                                mGUI.getFriendSearchBTN().setOnAction(
                   
                    new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             {
                           Stage window = new Stage();
       
       
    
       
		 BorderPane root = new BorderPane();
                 root.setCenter(sbaf);
              
               
              
	
             Scene   scene3 = new Scene(root,200,200);
                
		
	    
        
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
             public void handle (ActionEvent event)
             {
                 
               
                 Database mydb2 = Database.getSingletonOfdatabase();
                        try {  
                            
                            ListView<String> listView = mGUI.getSlist();
                     Connection Conn = mydb2.getConn();
                     Statement stmt = Conn.createStatement();
                     ResultSet myrs = stmt.executeQuery("SELECT username from student");
                     boolean hasfriend = false; 
                     
                     while(myrs.next())
                     {
                         
                         if(sbaf.getFriendTF().getText().equals(myrs.getString("username"))&&!(lGUI.getUserNameTF().getText().equals(myrs.getString("username"))))
                         {
                          
                             
                             
                            
                             String uname = myrs.getString("username");
                             listView.getItems().add(uname);
               
                         }
                         
                              
                        
                         
                      
              
                         
                       
                                 
                              
                    
                       
                     }
                     
                     
                 } catch (Exception e) {
                 }
                  
;
             }
         }
                            );
               
           
           
           
           }
    
}
