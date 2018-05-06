/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATAMODEL;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class GroupDataModel {

    /**
     * @return the grouplist
     */
    public ArrayList <Group> getGrouplist() {
        return grouplist;
    }

    /**
     * @param grouplist the grouplist to set
     */
    public void setGrouplist(ArrayList <Group> grouplist) {
        this.grouplist = grouplist;
    }

    /**
     * @return the group
     */
    public Group getGroup() {
        return group;
    }
    
    
        private ArrayList <Group> grouplist = new ArrayList();
    private Group group;
    
    
       public void setGroup(Group grp)
	{
            this.group = grp;
		grouplist.add(grp);
                
                
                
	}
    
}
