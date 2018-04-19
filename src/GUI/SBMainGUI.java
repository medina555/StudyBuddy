/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Andrew
 */
public class SBMainGUI extends GridPane{

    /**
     * @return the DoneBTN
     */
    public Button getDoneBTN() {
        return DoneBTN;
    }

    /**
     * @param DoneBTN the DoneBTN to set
     */
    public void setDoneBTN(Button DoneBTN) {
        this.DoneBTN = DoneBTN;
    }

    /**
     * @return the AddFriendSLabel
     */
    public Label getAddFriendSLabel() {
        return AddFriendSLabel;
    }

    /**
     * @param AddFriendSLabel the AddFriendSLabel to set
     */
    public void setAddFriendSLabel(Label AddFriendSLabel) {
        this.AddFriendSLabel = AddFriendSLabel;
    }

    /**
     * @return the FriendSearchBTN
     */
    public Button getFriendSearchBTN() {
        return FriendSearchBTN;
    }

    /**
     * @param FriendSearchBTN the FriendSearchBTN to set
     */
    public void setFriendSearchBTN(Button FriendSearchBTN) {
        this.FriendSearchBTN = FriendSearchBTN;
    }

    /**
     * @return the NewFriendLBL
     */
    public Label getNewFriendLBL() {
        return NewFriendLBL;
    }

    /**
     * @param NewFriendLBL the NewFriendLBL to set
     */
    public void setNewFriendLBL(Label NewFriendLBL) {
        this.NewFriendLBL = NewFriendLBL;
    }

    /**
     * @return the NewFriendTF
     */
    public TextField getNewFriendTF() {
        return NewFriendTF;
    }

    /**
     * @param NewFriendTF the NewFriendTF to set
     */
    public void setNewFriendTF(TextField NewFriendTF) {
        this.NewFriendTF = NewFriendTF;
    }

    /**
     * @return the DisplaySessionTA
     */
    public TextArea getDisplaySessionTA() {
        return DisplaySessionTA;
    }

    /**
     * @param DisplaySessionTA the DisplaySessionTA to set
     */
    public void setDisplaySessionTA(TextArea DisplaySessionTA) {
        this.DisplaySessionTA = DisplaySessionTA;
    }

    /**
     * @return the CreateAppBTN
     */
    public Button getCreateAppBTN() {
        return CreateAppBTN;
    }

    /**
     * @param CreateAppBTN the CreateAppBTN to set
     */
    public void setCreateAppBTN(Button CreateAppBTN) {
        this.CreateAppBTN = CreateAppBTN;
    }

    /**
     * @return the LogoutBTN
     */
    public Button getLogoutBTN() {
        return LogoutBTN;
    }

    /**
     * @param LogoutBTN the LogoutBTN to set
     */
    public void setLogoutBTN(Button LogoutBTN) {
        this.LogoutBTN = LogoutBTN;
    }

    /**
     * @return the UploadFileBTN
     */
    public Button getUploadFileBTN() {
        return UploadFileBTN;
    }

    /**
     * @param UploadFileBTN the UploadFileBTN to set
     */
    public void setUploadFileBTN(Button UploadFileBTN) {
        this.UploadFileBTN = UploadFileBTN;
    }

    /**
     * @return the WelcomeLBL
     */
    public Label getWelcomeLBL() {
        return WelcomeLBL;
    }

    /**
     * @param WelcomeLBL the WelcomeLBL to set
     */
    public void setWelcomeLBL(Label WelcomeLBL) {
        this.WelcomeLBL = WelcomeLBL;
    }

    /**
     * @return the Friends
     */
    public Label getFriends() {
        return Friends;
    }

    /**
     * @param Friends the Friends to set
     */
    public void setFriends(Label Friends) {
        this.Friends = Friends;
    }

    /**
     * @return the Session
     */
    public Label getSession() {
        return Session;
    }

    /**
     * @param Session the Session to set
     */
    public void setSession(Label Session) {
        this.Session = Session;
    }

    /**
     * @return the OnlineSes
     */
    public Label getOnlineSes() {
        return OnlineSes;
    }

    /**
     * @param OnlineSes the OnlineSes to set
     */
    public void setOnlineSes(Label OnlineSes) {
        this.OnlineSes = OnlineSes;
    }

    /**
     * @return the DisplayFriendTA
     */
    public TextArea getDisplayFriendTA() {
        return DisplayFriendTA;
    }

    /**
     * @param DisplayFriendTA the DisplayFriendTA to set
     */
    public void setDisplayFriendTA(TextArea DisplayFriendTA) {
        this.DisplayFriendTA = DisplayFriendTA;
    }

    /**
     * @return the AddFriendBTN
     */
    public Button getAddFriendBTN() {
        return AddFriendBTN;
    }

    /**
     * @param AddFriendBTN the AddFriendBTN to set
     */
    public void setAddFriendBTN(Button AddFriendBTN) {
        this.AddFriendBTN = AddFriendBTN;
    }

    /**
     * @return the HideFriendBTN
     */
    public Button getHideFriendBTN() {
        return HideFriendBTN;
    }

    /**
     * @param HideFriendBTN the HideFriendBTN to set
     */
    public void setHideFriendBTN(Button HideFriendBTN) {
        this.HideFriendBTN = HideFriendBTN;
    }

   



 
    private Button FriendSearchBTN= new Button("Friend Search ");
    private Button AddFriendBTN = new Button("Add Friend ");
    private Button HideFriendBTN = new Button("Hide Friends");
    private Button CreateAppBTN = new Button ("Create New Appointment");
    private Button LogoutBTN = new Button ("Logout");
    private Button UploadFileBTN = new Button ("Upload File");
    private Button DoneBTN = new Button ("Done");
    
    
      private Label NewFriendLBL= new Label("Please Enter Username of Friend");
      private TextField NewFriendTF = new TextField();
      
    
    
    private Label WelcomeLBL = new Label ("Welcome Student!!");
    private Label Friends = new Label ("Friends");
    private Label Session = new Label ("Study Session Appointments");
    private Label OnlineSes = new Label ("Create New Online Session");
    private Label AddFriendSLabel = new Label ("Request Sent");
    
    
    private TextArea DisplayFriendTA = new TextArea();
    private TextArea DisplaySessionTA = new TextArea();
  ImageView iv = new ImageView();
   Image image = new Image("appointment.png");
  
  
    public SBMainGUI()
    {   this.setStyle("-fx-background-color: #CCFFFF");
           Friends.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
       Session.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        WelcomeLBL.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 26));
        iv.setImage(image);
        iv.setFitHeight(20);
        iv.setFitWidth(20);
        DisplayFriendTA.setMaxWidth(50);
        DisplayFriendTA.setMaxHeight(50);
        Friends.setPadding(new Insets(0,0,0,0));
        Session.setAlignment(Pos.TOP_RIGHT);
        WelcomeLBL.setPadding(new Insets(10,10,10,200));
        DisplaySessionTA.setMaxWidth(300);
        DisplaySessionTA.setMaxHeight(200);
       
      
        Session.setPadding(new Insets(10, 10, 10, 10));
        Session.setGraphic(iv);
        this.add(WelcomeLBL,3,0);
        this.add(Session,7,0);
     
        this.add(Friends,1,1);
        this.add(DisplayFriendTA,1,2);
        this.add( FriendSearchBTN,1,3);
        this.add(DisplaySessionTA,7,1);
        this.add(CreateAppBTN,7,2);
        this.add(UploadFileBTN, 6,4);
        this.add(LogoutBTN,8,0);
    
         
		
    }
   

    
}
