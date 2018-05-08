/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import DATAMODEL.GroupDataModel;
import DATAMODEL.StudentDataModel;
import GUI.SBAddFriend;
import GUI.SBCreateGroupGUI;
import GUI.SBLoginGUI;
import GUI.SBMainGUI;
import GUI.SBNewAccountFormGUI;
import MVC.GroupController;
import MVC.SBController;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Andrew
 */
public class SBMain extends Application {

   

    
   
   public  Stage window;
    Scene scene2;
    Scene scene3;
     public SBMain()
     {
         
     };
    @Override
    public void start(Stage primaryStage) {
       window = primaryStage;
       SBMainGUI mgui= new SBMainGUI();
       StudentDataModel sdmodel = new StudentDataModel();
       SBLoginGUI sblogingui = new SBLoginGUI();
       SBNewAccountFormGUI sbnafGUI = new SBNewAccountFormGUI();
       SBAddFriend sbafGUI = new SBAddFriend();
       GroupDataModel gdm = new GroupDataModel();
       SBCreateGroupGUI cGUI = new SBCreateGroupGUI();
       
       
       
       
      SBController sc = new SBController(mgui,sdmodel,sblogingui,sbnafGUI,sbafGUI);
      GroupController gc = new GroupController(gdm,cGUI,mgui);
       
		sc.setPrimaryStage(window);
               
                
               
             
		Scene scene = new Scene(sblogingui, 1000, 500,Color.BLUE);
             sc.setScene(scene);
 
      
            
	
	 
        
        primaryStage.setTitle("Study Buddy");
      
        primaryStage.setScene(scene);
        primaryStage.show();      
         
      
   
      
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
