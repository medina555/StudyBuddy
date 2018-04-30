/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import DATAMODEL.Group;
import DATAMODEL.GroupDataModel;
import GUI.SBCreateGroupGUI;
import GUI.SBMainGUI;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Andrew
 */
public class GroupController {
    Group group;
    ArrayList<Group> grouplist = new ArrayList();
   SBCreateGroupGUI creatgroupGUI = new SBCreateGroupGUI();
   SBMainGUI sbmain; 
   GroupDataModel gdm = new GroupDataModel();
   
   
    public GroupController( GroupDataModel gdmm, SBCreateGroupGUI cg, SBMainGUI smain)
    {

    this.grouplist = grouplist;
    this.creatgroupGUI = cg; 
    this.sbmain = smain; 
    attachHandlers();
}

    private void attachHandlers() {
        
         
                 sbmain.getCreateGroupBTN().setOnAction(
                          
            
                    
                    new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             {
                    Stage window = new Stage();
                 VBox gvbox =  new SBCreateGroupGUI();
       
    
       
		
               
                 BorderPane root2 = new BorderPane();
                 root2.setCenter(gvbox);
	
             Scene   scene3 = new Scene(root2,1000,1000);
                
		
	    
        
       window.setTitle("Create New Group");
       
        window.setScene(scene3);
        window.show();
              
          
             }
         }
                            );
        
    }
}