/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Andrew
 */
public class SBMainGUI extends GridPane{

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
     * @return the id
     */
    public Label getmyId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Label id) {
        this.id = id;
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
     * @return the idTF
     */
    public TextField getIdTF() {
        return idTF;
    }

    /**
     * @param idTF the idTF to set
     */
    public void setIdTF(TextField idTF) {
        this.idTF = idTF;
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
    public Button getBtn2() {
        return btn2;
    }

    /**
     * @param btn2 the btn2 to set
     */
    public void setBtn2(Button btn2) {
        this.btn2 = btn2;
    }
    private Button btn1 = new Button("print data");
    private Button btn2 = new Button("store data");
    private Label fname = new Label ("First Name");
    private Label lname = new Label ("Last Name");
     private Label id = new Label ("ID Number");
     private TextField fnameTF = new TextField();
    private TextField lnameTF = new TextField();
    private TextField idTF = new TextField();
    public SBMainGUI()
    {
        this.addRow(0,btn1);
        this.addRow(1,btn2);
        this.addRow(2,fname,fnameTF);
        this.addRow(3,lname,lnameTF);
        this.addRow(4,id,idTF);
    
         
		
    }
   

    
}
