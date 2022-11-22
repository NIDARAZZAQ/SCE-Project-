package LogicLayer;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import DataAccessLayer.Data_Sender_Class;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Bussiness_Logic {
	
	static ArrayList<String> Title_list=new ArrayList<String>();
	static ArrayList<String> Author_list=new ArrayList<String>();
	static ArrayList<String> Paragraph_list=new ArrayList<String>();
	static ArrayList<String> result = new ArrayList<String>(); 
	static Data_Sender_Class obj=new Data_Sender_Class();
	
	public static void ReadXML(File[] files) 
	
	{ try {
		for(File file:files) {
		if (file.isFile()) {
	      
	try {
	  
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	  
	DocumentBuilder db = dbf.newDocumentBuilder();  
	Document doc = db.parse(file);  
	doc.getDocumentElement().normalize();  
	NodeList nodeList = doc.getElementsByTagName("document");  
		Node node = nodeList.item(0);  
	
	if (node.getNodeType() == Node.ELEMENT_NODE)   
	{  
	Element eElement = (Element) node;  
	String Title;
	String Author;
	String Paragraph;
	
	Title=eElement.getElementsByTagName("title").item(0).getTextContent();
	Title = Title.trim().replaceAll("\\s{2,}", " ");
	
   Title_list.add(Title);
   
	Author=eElement.getElementsByTagName("author").item(0).getTextContent();
	Author = Author.trim().replaceAll("\\s{2,}", " ");
	
	Author_list.add(Author);
	
	Paragraph=eElement.getElementsByTagName("section").item(0).getTextContent(); 
    Paragraph = Paragraph.trim().replaceAll("\\s{2,}", " ");
	
	
	Paragraph_list.add(Paragraph);
	
	} 
		}
	catch(Exception e) {
		
	}
		}
		
		}
		}catch(Exception e) {
			
		}
	
	Data_Sender_Class.Paragraph_Data();
	
	Duplicate_Remover();
	Data_Sender_Class.Word_Data();
	

	} 
	
	
	
     public static ArrayList ReturnTitle() {
    	 return Title_list;
    	 
     }
     public static ArrayList ReturnAuthor() {
    	 
    	 return Author_list;
     }
     
     static ArrayList<String> word = new ArrayList<String>(); 
     static ArrayList<Integer> frequency = new ArrayList<Integer>();
     
     public static void Duplicate_Remover() {
    	

 		for(int i=0;i<Paragraph_list.size();i++) {
 			
 		String P=Paragraph_list.get(i);
 		
 		String split[] = P.split(" ", 0);
        for (String s: split)
        	
            result.add(s);
        
    }
         HashMap < String , Integer > map = new HashMap <> (); 
         for ( String CHeck : result ) {
         if ( map . containsKey ( CHeck )) { 
          map . put ( CHeck , map . get ( CHeck ) + 1 );
          }else { map . put ( CHeck , 1 );
          } } 
         for ( Map . Entry < String , Integer > entry : map . entrySet ()) 
        	 
         { 
        	 word.add(entry . getKey ());
        	 frequency.add(entry . getValue ());
         }
         
         
         
     }
     public static ArrayList ReturnParagraph() {
	     return Paragraph_list;
	 
     }
     public static ArrayList ReturnWord() {
    	 
    	 return word;
     }
     public static ArrayList ReturnFre() {
    	 
    	 return frequency;
     }
     
	}
	
