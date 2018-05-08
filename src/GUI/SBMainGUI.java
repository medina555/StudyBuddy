/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javax.mail.FetchProfile.Item;

/**
 *
 * @author Andrew
 */
public class SBMainGUI extends GridPane
{

    /**
     * @return the viewGroupInfoBTN
     */
    public Button getViewGroupInfoBTN() {
        return viewGroupInfoBTN;
    }

    /**
     * @param viewGroupInfoBTN the viewGroupInfoBTN to set
     */
    public void setViewGroupInfoBTN(Button viewGroupInfoBTN) {
        this.viewGroupInfoBTN = viewGroupInfoBTN;
    }

    /**
     * @return the gvalue
     */
    public String getGvalue() {
        return gvalue;
    }

    /**
     * @param gvalue the gvalue to set
     */
    public void setGvalue(String gvalue) {
        this.gvalue = gvalue;
    }

    /**
     * @return the mylist
     */
    public ListView<String> getMylist()
    {
        return mylist;
    }

    /**
     * @param mylist the mylist to set
     */
    public void setMylist(ListView<String> mylist)
    {
        this.mylist = mylist;
    }

    /**
     * @return the Gvbox
     */
    public VBox getGvbox()
    {
        return Gvbox;
    }

    /**
     * @param Gvbox the Gvbox to set
     */
    public void setGvbox(VBox Gvbox)
    {
        this.Gvbox = Gvbox;
    }

    /**
     * @return the refreshGroupBTN
     */
    public Button getRefreshGroupBTN()
    {
        return refreshGroupBTN;
    }

    /**
     * @param refreshGroupBTN the refreshGroupBTN to set
     */
    public void setRefreshGroupBTN(Button refreshGroupBTN)
    {
        this.refreshGroupBTN = refreshGroupBTN;
    }

    /**
     * @return the grouptable
     */
    public TableView getGrouptable()
    {
        return grouptable;
    }

    /**
     * @param grouptable the grouptable to set
     */
    public void setGrouptable(TableView grouptable)
    {
        this.grouptable = grouptable;
    }

    /**
     * @return the groupname
     */
    public TableColumn getGroupname()
    {
        return groupname;
    }

    /**
     * @param groupname the groupname to set
     */
    public void setGroupname(TableColumn groupname)
    {
        this.groupname = groupname;
    }

    /**
     * @return the groupid
     */
    public TableColumn getGroupid()
    {
        return groupid;
    }

    /**
     * @param groupid the groupid to set
     */
    public void setGroupid(TableColumn groupid)
    {
        this.groupid = groupid;
    }

    /**
     * @return the groupcid
     */
    public TableColumn getGroupcid()
    {
        return groupcid;
    }

    /**
     * @param groupcid the groupcid to set
     */
    public void setGroupcid(TableColumn groupcid)
    {
        this.groupcid = groupcid;
    }

    /**
     * @return the groupsub
     */
    public TableColumn getGroupsub()
    {
        return groupsub;
    }

    /**
     * @param groupsub the groupsub to set
     */
    public void setGroupsub(TableColumn groupsub)
    {
        this.groupsub = groupsub;
    }

    /**
     * @return the groupinst
     */
    public TableColumn getGroupinst()
    {
        return groupinst;
    }

    /**
     * @param groupinst the groupinst to set
     */
    public void setGroupinst(TableColumn groupinst)
    {
        this.groupinst = groupinst;
    }

    /**
     * @return the createGroupBTN
     */
    public Button getCreateGroupBTN()
    {
        return createGroupBTN;
    }

    /**
     * @param createGroupBTN the createGroupBTN to set
     */
    public void setCreateGroupBTN(Button createGroupBTN)
    {
        this.createGroupBTN = createGroupBTN;
    }

    /**
     * @return the fvalue
     */
    public String getFvalue()
    {
        return fvalue;
    }

    /**
     * @param fvalue the fvalue to set
     */
    public void setFvalue(String fvalue)
    {
        this.fvalue = fvalue;
    }

    /**
     * @return the glist
     */
    public ListView<String> getGlist()
    {
        return glist;
    }

    /**
     * @param glist the glist to set
     */
    public void setGlist(ListView<String> glist)
    {
        this.glist = glist;
    }

    /**
     * @return the addGroupBTN
     */
    public Button getAddGroupBTN()
    {
        return addGroupBTN;
    }

