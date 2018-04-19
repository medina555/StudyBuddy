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
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Andrew
 */
public class SBController {
    
   SBMainGUI mGUI;
   StudentDataModel sdm;
   SBLoginGUI lGUI ;
   SBNewAccountFormGUI snafGUI;
   
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
           
           
           
                   lGUI.getLoginBTN().setOnAction(new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             { 
                
                
                
                 
                  Alert errorAlert = new Alert(AlertType.INFORMATION);
                    errorAlert.setHeaderText("LOGIN SUCESSFULLY");
                    errorAlert.setContentText("WELCOME " + lGUI.getUserNameTF().getText());
                        
                    errorAlert.showAndWait();
        
                    
             
                
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
