/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Andrew
 */
public class SBNewAccountFormGUI extends GridPane 
{

    /**
     * @return the RButtonhbox
     */
    public HBox getRButtonhbox() {
        return RButtonhbox;
    }

    /**
     * @param RButtonhbox the RButtonhbox to set
     */
    public void setRButtonhbox(HBox RButtonhbox) {
        this.RButtonhbox = RButtonhbox;
    }

    /**
     * @return the MButton
     */
    public RadioButton getMButton() {
        return MButton;
    }

    /**
     * @param MButton the MButton to set
     */
    public void setMButton(RadioButton MButton) {
        this.MButton = MButton;
    }

    /**
     * @return the FButton
     */
    public RadioButton getFButton() {
        return FButton;
    }

    /**
     * @param FButton the FButton to set
     */
    public void setFButton(RadioButton FButton) {
        this.FButton = FButton;
    }

    /**
     * @return the exitBTN
     */
    public Button getExitBTN() {
        return exitBTN;
    }

    /**
     * @param exitBTN the exitBTN to set
     */
    public void setExitBTN(Button exitBTN) {
        this.exitBTN = exitBTN;
    }

    /**
     * @return the btn1
     */
    public Button getBtn1() {
        return btn1;
    }

    /**
     * @param btn1 the btn1 to set
     */
    public void setBtn1(Button btn1) {
        this.btn1 = btn1;
    }

    /**
     * @return the btn2
     */


    /**
     * @return the fname
     */
    public Label getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(Label fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public Label getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(Label lname) {
        this.lname = lname;
    }

    /**
     * @return the email
     */
    public Label getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(Label email) {
        this.email = email;
    }

    /**
     * @return the fnameTF
     */
    public TextField getFnameTF() {
        return fnameTF;
    }

    /**
     * @param fnameTF the fnameTF to set
     */
    public void setFnameTF(TextField fnameTF) {
        this.fnameTF = fnameTF;
    }

    /**
     * @return the lnameTF
     */
    public TextField getLnameTF() {
        return lnameTF;
    }

    /**
     * @param lnameTF the lnameTF to set
     */
    public void setLnameTF(TextField lnameTF) {
        this.lnameTF = lnameTF;
    }

    /**
     * @return the emailTF
     */
    public TextField getEmailTF() {
        return emailTF;
    }

    /**
     * @param emailTF the emailTF to set
     */
    public void setEmailTF(TextField emailTF) {
        this.emailTF = emailTF;
    }
        private Button btn1 = new Button("create account");
    private Button exitBTN = new Button("Back To Login Screen");
    private Label fname = new Label ("First Name:");
    private Label lname = new Label ("Last Name:");
     private Label email = new Label ("Email Address:");
    
      private RadioButton MButton = new RadioButton("Male");
    private RadioButton FButton = new RadioButton ("Female");
     
     
     private TextField fnameTF = new TextField();
    private TextField lnameTF = new TextField();
    private TextField emailTF = new TextField();
            private HBox RButtonhbox = new HBox();
    public SBNewAccountFormGUI()
    {
            this.setStyle("-fx-background-color: #C0C0C0;");
        RButtonhbox.getChildren().addAll(MButton,FButton);
   
        this.addRow(2,fname,fnameTF);
        this.addRow(3,lname,lnameTF);
        this.addRow(4,email,emailTF);
        this.addRow(5, RButtonhbox);
         this.addRow(6,btn1);
        this.addRow(7,exitBTN);
         
		
    }
    
    
    
}
