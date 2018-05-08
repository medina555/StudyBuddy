/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Andrew
 */
public class SBNewEmailForm extends VBox{

    /**
     * @return the etoLBL
     */
    public Label getEtoLBL() {
        return etoLBL;
    }

    /**
     * @param etoLBL the etoLBL to set
     */
    public void setEtoLBL(Label etoLBL) {
        this.etoLBL = etoLBL;
    }

    /**
     * @return the esub
     */
    public Label getEsub() {
        return esub;
    }

    /**
     * @param esub the esub to set
     */
    public void setEsub(Label esub) {
        this.esub = esub;
    }

    /**
     * @return the emessage
     */
    public Label getEmessage() {
        return emessage;
    }

    /**
     * @param emessage the emessage to set
     */
    public void setEmessage(Label emessage) {
        this.emessage = emessage;
    }

    /**
     * @return the fileLBL
     */
    public Label getFileLBL() {
        return fileLBL;
    }

    /**
     * @param fileLBL the fileLBL to set
     */
    public void setFileLBL(Label fileLBL) {
        this.fileLBL = fileLBL;
    }

    /**
     * @return the etoTF
     */
    public TextField getEtoTF() {
        return etoTF;
    }

    /**
     * @param etoTF the etoTF to set
     */
    public void setEtoTF(TextField etoTF) {
        this.etoTF = etoTF;
    }

    /**
     * @return the esubTF
     */
    public TextField getEsubTF() {
        return esubTF;
    }

    /**
     * @param esubTF the esubTF to set
     */
    public void setEsubTF(TextField esubTF) {
        this.esubTF = esubTF;
    }

    /**
     * @return the emessageTF
     */
    public TextArea getEmessageTF() {
        return emessageTF;
    }

    /**
     * @param emessageTF the emessageTF to set
     */
    public void setEmessageTF(TextArea emessageTF) {
        this.emessageTF = emessageTF;
    }

    /**
     * @return the fileTF
     */
    public TextField getFileTF() {
        return fileTF;
    }

    /**
     * @param fileTF the fileTF to set
     */
    public void setFileTF(TextField fileTF) {
        this.fileTF = fileTF;
    }

    /**
     * @return the eSubmitBTN
     */
    public Button geteSubmitBTN() {
        return eSubmitBTN;
    }

    /**
     * @param eSubmitBTN the eSubmitBTN to set
     */
    public void seteSubmitBTN(Button eSubmitBTN) {
        this.eSubmitBTN = eSubmitBTN;
    }
    
    private Label etoLBL = new Label ("Email To:");
    private Label esub = new Label ("Email Subject");
     private Label emessage = new Label ("Email Message");
      private Label fileLBL = new Label ("Please enter filename you wish to send");
     
  
   
    
          private TextField etoTF = new TextField();
     private TextField esubTF = new TextField();
    private TextArea emessageTF = new TextArea();
     private TextField fileTF = new TextField();
  
    
    private Button eSubmitBTN = new Button("Send Email");
    
    
    
      public SBNewEmailForm()
            
     {
        
              this.setStyle("-fx-text-fill: white;");
       etoLBL.setStyle("-fx-text-fill: white;");
      esub.setStyle("-fx-text-fill: white;");
        emessage.setStyle("-fx-text-fill: white;");
        fileLBL.setStyle("-fx-text-fill: white;");
    
         this.setStyle("-fx-background-image: url('sblogin1.jpg')");
         
          etoTF.setMaxSize(300,20);
          esubTF.setMaxSize(300, 20);
          emessageTF.setMaxSize(300,20);
          fileTF.setMaxSize(300,20);
          
         this.getChildren().addAll(etoLBL,etoTF,esub,esubTF,emessage,emessageTF, eSubmitBTN);
         
         
     }
    
    
    
    
    
    
    
    
    
    
    
}