    /**
     * @param addGroupBTN the addGroupBTN to set
     */
    public void setAddGroupBTN(Button addGroupBTN)
    {
        this.addGroupBTN = addGroupBTN;
    }

    /**
     * @return the slist
     */
    public ListView<String> getSlist()
    {
        return slist;
    }

    /**
     * @param slist the slist to set
     */
    public void setSlist(ListView<String> slist)
    {
        this.slist = slist;
    }

    /**
     * @return the MyGroupLabel
     */
    public Label getMyGroupLabel()
    {
        return MyGroupLabel;
    }

    /**
     * @param MyGroupLabel the MyGroupLabel to set
     */
    public void setMyGroupLabel(Label MyGroupLabel)
    {
        this.MyGroupLabel = MyGroupLabel;
    }

    /**
     * @return the AnnouncementTA
     */
    public TextArea getAnnouncementTA()
    {
        return AnnouncementTA;
    }

    /**
     * @param AnnouncementTA the AnnouncementTA to set
     */
    public void setAnnouncementTA(TextArea AnnouncementTA)
    {
        this.AnnouncementTA = AnnouncementTA;
    }

    /**
     * @return the Welcomevbox
     */
    public VBox getWelcomevbox()
    {
        return Welcomevbox;
    }

    /**
     * @param Welcomevbox the Welcomevbox to set
     */
    public void setWelcomevbox(VBox Welcomevbox)
    {
        this.Welcomevbox = Welcomevbox;
    }

    /**
     * @return the Appvbox
     */
    public VBox getAppvbox()
    {
        return Appvbox;
    }

    /**
     * @param Appvbox the Appvbox to set
     */
    public void setAppvbox(VBox Appvbox)
    {
        this.Appvbox = Appvbox;
    }

    /**
     * @return the FriendBox
     */
    public VBox getFriendBox()
    {
        return FriendBox;
    }

    /**
     * @param FriendBox the FriendBox to set
     */
    public void setFriendBox(VBox FriendBox)
    {
        this.FriendBox = FriendBox;
    }

    /**
     * @return the Apphbox
     */
    public HBox getApphbox()
    {
        return Apphbox;
    }

    /**
     * @param Apphbox the Apphbox to set
     */
    public void setApphbox(HBox Apphbox)
    {
        this.Apphbox = Apphbox;
    }

    /**
     * @return the MainBox
     */
    public HBox getMainBox()
    {
        return MainBox;
    }

    /**
     * @param MainBox the MainBox to set
     */
    public void setMainBox(HBox MainBox)
    {
        this.MainBox = MainBox;
    }

    /**
     * @return the date
     */
    public DatePicker getDate()
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(DatePicker date)
    {
        this.date = date;
    }

    /**
     * @return the DoneBTN
     */
    public Button getDoneBTN()
    {
        return DoneBTN;
    }

    /**
     * @param DoneBTN the DoneBTN to set
     */
    public void setDoneBTN(Button DoneBTN)
    {
        this.DoneBTN = DoneBTN;
    }

    /**
     * @return the AddFriendSLabel
     */
    public Label getAddFriendSLabel()
    {
        return AddFriendSLabel;
    }

    /**
     * @param AddFriendSLabel the AddFriendSLabel to set
     */
    public void setAddFriendSLabel(Label AddFriendSLabel)
    {
        this.AddFriendSLabel = AddFriendSLabel;
    }

    /**
     * @return the FriendSearchBTN
     */
    public Button getFriendSearchBTN()
    {
        return FriendSearchBTN;
    }

    /**
     * @param FriendSearchBTN the FriendSearchBTN to set
     */
    public void setFriendSearchBTN(Button FriendSearchBTN)
    {
        this.FriendSearchBTN = FriendSearchBTN;
    }

    /**
     * @return the NewFriendLBL
     */
    public Label getNewFriendLBL()
    {
        return NewFriendLBL;
    }

    /**
     * @param NewFriendLBL the NewFriendLBL to set
     */
    public void setNewFriendLBL(Label NewFriendLBL)
    {
        this.NewFriendLBL = NewFriendLBL;
    }

    /**
     * @return the NewFriendTF
     */
    public TextField getNewFriendTF()
    {
        return NewFriendTF;
    }

