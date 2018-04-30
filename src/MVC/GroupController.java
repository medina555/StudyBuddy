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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
   SBCreateGroupGUI creatgroupGUI;
   SBMainGUI sbmain; 
   GroupDataModel gdm = new GroupDataModel();
   
       ObservableList<Group> oGroup = FXCollections.observableArrayList(gdm.getGrouplist());   
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
                 VBox gvbox =  creatgroupGUI;
       
    
       
		
               
                 BorderPane root2 = new BorderPane();
                 root2.setCenter(gvbox);
	
             Scene   scene3 = new Scene(root2,1000,1000);
                
		
	    
        
       window.setTitle("Create New Group");
       
        window.setScene(scene3);
        window.show();
              
          
             }
         }
                            );
                 
                 
                 
                 
                      creatgroupGUI.getSubmitBTN().setOnAction(
                          
            
                    
                    new EventHandler<ActionEvent>()
         {
             @Override
             public void handle (ActionEvent event)
             {  
                
                 TableView gview = sbmain.getGrouptable();
                 ArrayList glist2 = gdm.getGrouplist();
             
                 int gid = Integer.parseInt( creatgroupGUI.getGidTF().getText());
                 String gname = creatgroupGUI.getGnameTF().getText();
                 int cid = Integer.parseInt( creatgroupGUI.getCidTF().getText());
                 String ginst =  creatgroupGUI.getGinstructorTF().getText();
                 String gsub = creatgroupGUI.getSubTF().getText();
                 
                 System.out.println("gid = " +gid);
                 
                 Group gr = new Group(gname, gid, gsub, ginst, cid);
                  
                 gdm.setGroup(gr);
                 
                
       
             
              sbmain.getGroupname().setCellValueFactory(
                new PropertyValueFactory<Group, String>("gname"));
                  
              sbmain.getGroupid().setCellValueFactory(
                new PropertyValueFactory<Group, String>("gid"));
                  
              sbmain.getGroupsub().setCellValueFactory(
                new PropertyValueFactory<Group, String>("gsubject"));
                  
              sbmain.getGroupinst().setCellValueFactory(
                new PropertyValueFactory<Group, String>("ginstructor"));
                  
              sbmain.getGroupcid().setCellValueFactory(
                new PropertyValueFactory<Group, String>("gname"));
              
              
              
              
              sbmain.getGrouptable().setItems(oGroup);
              
              oGroup.add(gr);
          
             }
         }
                            );    
                 
                 
                 
                 
                 sbmain.getGrouptable().setItems(oGroup);
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
        
    }
}