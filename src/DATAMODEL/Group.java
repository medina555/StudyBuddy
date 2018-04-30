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
    public int getGid() {
        return gid;
    }

    /**
     * @param gid the gid to set
     */
    public void setGid(int gid) {
        this.gid = gid;
    }

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
     * @return the ginstructor
     */
    public String getGinstructor() {
        return ginstructor;
    }

    /**
     * @param ginstructor the ginstructor to set
     */
    public void setGinstructor(String ginstructor) {
        this.ginstructor = ginstructor;
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
    private int gid;
    private String gsubject;
    private String ginstructor;
    private int courseid;

    public Group(String gname, int gid, String gsubject, String ginstructor, int courseid) {
        this.gname = gname;
        this.gid = gid;
        this.gsubject = gsubject;
        this.ginstructor = ginstructor;
        this.courseid = courseid;
    }
    
    
    
    
    
    
    
    
    
}
