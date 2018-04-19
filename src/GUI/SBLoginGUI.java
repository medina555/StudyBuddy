/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public TextField getPasswordTF() {
        return PasswordTF;
    }

    /**
     * @param PasswordTF the PasswordTF to set
     */
    public void setPasswordTF(TextField PasswordTF) {
        this.PasswordTF = PasswordTF;
    }

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
    private TextField UserNameTF = new TextField();
    private TextField PasswordTF = new TextField();
    private VBox LoginVB = new VBox(10);
    private HBox ButtonHB = new HBox();
    private Label Title = new Label ("Welcome to Study Buddy!");
    private Label CopyWrite = new Label ("Omnibus Inc " + "\u00a9");

    
    
    ImageView iv = new ImageView();
   Image image = new Image("studygroup.png");
   
    
    public SBLoginGUI()
    {
        
     this.setStyle("-fx-background-color: #C0C0C0;");
     iv.setImage(image);
     iv.setFitHeight(100);
     iv.setFitWidth(100);
     
        this.setAlignment(Pos.CENTER);
    
        Title.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Title.setPadding(new Insets(10,10,50,10));
        LoginVB.getChildren().addAll(UserNameLBL,UserNameTF,PassWordLBL,PasswordTF);
        ButtonHB.getChildren().addAll(CreateAccountBTN,LoginBTN);
        this.addRow(0,iv);
        this.addRow(1,Title);
        this.addRow(2, LoginVB);
        this.addRow(3, ButtonHB);
        this.add(CopyWrite,4,4);
    }


    
}
