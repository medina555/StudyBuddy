/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Andrew
 */
public class SBNewAccountFormGUI extends GridPane 
{

    /**
     * @return the MajorBox
     */
    public ChoiceBox<String> getMajorBox() {
        return MajorBox;
    }

    /**
     * @param MajorBox the MajorBox to set
     */
    public void setMajorBox(ChoiceBox<String> MajorBox) {
        this.MajorBox = MajorBox;
    }


    /**
     * @return the NATitle
     */
    public Label getNATitle() {
        return NATitle;
    }

    /**
     * @param NATitle the NATitle to set
     */
    public void setNATitle(Label NATitle) {
        this.NATitle = NATitle;
    }

    /**
     * @return the majorlabelTF
     */
    public TextField getMajorlabelTF() {
        return majorlabelTF;
    }

    /**
     * @param majorlabelTF the majorlabelTF to set
     */
    public void setMajorlabelTF(TextField majorlabelTF) {
        this.majorlabelTF = majorlabelTF;
    }

    /**
     * @return the EmailBox
     */
    public ChoiceBox<String> getEmailBox() {
        return EmailBox;
    }

    /**
     * @param EmailBox the EmailBox to set
     */
    public void setEmailBox(ChoiceBox<String> EmailBox) {
        this.EmailBox = EmailBox;
    }

    /**
     * @return the unameTF
     */
    public TextField getUnameTF() {
        return unameTF;
    }

    /**
     * @param unameTF the unameTF to set
     */
    public void setUnameTF(TextField unameTF) {
        this.unameTF = unameTF;
    }

    /**
     * @return the passTF
     */
    public TextField getPassTF() {
        return passTF;
    }

    /**
     * @param passTF the passTF to set
     */
    public void setPassTF(TextField passTF) {
        this.passTF = passTF;
    }

    /**
     * @return the SchoolBox
     */
    public ChoiceBox<String> getSchoolBox() {
        return SchoolBox;
    }

    /**
     * @param SchoolBox the SchoolBox to set
     */
    public void setSchoolBox(ChoiceBox<String> SchoolBox) {
        this.SchoolBox = SchoolBox;
    }

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
     * @return the CreateAccBTN
     */
    public Button getCreateAccBTN() {
        return CreateAccBTN;
    }

    /**
     * @param CreateAccBTN the CreateAccBTN to set
     */
    public void setCreateAccBTN(Button CreateAccBTN) {
        this.CreateAccBTN = CreateAccBTN;
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
     private ChoiceBox<String> SchoolBox = new ChoiceBox<String>();
     
     private ChoiceBox<String> EmailBox = new ChoiceBox<String>();
     
     
      private ChoiceBox<String> MajorBox = new ChoiceBox<String>();
     
     
       
    
    ImageView iv = new ImageView();
   Image image = new Image("studygroup.png");
   
   
  
    
   public String getSchoolChoice(ChoiceBox<String> schoice)
   {
       String school = schoice.getValue();
       
       return school; 
   }
    
    
    
        private Button CreateAccBTN = new Button("create account");
    private Button exitBTN = new Button("Back To Login Screen");
    private Label fname = new Label ("First Name:");
    private Label lname = new Label ("Last Name:");
     private Label uname = new Label ("Username:");
      private Label pass = new Label ("Password:");
     private Label email = new Label ("Email Address:");
     private Label slabel = new Label ("Please Select Your Campus ");
     private Label majorlabel = new Label ("Major: ");
      private RadioButton MButton = new RadioButton("Male");
    private RadioButton FButton = new RadioButton ("Female");
    private Label NATitle = new Label("New Studdy Buddy Account Form");
     
    
     private TextField fnameTF = new TextField();
    private TextField lnameTF = new TextField();
     private TextField unameTF = new TextField();
    private TextField passTF = new TextField();
    
    private TextField emailTF = new TextField();
        private TextField majorlabelTF = new TextField();
            private HBox RButtonhbox = new HBox();
            
            
      public boolean isEmpty(TextField tf1, TextField tf2,TextField tf3, TextField tf4)
              
      { boolean ne = false; 
          if (tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf3.getText().isEmpty()||tf4.getText().isEmpty())
          {
              ne = true;
              
          }
          return ne; 
      }
      
      
      
      
      
         public void clearFields()
              
      {
          fnameTF.clear();
          lnameTF.clear();
          majorlabelTF.clear();
          emailTF.clear();
          passTF.clear();
          unameTF.clear();
   
      }
      
      
      
      
      
      
      
      
      
      
      
      
    public SBNewAccountFormGUI()
    {
        
        NATitle.setStyle("-fx-text-fill: white;");
        fname.setStyle("-fx-text-fill: white;");
        lname.setStyle("-fx-text-fill: white;");
        email.setStyle("-fx-text-fill: white;");
        slabel.setStyle("-fx-text-fill: white;");
        uname.setStyle("-fx-text-fill: white;");
        pass.setStyle("-fx-text-fill: white;");
        majorlabel.setStyle("-fx-text-fill: white;");
        
         this.setStyle("-fx-background-image: url('sblogin1.jpg')");
       this.setWidth(500);
       this.setHeight(500);
          
        SchoolBox.getItems().add("UTRGV");
        SchoolBox.getItems().add("TSC");
        SchoolBox.getItems().add("STC");
        SchoolBox.setValue("UTRGV");
        
        
        EmailBox.getItems().add("@gmail.com");
        EmailBox.getItems().add("@utrgv.edu");
        EmailBox.getItems().add("@outlook.com");
        EmailBox.getItems().add("@yahoo.com");
        
        EmailBox.setValue("@utrgv.edu");
        
        MajorBox.getItems().add("CSCI");
        MajorBox.getItems().add("ART");
        MajorBox.getItems().add("ENG");
        MajorBox.getItems().add("MATH");
         MajorBox.getItems().add("CMPE");
         MajorBox.setValue("CSCI");
        
        
         
            this.setVgap(20);
        RButtonhbox.getChildren().addAll(MButton,FButton);
        NATitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 30));
        this.addRow(1, NATitle);
        this.addRow(2,fname,fnameTF);
        this.addRow(3,lname,lnameTF);
        this.addRow(4,uname,unameTF);
        this.addRow(5,pass,passTF);
        this.addRow(6, email,emailTF,EmailBox);
         this.addRow(7,slabel,SchoolBox);
         this.addRow(8,majorlabel,MajorBox);
        this.addRow(9,CreateAccBTN);
         
		
    }
    
    
    
}
