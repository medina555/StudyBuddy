/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Andrew
 */
public class SBCreateGroupGUI extends VBox{

    /**
     * @return the gidLBL
     */
    public Label getGidLBL() {
        return gidLBL;
    }

    /**
     * @param gidLBL the gidLBL to set
     */
    public void setGidLBL(Label gidLBL) {
        this.gidLBL = gidLBL;
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
     * @return the ginstructorLBL
     */
    public Label getGinstructorLBL() {
        return ginstructorLBL;
    }

    /**
     * @param ginstructorLBL the ginstructorLBL to set
     */
    public void setGinstructorLBL(Label ginstructorLBL) {
        this.ginstructorLBL = ginstructorLBL;
    }

    /**
     * @return the gidTF
     */
    public TextField getGidTF() {
        return gidTF;
    }

    /**
     * @param gidTF the gidTF to set
     */
    public void setGidTF(TextField gidTF) {
        this.gidTF = gidTF;
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
     private Label gidLBL = new Label ("Group ID:");
    private Label gnameLBL = new Label ("Group Name");
     private Label cidLBL = new Label ("Course ID Number");
      private Label subLBL = new Label ("Subject");
     private Label ginstructorLBL = new Label ("Course Instructor");
    
    
          private TextField gidTF = new TextField();
     private TextField gnameTF = new TextField();
    private TextField cidTF = new TextField();
     private TextField subTF = new TextField();
    private TextField ginstructorTF = new TextField();
    
    private Button SubmitBTN = new Button("Submit Data");
     
     public SBCreateGroupGUI()
     {
         this.getChildren().addAll(gidLBL,gidTF,gnameLBL,gnameTF,cidLBL,cidTF,subLBL,subTF,ginstructorLBL,ginstructorTF);
         
     }
     
    
    
}