    /**
     * @param NewFriendTF the NewFriendTF to set
     */
    public void setNewFriendTF(TextField NewFriendTF)
    {
        this.NewFriendTF = NewFriendTF;
    }

    /**
     * @return the DisplaySessionTA
     */
    public TextArea getDisplaySessionTA()
    {
        return DisplaySessionTA;
    }

    /**
     * @param DisplaySessionTA the DisplaySessionTA to set
     */
    public void setDisplaySessionTA(TextArea DisplaySessionTA)
    {
        this.DisplaySessionTA = DisplaySessionTA;
    }

    /**
     * @return the CreateAppBTN
     */
    public Button getCreateAppBTN()
    {
        return CreateAppBTN;
    }

    /**
     * @param CreateAppBTN the CreateAppBTN to set
     */
    public void setCreateAppBTN(Button CreateAppBTN)
    {
        this.CreateAppBTN = CreateAppBTN;
    }

    /**
     * @return the LogoutBTN
     */
    public Button getLogoutBTN()
    {
        return LogoutBTN;
    }

    /**
     * @param LogoutBTN the LogoutBTN to set
     */
    public void setLogoutBTN(Button LogoutBTN)
    {
        this.LogoutBTN = LogoutBTN;
    }

    /**
     * @return the UploadFileBTN
     */
    public Button getUploadFileBTN()
    {
        return UploadFileBTN;
    }

    /**
     * @param UploadFileBTN the UploadFileBTN to set
     */
    public void setUploadFileBTN(Button UploadFileBTN)
    {
        this.UploadFileBTN = UploadFileBTN;
    }

    /**
     * @return the WelcomeLBL
     */
    public Label getWelcomeLBL()
    {
        return WelcomeLBL;
    }

    /**
     * @param WelcomeLBL the WelcomeLBL to set
     */
    public void setWelcomeLBL(Label WelcomeLBL)
    {
        this.WelcomeLBL = WelcomeLBL;
    }

    /**
     * @return the Friends
     */
    public Label getFriends()
    {
        return Friends;
    }

    /**
     * @param Friends the Friends to set
     */
    public void setFriends(Label Friends)
    {
        this.Friends = Friends;
    }

    /**
     * @return the Session
     */
    public Label getSession()
    {
        return Session;
    }

    /**
     * @param Session the Session to set
     */
    public void setSession(Label Session)
    {
        this.Session = Session;
    }

    /**
     * @return the OnlineSes
     */
    public Label getOnlineSes()
    {
        return OnlineSes;
    }

    /**
     * @param OnlineSes the OnlineSes to set
     */
    public void setOnlineSes(Label OnlineSes)
    {
        this.OnlineSes = OnlineSes;
    }

    /**
     * @return the DisplayFriendTA
     */
    public TextArea getDisplayFriendTA()
    {
        return DisplayFriendTA;
    }

    /**
     * @param DisplayFriendTA the DisplayFriendTA to set
     */
    public void setDisplayFriendTA(TextArea DisplayFriendTA)
    {
        this.DisplayFriendTA = DisplayFriendTA;
    }

    /**
     * @return the AddFriendBTN
     */
    public Button getAddFriendBTN()
    {
        return AddFriendBTN;
    }

    /**
     * @param AddFriendBTN the AddFriendBTN to set
     */
    public void setAddFriendBTN(Button AddFriendBTN)
    {
        this.AddFriendBTN = AddFriendBTN;
    }

    /**
     * @return the HideFriendBTN
     */
    public Button getHideFriendBTN()
    {
        return HideFriendBTN;
    }

    /**
     * @param HideFriendBTN the HideFriendBTN to set
     */
    public void setHideFriendBTN(Button HideFriendBTN)
    {
        this.HideFriendBTN = HideFriendBTN;
    }

    private DatePicker date = new DatePicker();

    private Button FriendSearchBTN = new Button("Friend Search ");
    private Button AddFriendBTN = new Button("Add Friend ");
    private Button HideFriendBTN = new Button("Hide Friends");
    private Button CreateAppBTN = new Button("Send an Email");
    private Button LogoutBTN = new Button("Logout");
    private Button UploadFileBTN = new Button("Upload File");
    private Button DoneBTN = new Button("Done");
    private Button addGroupBTN = new Button("Add to Group");
    private Button createGroupBTN = new Button("Create Group");
    private Button refreshGroupBTN = new Button("Refresh Group");
    private Button viewGroupInfoBTN = new Button("View Group Members/Info");

