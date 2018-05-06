/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

/**
 *
 * @author Andrew
 */
public class Database {

    /**
     * @return the myStmt
     */
    public Statement getMyStmt() {
        return myStmt;
    }

    /**
     * @param myStmt the myStmt to set
     */
    public void setMyStmt(Statement myStmt) {
        this.myStmt = myStmt;
    }

    /**
     * @return the myRs
     */
    public ResultSet getMyRs() {
        return myRs;
    }

    /**
     * @param myRs the myRs to set
     */
    public void setMyRs(ResultSet myRs) {
        this.myRs = myRs;
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    	private String dbaseName;
        private Connection conn; 
        private Statement myStmt; 
        private ResultSet myRs;

	private Database() 
        {    
           dbConnect();
            
	}
        
     public void dbConnect()
     {
          try
            {
                conn =   DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studybuddy", "root", "root");
                myStmt = conn.createStatement();
                myRs = myStmt.executeQuery("select * from student");


                while(myRs.next())
                {
                    System.out.println(myRs.getString("firstname"));
                }



                //query to get the friendlist, it just requires the studentid of the current user
                // a random id to verify it's working correctly
                int studentId = 3;
                myRs = myStmt.executeQuery("SELECT DISTINCT student.firstname, student.studentid, student.lastname "
                        + "FROM student INNER JOIN friend "
                        + "ON ((student.studentid=friend.idfriend1 OR student.studentid=friend.idfriend2) "
                        + "AND student.studentid != "+studentId+")");

                System.out.println("Friends: ");
                while(myRs.next())
                {
                    System.out.print("name: "+myRs.getString("firstname"));
                    System.out.println(" "+myRs.getString("lastname"));
                }



                //to create a new group
                //this requires the name of the group and the days of the week.
                int groupId=1; //id of the new group, it should be generated automatically
                String courseName = "Software engineering"; //name of the course
                String groupName = "omnibus";
                String dow = "TTh";
                System.out.println("courseName: "+courseName);
                //getting the course id of that class
                myRs = myStmt.executeQuery("Select * from course where name='"+courseName+"'");
                //getting the studentid of the friend
                myRs.next();
                int courseId = Integer.parseInt(myRs.getString("courseid"));
                myStmt.executeUpdate("Insert into studygroup(groupid, groupname, coursename, daysofweek, course_id) "
                        + "values ("+groupId+",'"+groupName+"','"+courseName+"','"+dow+"',"+courseId+")");



                //to send a friend request
                //this query requires the username and the studentid of the student who is sending the request
                int idSender=2; //id of the student who is sending the request
                String username = "marco";
                myRs = myStmt.executeQuery("Select * from student where username='"+username+"'");
                //getting the studentid of the friend
                myRs.next();
                int idReceiver = Integer.parseInt(myRs.getString("studentid"));
                myStmt.executeUpdate("Insert into friend value ("+idSender+","+idReceiver+")");



                //to store a file into the database
                //this query requires the file name, the groupid and the studentid
                studentId = 1;
                String fileName = "software engineering.pdf"; //directory of the file
                groupId = 1;
                int documentId = 3;

                //reading the file
                File file = new File(fileName);
                try 
                {
                    FileInputStream fis = new FileInputStream(file);
                    PreparedStatement ps = conn.prepareStatement("Insert into document values (?,?,?,?,?)");
                    {
                        conn.setAutoCommit(false);
                        ps.setInt(1, documentId);
                        ps.setString(2, fileName);
                        ps.setBinaryStream(3, fis, (int) file.length());
                        ps.setInt(4, groupId);
                        ps.setInt(5, studentId);
                        ps.executeUpdate();
                        conn.commit();
                    }
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                
                
                //retrieve a file from the database
                fileName = "software engineering.pdf"; //name of the file
                groupId = 1;
                
                ResultSet resultSet = myStmt.executeQuery("SELECT name, content FROM document WHERE name='"+fileName+"'"
                        + " AND groupId="+groupId);
                while (resultSet.next()) 
                {
                    String name = resultSet.getString("name");
                    File document = new File(name);
                    FileOutputStream fos = new FileOutputStream(document);

                    byte[] buffer = new byte[1];
                    InputStream is = resultSet.getBinaryStream(2);
                    while (is.read(buffer) > 0) 
                    {
                        fos.write(buffer);
                    }
                    fos.close();
                }
                
            }
            catch (Exception  e)
            {
                e.printStackTrace();
            }
     }
       
        
        

	private static Database singletonOfDatabase = null; 
	
	public static Database getSingletonOfdatabase() 
	{    
		if (singletonOfDatabase == null)
		{
			singletonOfDatabase = new Database();	
		}
		return singletonOfDatabase;
	}

	/**
	 * @return the dbaseName
	 */
	public String getDbaseName() {
		return dbaseName;
	}

	/**
	 * @param dbaseName the dbaseName to set
	 */
	public void setDbaseName(String dbaseName) {
		this.dbaseName = dbaseName;
	}
    
}
