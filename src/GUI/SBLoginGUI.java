/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Andrew
 */
public class SBLoginGUI extends GridPane {

    /**
     * @return the iv
     */
    public ImageView getIv() {
        return iv;
    }

    /**
     * @param iv the iv to set
     */
    public void setIv(ImageView iv) {
        this.iv = iv;
    }

    /**
     * @return the currentuser
     */
    public String getCurrentuser() {
        return currentuser;
    }

    /**
     * @param currentuser the currentuser to set
     */
    public void setCurrentuser(String currentuser) {
        this.currentuser = currentuser;
    }

    /**
     * @return the PasswordTF
     */
    public PasswordField getPasswordTF() {
        return PasswordTF;
    }

    /**
     * @param PasswordTF the PasswordTF to set
     */
    public void setPasswordTF(PasswordField PasswordTF) {
        this.PasswordTF = PasswordTF;
    }

    /**
     * @return the SchoolBox
     */
 

    /**
     * @return the SchoolLBL
     */
    public Label getSchoolLBL() {
        return SchoolLBL;
    }

    /**
     * @param SchoolLBL the SchoolLBL to set
     */
    public void setSchoolLBL(Label SchoolLBL) {
        this.SchoolLBL = SchoolLBL;
    }

    /**
     * @return the ForgotPWBTN
     */
    public Button getForgotPWBTN() {
        return ForgotPWBTN;
    }

    /**
     * @param ForgotPWBTN the ForgotPWBTN to set
     */
    public void setForgotPWBTN(Button ForgotPWBTN) {
        this.ForgotPWBTN = ForgotPWBTN;
    }


    /**
     * @return the Title
     */
    public Label getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(Label Title) {
        this.Title = Title;
    }

    /**
     * @return the CopyWrite
     */
    public Label getCopyWrite() {
        return CopyWrite;
    }

    /**
     * @param CopyWrite the CopyWrite to set
     */
    public void setCopyWrite(Label CopyWrite) {
        this.CopyWrite = CopyWrite;
    }

    /**
     * @return the CreateAccountBTN
     */
    public Button getCreateAccountBTN() {
        return CreateAccountBTN;
    }

    /**
     * @param CreateAccountBTN the CreateAccountBTN to set
     */
    public void setCreateAccountBTN(Button CreateAccountBTN) {
        this.CreateAccountBTN = CreateAccountBTN;
    }

    /**
     * @return the LoginBTN
     */
    public Button getLoginBTN() {
        return LoginBTN;
    }

    /**
     * @param LoginBTN the LoginBTN to set
     */
    public void setLoginBTN(Button LoginBTN) {
        this.LoginBTN = LoginBTN;
    }

    /**
     * @return the UserNameLBL
     */
    public Label getUserNameLBL() {
        return UserNameLBL;
    }

    /**
     * @param UserNameLBL the UserNameLBL to set
     */
    public void setUserNameLBL(Label UserNameLBL) {
        this.UserNameLBL = UserNameLBL;
    }

    /**
     * @return the PassWordLBL
     */
    public Label getPassWordLBL() {
        return PassWordLBL;
    }

    /**
     * @param PassWordLBL the PassWordLBL to set
     */
    public void setPassWordLBL(Label PassWordLBL) {
        this.PassWordLBL = PassWordLBL;
    }

    /**
     * @return the UserNameTF
     */
    public TextField getUserNameTF() {
        return UserNameTF;
    }

    /**
     * @param UserNameTF the UserNameTF to set
     */
    public void setUserNameTF(TextField UserNameTF) {
        this.UserNameTF = UserNameTF;
    }

    /**
     * @return the PasswordTF
     */
  

    /**
     * @return the LoginVB
     */
    public VBox getLoginVB() {
        return LoginVB;
    }

    /**
     * @param LoginVB the LoginVB to set
     */
    public void setLoginVB(VBox LoginVB) {
        this.LoginVB = LoginVB;
    }

    /**
     * @return the ButtonHB
     */
    public HBox getButtonHB() {
        return ButtonHB;
    }

    /**
     * @param ButtonHB the ButtonHB to set
     */
    public void setButtonHB(HBox ButtonHB) {
        this.ButtonHB = ButtonHB;
    }
  
    private Button CreateAccountBTN = new Button ("Create Account");
    private Button LoginBTN = new Button ("Login");
    private Button ForgotPWBTN = new Button ("Forgot Password?");
    
    private Label UserNameLBL = new Label("Username:");
    private Label PassWordLBL = new Label ("Password:");
     private Label SchoolLBL = new Label ("StuddyBuddy School");
    private TextField UserNameTF = new TextField();
    private PasswordField PasswordTF = new PasswordField();
    private VBox LoginVB = new VBox(10);
    private HBox ButtonHB = new HBox();
    private Label Title = new Label ("Welcome to Study Buddy!");
    private Label CopyWrite = new Label ("Omnibus Inc " + "\u00a9");
   private VBox titlevbox = new VBox();
   private String currentuser;
   
    
    private ImageView iv = new ImageView();
   Image image = new Image("sblogo.JPG");
   
   
  
    public void  clearfieldslogin(TextField tf1, PasswordField tf2)
    {
       tf1.clear();
       tf2.clear();
    }
  
    
    public SBLoginGUI()
    {
      UserNameTF.setPromptText("username");
      PasswordTF.setPromptText("password");
      currentuser = UserNameTF.getText();
     this.setStyle("-fx-background-color: #C0C0C0;");
     this.setStyle("-fx-background-image: url('sblog55.jpg')");
     
     iv.setImage(image);
     iv.setFitHeight(200);
     iv.setFitWidth(300);
     
        this.setAlignment(Pos.CENTER);
     titlevbox.getChildren().addAll(iv);
    
        Title.setPadding(new Insets(10,10,50,10));
        LoginVB.getChildren().addAll(UserNameLBL,UserNameTF,PassWordLBL,PasswordTF);
        ButtonHB.getChildren().addAll(CreateAccountBTN,LoginBTN);
        this.addRow(0,iv);
     
        this.addRow(2, LoginVB);
        this.addRow(3, ButtonHB);
        this.add(CopyWrite,4,4);
    }


    
}
