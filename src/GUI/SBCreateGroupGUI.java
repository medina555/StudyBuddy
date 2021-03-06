/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Andrew
 */
public class SBCreateGroupGUI extends VBox{

    /**
     * @return the SubmitBTN
     */
    public Button getSubmitBTN() {
        return SubmitBTN;
    }

    /**
     * @param SubmitBTN the SubmitBTN to set
     */
    public void setSubmitBTN(Button SubmitBTN) {
        this.SubmitBTN = SubmitBTN;
    }

    /**
     * @return the glist
     */
    public ListView<String> getGlist() {
        return glist;
    }

    /**
     * @param glist the glist to set
     */
    public void setGlist(ListView<String> glist) {
        this.glist = glist;
    }

 
    /**
     * @return the gnameLBL
     */
    public Label getGnameLBL() {
        return gnameLBL;
    }

    /**
     * @param gnameLBL the gnameLBL to set
     */
    public void setGnameLBL(Label gnameLBL) {
        this.gnameLBL = gnameLBL;
    }

    /**
     * @return the cidLBL
     */
    public Label getCidLBL() {
        return cidLBL;
    }

    /**
     * @param cidLBL the cidLBL to set
     */
    public void setCidLBL(Label cidLBL) {
        this.cidLBL = cidLBL;
    }

    /**
     * @return the subLBL
     */
    public Label getSubLBL() {
        return subLBL;
    }

    /**
     * @param subLBL the subLBL to set
     */
    public void setSubLBL(Label subLBL) {
        this.subLBL = subLBL;
    }

    /**
     * @return the dowLBL
     */
    public Label getDowLBL() {
        return dowLBL;
    }

    /**
     * @param dowLBL the dowLBL to set
     */
    public void setDowLBL(Label dowLBL) {
        this.dowLBL = dowLBL;
    }

  

    /**
     * @return the gnameTF
     */
    public TextField getGnameTF() {
        return gnameTF;
    }

    /**
     * @param gnameTF the gnameTF to set
     */
    public void setGnameTF(TextField gnameTF) {
        this.gnameTF = gnameTF;
    }

    /**
     * @return the cidTF
     */
    public TextField getCidTF() {
        return cidTF;
    }

    /**
     * @param cidTF the cidTF to set
     */
    public void setCidTF(TextField cidTF) {
        this.cidTF = cidTF;
    }

    /**
     * @return the subTF
     */
    public TextField getSubTF() {
        return subTF;
    }

    /**
     * @param subTF the subTF to set
     */
    public void setSubTF(TextField subTF) {
        this.subTF = subTF;
    }

    /**
     * @return the ginstructorTF
     */
    public TextField getGinstructorTF() {
        return ginstructorTF;
    }

    /**
     * @param ginstructorTF the ginstructorTF to set
     */
    public void setGinstructorTF(TextField ginstructorTF) {
        this.ginstructorTF = ginstructorTF;
    }
  
    private Label gnameLBL = new Label ("Group Name");
     private Label cidLBL = new Label ("Course ID Number");
      private Label subLBL = new Label ("Subject");
     private Label dowLBL = new Label ("Days of Week (MW or TTh");
    
    
      
     private TextField gnameTF = new TextField();
    private TextField cidTF = new TextField();
     private TextField subTF = new TextField();
    private TextField ginstructorTF = new TextField();
    
    private Button SubmitBTN = new Button("Submit Data");
       private ListView<String> glist = new ListView(); 
    
    
    
     public SBCreateGroupGUI()
            
     {
       this.setStyle("-fx-background-color: #80e5ff");
  
          gnameTF.setMaxSize(300, 20);
          cidTF.setMaxSize(300,20);
          subTF.setMaxSize(300,20);
          ginstructorTF.setMaxSize(300,200);
         this.getChildren().addAll(gnameLBL,gnameTF,cidLBL,cidTF,subLBL,subTF,dowLBL,ginstructorTF, SubmitBTN);
         
         
     }
     
    public void clearfieldgroup()
    {
     
        cidTF.clear();
        gnameTF.clear();
        ginstructorTF.clear();
        subTF.clear();
    }
    
}
