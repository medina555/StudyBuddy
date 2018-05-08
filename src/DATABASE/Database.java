/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;
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
            conn =   DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studybuddy", "root", "medina55");
            myStmt = conn.createStatement();
            myRs = myStmt.executeQuery("select * from student");
            
            
         
            
                
            }
            catch (Exception  e){}
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