    private Label NewFriendLBL = new Label("Please Enter Username of Friend");
    private TextField NewFriendTF = new TextField();

    private Label WelcomeLBL = new Label("Welcome Student!!");
    private Label Friends = new Label("Friends");
    private Label Session = new Label("Study Session Appointments");
    private Label OnlineSes = new Label("Create New Online Session");
    private Label AddFriendSLabel = new Label("Request Sent");
    private Label MyGroupLabel = new Label("Announcements");

    private TextArea AnnouncementTA = new TextArea();
    private TextArea DisplayFriendTA = new TextArea();
    private TextArea DisplaySessionTA = new TextArea();
    ImageView iv = new ImageView();
    Image image = new Image("appointment.png");
    private HBox Apphbox = new HBox(10);
    private VBox Gvbox = new VBox();
    private HBox MainBox = new HBox();
    private VBox FriendBox = new VBox();
    private VBox Appvbox = new VBox(20);
    private VBox Welcomevbox = new VBox(20);
    private ListView<String> slist = new ListView();
    private ListView<String> glist = new ListView();
    private ListView<String> mylist = new ListView();
    private TableView grouptable = new TableView();
    private String fvalue = "";
    private String gvalue = "";

    private TableColumn groupname = new TableColumn("Group Name");
    private TableColumn groupid = new TableColumn("Group ID");
    private TableColumn groupcid = new TableColumn("Course ID");
    private TableColumn groupsub = new TableColumn("Course Subject");
    private TableColumn groupinst = new TableColumn("Days of Week ");
    final Label tablelbl = new Label("StudyBuddy Sessions");

    public SBMainGUI()

    {
         
        slist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
            {
                fvalue = newValue;

                System.out.println("favlue is" + fvalue);
            }
        }
        );
        
        MyGroupLabel.setText("My Groups");
        
       FriendSearchBTN.setStyle( "-fx-background-color:#008CBA" );

       
              createGroupBTN.setStyle( "-fx-background-color:#008CBA");
                     LogoutBTN.setStyle( "-fx-background-color: #008CBA");
                   
       
       
       
                                  CreateAppBTN.setStyle( "-fx-background-color: #008CBA");
       
       
       
       
       
       
        
        
        
           grouptable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(grouptable.getSelectionModel().getSelectedItem() != null) 
        {   
           TableViewSelectionModel selectionModel = grouptable.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
         
           System.out.println("Selected Value" + val);
           gvalue = String.valueOf(val);
            System.out.println(gvalue);
         }
         }
     });
        
        
        
        
        
        
        

        tablelbl.setFont(new Font("Arial", 20));
        ;

        grouptable.setEditable(true);
        grouptable.getColumns().addAll(groupname, groupcid, groupsub, groupinst);
        grouptable.setPrefSize(400, 400);
        Appvbox.setStyle("-fx-background-color: #52C286");
        date.setPromptText("Appointment Date");

        Friends.setStyle("-fx-border-color: black;");

        Friends.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
        Session.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        WelcomeLBL.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 26));

        iv.setImage(image);
        iv.setFitHeight(20);
        iv.setFitWidth(20);

        Session.setAlignment(Pos.TOP_RIGHT);

        DisplaySessionTA.setMaxWidth(300);
        DisplaySessionTA.setMaxHeight(200);

        DisplayFriendTA.setMaxWidth(300);
        DisplayFriendTA.setMaxHeight(200);

        slist.setMaxSize(100, 200);
        AnnouncementTA.setMaxWidth(300);
        AnnouncementTA.setMaxHeight(200);
        Appvbox.getChildren().addAll(CreateAppBTN, LogoutBTN, Friends, slist, FriendSearchBTN);
        Apphbox.getChildren().addAll(grouptable,viewGroupInfoBTN, createGroupBTN);

        Apphbox.setPadding(new Insets(0, 100, 0, 0));

    }
    
    
    public void updateFriendList(ListView<String> slist)
    {
        Appvbox.getChildren().remove(4);
        slist.setMaxSize(100, 200);
        Appvbox.getChildren().add(4, slist);
    }
    public void updateGroupTable(TableView groupTable)
    {
        Apphbox.getChildren().remove(0);
        Apphbox.getChildren().add(0, groupTable);
    }

}
