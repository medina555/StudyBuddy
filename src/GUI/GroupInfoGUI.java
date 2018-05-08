/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Andrew
 */
public class GroupInfoGUI extends GridPane {

    /**
     * @return the pieChartData
     */
    public ObservableList<PieChart.Data> getPieChartData() {
        return pieChartData;
    }

    /**
     * @param pieChartData the pieChartData to set
     */
    public void setPieChartData(ObservableList<PieChart.Data> pieChartData) {
        this.pieChartData = pieChartData;
    }

    /**
     * @return the memlist
     */
    public ListView<String> getMemlist() {
        return memlist;
    }

    /**
     * @param memlist the memlist to set
     */
    public void setMemlist(ListView<String> memlist) {
        this.memlist = memlist;
    }

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
    
      private ListView<String> memlist = new ListView();
      
      
      
      
      
           private ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("CSCI", 0),
                new PieChart.Data("ART", 0),
                new PieChart.Data("CMPE", 0),
                new PieChart.Data("MATH", 0),
                new PieChart.Data("ENG", 0));
        final PieChart chart = new PieChart(getPieChartData());

        
      
      
      
      
      
      
      
      
      
      
       private Label grouplabel = new Label ("test");
      public GroupInfoGUI()
      {
          this.setStyle("-fx-background-color: #80e5ff");
             chart.setTitle("Students by Major");
          this.addRow(1,grouplabel);
          this.addRow(2,memlist);
          this.add(chart, 2, 1);
      }
    
    
    
    
}
