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
import javafx.scene.control.TextField;

/**
 *
 * @author Andrew
 */
public class SBController {
    
   SBMainGUI mGUI;
   StudentDataModel sdm;
   SBLoginGUI lGUI = new SBLoginGUI();
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
           mGUI.getBtn1().setOnAction(
                   
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
           
           
           
                    mGUI.getBtn2().setOnAction(new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             { int idnum = 0; 
                 Database mydb = sdm.getMydb();
                 ArrayList<Student> stulist1 = sdm.getStulist();
                 String firstname = mGUI.getFnameTF().getText();
                 String lastname = mGUI.getLnameTF().getText();
                 String email = mGUI.getIdTF().getText();
                
                 
                 Student currentStudent = new Student(firstname,lastname,email);
                 sdm.setStudent(currentStudent);
                
               
                 try {   
                      Connection conn = mydb.getConn();
                      PreparedStatement mystmt = conn.prepareStatement("INSERT into students VALUES(?,?,?)");
                      mystmt.setString(1, stulist1.get(0).getFirstname());
                      mystmt.setString(2, stulist1.get(0).getLastname());
                      mystmt.setString(3, stulist1.get(0).getEmail());
                
                     mystmt.executeUpdate();
                 } catch (SQLException ex) {
                     Logger.getLogger(SBController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 catch(NumberFormatException ex){}
                     
             
                
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
                    errorAlert.setContentText("Username must be between 2 and 25 characters");
                        
                    errorAlert.showAndWait();
                
             
         
                 
             }
                 
                        if(snafGUI.getLnameTF().getText().isEmpty())
                 {
                    Alert errorAlert = new Alert(AlertType.ERROR);
                    errorAlert.setHeaderText("INVALID PASSWORD");
                    errorAlert.setContentText("Password must be between 2 and 25 characters");
                        
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
           
           
           
           
           
           
           }
    
}
