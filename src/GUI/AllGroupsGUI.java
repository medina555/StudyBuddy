/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

/**
 *
 * @author Andrew
 */
public class AllGroupsGUI extends GridPane {

    /**
     * @return the joingroupBTN
     */
    public Button getJoingroupBTN() {
        return joingroupBTN;
    }

    /**
     * @param joingroupBTN the joingroupBTN to set
     */
    public void setJoingroupBTN(Button joingroupBTN) {
        this.joingroupBTN = joingroupBTN;
    }

    /**
     * @return the grouplist1
     */
    public ListView<String> getGrouplist1() {
        return grouplist1;
    }

    /**
     * @param grouplist1 the grouplist1 to set
     */
    public void setGrouplist1(ListView<String> grouplist1) {
        this.grouplist1 = grouplist1;
    }

    /**
     * @return the showgroupinfo
     */
    public Button getShowgroupinfo() {
        return showgroupinfo;
    }

    /**
     * @param showgroupinfo the showgroupinfo to set
     */
    public void setShowgroupinfo(Button showgroupinfo) {
        this.showgroupinfo = showgroupinfo;
    }

    /**
     * @return the avalue
     */
    public String getAvalue() {
        return avalue;
    }

    /**
     * @param avalue the avalue to set
     */
    public void setAvalue(String avalue) {
        this.avalue = avalue;
    }

    /**
     * @return the alltable
     */
    public TableView getAlltable() {
        return alltable;
    }

    /**
     * @param alltable the alltable to set
     */
    public void setAlltable(TableView alltable) {
        this.alltable = alltable;
    }

    /**
     * @return the groupname
     */
    public TableColumn getGroupname() {
        return groupname;
    }

    /**
     * @param groupname the groupname to set
     */
    public void setGroupname(TableColumn groupname) {
        this.groupname = groupname;
    }

    /**
     * @return the groupid
     */
    public TableColumn getGroupid() {
        return groupid;
    }

    /**
     * @param groupid the groupid to set
     */
    public void setGroupid(TableColumn groupid) {
        this.groupid = groupid;
    }

    /**
     * @return the groupsub
     */
    public TableColumn getGroupsub() {
        return groupsub;
    }

    /**
     * @param groupsub the groupsub to set
     */
    public void setGroupsub(TableColumn groupsub) {
        this.groupsub = groupsub;
    }

    /**
     * @return the groupinst
     */
    public TableColumn getGroupinst() {
        return groupinst;
    }

    /**
     * @param groupinst the groupinst to set
     */
    public void setGroupinst(TableColumn groupinst) {
        this.groupinst = groupinst;
    }
     private TableView alltable = new TableView();
     private TableColumn groupname = new TableColumn("Group Name");
    private TableColumn groupid = new TableColumn("Group ID");
   
    private TableColumn groupsub = new TableColumn("Course Subject");
    private TableColumn groupinst = new TableColumn("Days of Week ");
     private String avalue = "";
  

    /**
     * @return the grouplabel
     */
    public Label getGrouplabel() {
        return grouplabel;
    }

    /**
     * @param grouplabel the grouplabel to set
     */
    public void setGrouplabel(Label grouplabel) {
        this.grouplabel = grouplabel;
    }
    
 
    SBMainGUI sbmain = new SBMainGUI();
    
      private ListView<String> grouplist1 = new ListView();
      
      
      
      
      
  

        
      
      
      
      
      
      
      
      
      
      
       private Label grouplabel = new Label ("Showing All Groups");
       private Button showgroupinfo = new Button ("Show Group Members/Info");
       private Button joingroupBTN= new Button ("Join Group");
      public AllGroupsGUI()
      {
          
            alltable.setEditable(true);
          alltable.getColumns().addAll(groupname,groupsub,groupinst);
          
          
          
          
                             alltable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(alltable.getSelectionModel().getSelectedItem() != null) 
        {   
           TableView.TableViewSelectionModel selectionModel = alltable.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
         
           System.out.println("Selected Value" + val);
           avalue = String.valueOf(val);
            System.out.println(avalue);
         }
         }
     });
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
           this.setStyle("-fx-background-color: #80e5ff");
        grouplabel.setFont(Font.font("Times New Roman", FontPosture.REGULAR, 20));
          this.addRow(1,grouplabel,showgroupinfo);
          this.addRow(2,alltable);
       
      }
    
    
    
    
}
