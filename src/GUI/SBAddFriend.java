/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Andrew
 */
public class SBAddFriend extends GridPane{

    /**
     * @return the statuslabel
     */
    public Label getStatuslabel() {
        return statuslabel;
    }

    /**
     * @param statuslabel the statuslabel to set
     */
    public void setStatuslabel(Label statuslabel) {
        this.statuslabel = statuslabel;
    }

    /**
     * @return the addfriendBTN
     */
    public Button getAddfriendBTN() {
        return addfriendBTN;
    }

    /**
     * @param addfriendBTN the addfriendBTN to set
     */
    public void setAddfriendBTN(Button addfriendBTN) {
        this.addfriendBTN = addfriendBTN;
    }

    /**
     * @return the friendlabel
     */
    public Label getFriendlabel() {
        return friendlabel;
    }

    /**
     * @param friendlabel the friendlabel to set
     */
    public void setFriendlabel(Label friendlabel) {
        this.friendlabel = friendlabel;
    }

    /**
     * @return the friendTF
     */
    public TextField getFriendTF() {
        return friendTF;
    }

    /**
     * @param friendTF the friendTF to set
     */
    public void setFriendTF(TextField friendTF) {
        this.friendTF = friendTF;
    }
    private Label friendlabel = new Label("Please enter the username of friend you wish to add");
    private TextField friendTF = new TextField();
    private Button addfriendBTN = new Button("Add Friend");
    private Label statuslabel = new Label("");
    
    public SBAddFriend()
    {
      
        this.addRow(1,friendlabel);
        this.addRow(2,friendTF,addfriendBTN,statuslabel);
        
    }
    
}
