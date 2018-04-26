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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
   
  
   Image utrgvimage = new Image("UTRGV.png");
    ImageView utrgviv = new ImageView(utrgvimage);
   
  
   
  
   Image stcimage = new Image("STC.png");
   ImageView stc = new ImageView(stcimage);
   Alert errorAlert = new Alert(AlertType.ERROR);
    
    	public SBController(SBMainGUI maingui, StudentDataModel studentdm, SBLoginGUI sblgui, SBNewAccountFormGUI sbnagui) {
		this.sdm= studentdm;
		this.mGUI = maingui;
                this.lGUI =sblgui; 
                this.snafGUI = sbnagui;
		attachHandlers();
	}
    
    public void attachHandlers()
        {
            
            utrgviv.setFitWidth(700);
            utrgviv.setFitHeight(500);
            stc.setFitWidth(700);
            stc.setFitHeight(500);
            
            
            
            
            
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
                         System.out.println("lastname " +myRs.getString("lastname"));
                         

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
                
     Database mydb = Database.getSingletonOfdatabase();
   
      
     try{
   
         Connection conn=  mydb.getConn();
         Statement mystmt = conn.createStatement();
        
     String school1 = "UTRGV";
     String school2 = "STC";
     if (lGUI.notEmpty(lGUI.getUserNameTF(), lGUI.getPasswordTF()) == true )
     { 
          
     
     ResultSet myrs1 = mystmt.executeQuery("SELECT username,sbpassword,school FROM student");
     
       
         
         while(myrs1.next()){
             System.out.println(myrs1.getString("sbpassword"));
           System.out.println(myrs1.getString("username"));
       if ((lGUI.getUserNameTF().getText().equals(myrs1.getString("username"))) && (lGUI.getPasswordTF().getText().equals(myrs1.getString("sbpassword")))&&
              (school1.equals(myrs1.getString("school"))))
       {
           
                   System.out.println("pass");
               
                 mGUI.getWelcomeLBL().setText("Welcome " + lGUI.getUserNameTF().getText());
                   mGUI.setStyle("-fx-background-color: #FAD7A0");
           mGUI.getAppvbox().setStyle("-fx-background-color: #52C286");
        
      VBox myvbox = new VBox();
      myvbox.getChildren().addAll(mGUI.getWelcomeLBL(),utrgviv);
       myvbox.setAlignment(Pos.CENTER);
     mGUI.add(myvbox, 3, 0); 
     
       }
      if ((lGUI.getUserNameTF().getText().equals(myrs1.getString("username"))) && (lGUI.getPasswordTF().getText().equals(myrs1.getString("sbpassword")))&&
              (school2.equals(myrs1.getString("school"))))
       {
           mGUI.setStyle("-fx-background-color: #BB8FCE");
           mGUI.getAppvbox().setStyle("-fx-background-color: #AB98D9");
           mGUI.getWelcomeLBL().setText("Welcome " + lGUI.getUserNameTF().getText());
       
              VBox myvbox2 = new VBox();
              myvbox2.setAlignment(Pos.CENTER);
      myvbox2.getChildren().addAll(mGUI.getWelcomeLBL(),stc);
     mGUI.add(myvbox2, 3, 0);
     
       }
 
         
       
      
      
       
  
      
       }
         
              primaryStage.close();
      
     
 
       
       Stage window = new Stage();
       
       
    
       
		 BorderPane root = new BorderPane();
                 root.setCenter(mGUI);
                 root.setRight(mGUI.getAppvbox());
                 root.setLeft(mGUI.getFriendBox());
               
	
             Scene   scene3 = new Scene(root,1000,1000);
                
		
	    
        
       window.setTitle("Study Buddy");
       
        window.setScene(scene3);
        window.show(); 
         
       
  
    
                
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
                     
                       Connection Conn = Database.getSingletonOfdatabase().getConn();
                   Statement mystmt = Conn.createStatement();
                   ResultSet myrs = mystmt.executeQuery("SELECT username,studentid from student");
                   
                   while(myrs.next())
                   {
                               if(snafGUI.getUnameTF().getText().equals(myrs.getString("username")))
                                       {
                                                Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("USERNAME ALREADY EXISTS");
                    errorAlert.setContentText("Sorry that username is already taken!!");
                        
                    errorAlert.showAndWait();
                  
                                           System.out.println("it worked");
                                       break;
                                       }
           
                   }
                
                   
                           if(snafGUI.getFnameTF().getText().isEmpty())
                 {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("INVALID USERNAME");
                    errorAlert.setContentText("Username must not be blank!!");
                        
                    errorAlert.showAndWait();
                
             
         
                 
             }
                 
                        if(snafGUI.getLnameTF().getText().isEmpty())
                 {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("INVALID PASSWORD");
                    errorAlert.setContentText("Password must not be blank!!!");
                        
                    errorAlert.showAndWait();
                
             
         
                 
             }
                   
                 
                if(snafGUI.notEmpty(snafGUI.getFnameTF(),snafGUI.getLnameTF(),snafGUI.getUnameTF(),snafGUI.getPassTF(),snafGUI.getEmailTF(),snafGUI.getMajorlabelTF())==true)
                         {
                        
                      myrs.beforeFirst();
                             int x = 0; 
                             if (myrs.next()==false)
                             {
                                  x = 1; 
                                  
                                  
                                  
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
                                 
                                 
                             }
                             else {
                             myrs.beforeFirst();
                             while (myrs.next()){
                      
                             if (!(myrs.getString("username").equals(snafGUI.getUnameTF().getText() )))
                             {
                             myrs.afterLast();
                             myrs.previous();
                             x = myrs.getInt("studentid") + 1;
                            
                                 System.out.println(x);
                               
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
                    myrs.beforeFirst();
                          
                                        try
        {        String host = "smtp.outlook.com";
		String eport = "587";
		String emailFrom = "studybuddyutrgv@outlook.com";
		String epassword = "utrgv123";

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
       
       
                         }

                 
             }
            	  
                else
                {
                    System.out.println("one of the field was left blank");
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
                     mGUI.getChildren().remove(mGUI.getFriendSearchBTN()); 
                     
                     Label nflabel = new Label("A Request was sent to " + mGUI.getNewFriendTF().getText());
                    
                        mGUI.add(mGUI.getNewFriendLBL(), 3, 1);
                     mGUI.add(mGUI.getNewFriendTF(), 3, 2);
                     mGUI.add(mGUI.getAddFriendBTN(), 3, 3);
                     
                     
                     
             }
         }
                            );
           
               
               
                  
                        mGUI.getAddFriendBTN().setOnAction(
                   
                    new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             {
                      mGUI.getChildren().remove(mGUI.getAddFriendBTN());
                       mGUI.getChildren().remove(mGUI.getNewFriendTF());
               
                     mGUI.add(mGUI.getAddFriendSLabel(),3,3);
                     mGUI.add(mGUI.getDoneBTN(), 4,3);
                  
;
             }
         }
                            );
               
               
               
                               mGUI.getDoneBTN().setOnAction(
                   
                    new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             {
                      mGUI.getChildren().remove(mGUI.getDoneBTN());
                       mGUI.getChildren().remove(mGUI.getAddFriendSLabel());
                               
              
                    mGUI.add( mGUI.getFriendSearchBTN(),1,3);
;
             }
         }
                            ); 
               
               
               
               
               
               
           
           
           
           }
    
}
