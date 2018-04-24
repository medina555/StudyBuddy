/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import DATABASE.Database;
import DATAMODEL.Student;
import DATAMODEL.StudentDataModel;
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
                
     
   
 
        
       
       mGUI.getWelcomeLBL().setText("Welcome " + lGUI.getUserNameTF().getText());
       ChoiceBox<String> Schoice =  lGUI.getSchoolBox();
       if (lGUI.getSchoolChoice(Schoice).equals("UTRGV"))
       {
           mGUI.setStyle("-fx-background-color: #FAD7A0");
           mGUI.getAppvbox().setStyle("-fx-background-color: #52C286");
        
      VBox myvbox = new VBox();
      myvbox.getChildren().addAll(mGUI.getWelcomeLBL(),utrgviv);
       myvbox.setAlignment(Pos.CENTER);
     mGUI.add(myvbox, 3, 0);
       }
       if (lGUI.getSchoolChoice(Schoice).equals("STC"))
       {
           mGUI.setStyle("-fx-background-color: #BB8FCE");
           mGUI.getAppvbox().setStyle("-fx-background-color: #AB98D9");
         
              VBox myvbox = new VBox();
              myvbox.setAlignment(Pos.CENTER);
      myvbox.getChildren().addAll(mGUI.getWelcomeLBL(),stc);
     mGUI.add(myvbox, 3, 0);
     
       }
 
          
       
       
       SBNewAccountFormGUI snaf = new SBNewAccountFormGUI();
      
       Scene scene2 = new Scene(snaf);
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
    
                
                
                 
                 Alert errorAlert = new Alert(AlertType.INFORMATION);
                    errorAlert.setHeaderText("LOGIN SUCESSFULLY");
                    errorAlert.setContentText("WELCOME " + lGUI.getUserNameTF().getText());
                        
                    errorAlert.showAndWait();
        
                     
             
                
             
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
           
           
           
            snafGUI.getBtn1().setOnAction(
                   
                    new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             {
                 
                
                 
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
                 
                 
                 else    {
                    Alert errorAlert = new Alert(AlertType.INFORMATION);
                    errorAlert.setHeaderText("ACCOUNT CREATED SUCESSFULLY");
                    errorAlert.setContentText("You can now log in with your new information");
                        
                    errorAlert.showAndWait();
                
                   
         
                 
             }
                 
                 
                 
                 
                 
                 
                 
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
