/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATAMODEL;

import DATABASE.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class StudentDataModel {

    /**
     * @return the mydb
     */
    public Database getMydb() {
        return mydb;
    }

    /**
     * @param mydb the mydb to set
     */
    public void setMydb(Database mydb) {
        this.mydb = mydb;
    }
 private Database mydb = Database.getSingletonOfdatabase();
    /**
     * @return the stulist
     */
    public ArrayList <Student> getStulist() {
        return stulist;
    }

    /**
     * @param stulist the stulist to set
     */
    public void setStulist(ArrayList <Student> stulist) {
        this.stulist = stulist;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    
    private ArrayList <Student> stulist = new ArrayList();
    private Student student; 
    Database mydatabase = Database.getSingletonOfdatabase();
   
 
   
   
    
     public void setStudent(Student stu)
	{
            this.student = stu;
		stulist.add(stu);
                
                
                
	}
}
