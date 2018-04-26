/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EMAIL;


/**
 *
 * @author Andrew
 */
public class SBEmail {

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the mailFrom
     */
    public String getMailFrom() {
        return mailFrom;
    }

    /**
     * @param mailFrom the mailFrom to set
     */
    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the mailTo
     */
    public String getMailTo() {
        return mailTo;
    }

    /**
     * @param mailTo the mailTo to set
     */
    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the attachFiles
     */
    public String[] getAttachFiles() {
        return attachFiles;
    }

    /**
     * @param attachFiles the attachFiles to set
     */
    public void setAttachFiles(String[] attachFiles) {
        this.attachFiles = attachFiles;
    }

    /**
     * @return the ccEmails
     */
    public String[] getCcEmails() {
        return ccEmails;
    }

    /**
     * @param ccEmails the ccEmails to set
     */
    public void setCcEmails(String[] ccEmails) {
        this.ccEmails = ccEmails;
    }
    
             private   String host; 
	     private	String port ;
	     private	String mailFrom; 
             private String password ;

		// message info
		private String mailTo ;
		private String subject ;
		private String message ;

		// attachments
		private String[] attachFiles; 
                
		//attachFiles[2] = "e:/Test/Video.mp4";
		
		// CC emails
		private String[] ccEmails ={""};

                	private static SBEmail singletonOfDatabase = null; 
	
	public static SBEmail getSingletonOfdatabase() 
	{    
		if (singletonOfDatabase == null)
		{
			singletonOfDatabase = new SBEmail();	
		}
		return singletonOfDatabase;
	}
        
       
                
                
                public void  setSBEmail(String host, String port, String mailfrom, String password, String mailTo, String subject, 
                        String message ,String[] attachFiles)
                {
                    this.setHost(host);
                    this.setPort(port);
                    this.setMailFrom(mailfrom);
                    this.setPassword(password);
                    this.setMailTo(mailTo);
                    this.setSubject(subject);
                    this.setMessage(message);
                    this.setAttachFiles(attachFiles);
                }
    
        public void  setSBEmailcc()
                {
                    
                }
    
    
    
}
