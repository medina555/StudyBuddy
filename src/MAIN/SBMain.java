/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import DATAMODEL.StudentDataModel;
import GUI.SBLoginGUI;
import GUI.SBMainGUI;
import GUI.SBNewAccountFormGUI;
import MVC.SBController;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Andrew
 */
public class SBMain extends Application {
    Stage window;
    Scene scene2;
    Scene scene3;
    @Override
    public void start(Stage primaryStage) {
     window = primaryStage;
       SBMainGUI mgui= new SBMainGUI();
       StudentDataModel sdmodel = new StudentDataModel();
       SBLoginGUI sblogingui = new SBLoginGUI();
       SBNewAccountFormGUI sbnafGUI = new SBNewAccountFormGUI();
       
       
       
       
      SBController sc = new SBController(mgui,sdmodel,sblogingui,sbnafGUI);
       
		
		Scene scene = new Scene(sblogingui, 1000, 500,Color.BLUE);
                scene2 = new Scene(sbnafGUI,250,600,Color.BLUE);
                scene3 = new Scene(mgui,1000,1000);
                
		
	        sblogingui.getCreateAccountBTN().setOnAction(e -> window.setScene(scene2));
                sblogingui.getLoginBTN().setOnAction(e -> window.setScene(scene3));
                sbnafGUI.getExitBTN().setOnAction(e -> window.setScene(scene));
                mgui.getLogoutBTN().setOnAction(e -> window.setScene(scene));
        
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
