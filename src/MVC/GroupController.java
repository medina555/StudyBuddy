/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import DATABASE.Database;
import DATAMODEL.Group;
import DATAMODEL.GroupDataModel;
import GUI.SBCreateGroupGUI;
import GUI.SBLoginGUI;
import GUI.SBMainGUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

    /**
     * @return the oGroup
     */
    public ObservableList<Group> getoGroup() {
        return oGroup;
    }

    /**
     * @param oGroup the oGroup to set
     */
    public void setoGroup(ObservableList<Group> oGroup) {
        this.oGroup = oGroup;
    }
    Group group;
    ArrayList<Group> grouplist = new ArrayList();
   SBCreateGroupGUI creatgroupGUI;
   SBMainGUI sbmain; 
   SBLoginGUI sblogin ; 
        
   GroupDataModel gdm = new GroupDataModel();
  
   
      private ObservableList<Group> oGroup = FXCollections.observableArrayList(gdm.getGrouplist());   
    public GroupController( GroupDataModel gdmm, SBCreateGroupGUI cg, SBMainGUI smain)
    {

    this.grouplist = grouplist;
    this.creatgroupGUI = cg; 
    this.sbmain = smain; 
    attachHandlers();
}

    private void attachHandlers() {
   
         
         
         
               
                 
                 
                 
            
                 
                 
                 
                 
         
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
        
    }
}