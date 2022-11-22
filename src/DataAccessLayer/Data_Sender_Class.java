package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import LogicLayer.Bussiness_Logic;

public class Data_Sender_Class {
	
	static String Str="jdbc:mysql://localhost:3306/spell_checker";
	   static String Pass="root";
	   static String User="";
	
	static ArrayList Author=new ArrayList();
	static ArrayList Title=new ArrayList();
	static ArrayList Paragraph=new ArrayList();
	static ArrayList word_DB=new ArrayList();
	static ArrayList word_Fre=new ArrayList();
	
	
	public static void Paragraph_Data() {
		Bussiness_Logic obj=new Bussiness_Logic();
		Author=obj.ReturnAuthor();
		Title=obj.ReturnTitle();
		Paragraph=obj.ReturnParagraph();
		String str = "";
		
	   
		
	  
		try {
	    	Connection con = DriverManager.getConnection(Str,Pass,User);
	    	
	    	for(int i=0;i<Paragraph.size();i++) {
	    		try {
	    		str = "insert into paragraph values("+null+",'"+Title.get(i)+"','"+Author.get(i)+"','"+Paragraph.get(i)+"')";
		        PreparedStatement st = con.prepareStatement(str);
		        st.execute();
	    		
	    		
	    		}
		        catch(SQLException e) {
			    	
			    }
	    	}
	    	con.close();
	    	JOptionPane.showMessageDialog( null,"Data Inserted SuccessFully Table" );
	    }
	    catch(SQLException e) {
	    	System.out.println(e);
	    }

	}
	
	public static void Word_Data() {
		
		Bussiness_Logic obj=new Bussiness_Logic();
		word_DB=obj.ReturnWord();
		word_Fre=obj.ReturnFre();
		ArrayList New=new ArrayList();
		String str = "";
    	
    	try {
        	Connection con = DriverManager.getConnection(Str,Pass,User);
        	
        	
        	System.out.println(word_DB.size());
        	
        		for(int i=0;i<word_DB.size();i++) {
        			try {
        		            int Fre=(int) word_Fre.get(i);
        		             String D=(String) word_DB.get(i);
        		
        			
        			
        		
        			
        		str = "insert into word values("+null+",'"+D+"',"+Fre+")";
        		
    	        PreparedStatement st = con.prepareStatement(str);
    	        st.execute();
    	        
        		}

        			catch(SQLException e) {
        				
    			    }
        		}
        		
        	con.close();
        	JOptionPane.showMessageDialog( null,"Data Inserted SuccessFully In Word Database" );
        }
        catch(SQLException e) {
        	System.out.println(e);
        }
		
		
	}

	
	
	
}
