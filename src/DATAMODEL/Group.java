/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATAMODEL;

/**
 *
 * @author Andrew
 */
public class Group {

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
     * @return the gname
     */
    public String getGname() {
        return gname;
    }

    /**
     * @param gname the gname to set
     */
    public void setGname(String gname) {
        this.gname = gname;
    }

    /**
     * @return the gid
     */

    /**
     * @return the gsubject
     */
    public String getGsubject() {
        return gsubject;
    }

    /**
     * @param gsubject the gsubject to set
     */
    public void setGsubject(String gsubject) {
        this.gsubject = gsubject;
    }

    /**
     * @return the daysofweek
     */
    public String getDaysofweek() {
        return daysofweek;
    }

    /**
     * @param daysofweek the daysofweek to set
     */
    public void setDaysofweek(String daysofweek) {
        this.daysofweek = daysofweek;
    }

    /**
     * @return the courseid
     */
    public int getCourseid() {
        return courseid;
    }

    /**
     * @param courseid the courseid to set
     */
    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }
    private String gname;
    private String gsubject;
    private String daysofweek;
    private int courseid;
    private String currentuser;

    public Group(String gname,  String gsubject, String ginstructor, int courseid) {
        this.gname = gname;
   
        this.gsubject = gsubject;
        this.daysofweek = ginstructor;
        this.courseid = courseid;
    }
    
    
    
    
    
    
    
    
    
}
