package jdom;


import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class jdom3 {
	
	private static String ConnectionString = "jdbc:mysql://52.26.242.223:3306/dbproject";
	private static String Id = "root";
	private static String Password = "qwe123";		
	private static String Classname = "com.mysql.jdbc.Driver";

	Connection con = null;
    PreparedStatement pstmt = null;   
	ResultSet rs=null;
	
	String sql = "";	
	  
	
	String r12="";
	

	public ArrayList getAddress() throws Exception{
		
		int resultCnt= -1;
		
		ArrayList list = new ArrayList();		
		String rvalUrl = "http://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=125";
		URL url = new URL(rvalUrl);
        URLConnection connection = url.openConnection();
		DocumentBuilderFactory objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder objDocumentBuilder =  objDocumentBuilderFactory.newDocumentBuilder();
		Document doc =  (Document) objDocumentBuilder.parse(connection.getInputStream());
		try{	

			int count =getCount();
			System.out.println("count = "+count);
			Class.forName(Classname);
			con = DriverManager.getConnection(ConnectionString, Id, Password);				
			
			NodeList descNodes =  doc.getElementsByTagName("data");
			
			 
	        for(int i=0; i<1;i++){
	        	jdom3 rec = new jdom3();
	            for(Node node = descNodes.item(i).getFirstChild(); node!=null; node=node.getNextSibling()){ //첫번째 자식을 시작으로 마지막까지 다음 형제를 실행
	                 
	            	if(count > 0) // 기존에 값이 있으면 update
	            	{
	            		if(node.getNodeName().equals("r12")){
	 	                	sql = " update rain set rain_value = ?,cre_date=now(),mod_date=now(),del_date=now() where rain_name='r12' "; 
	 	         			pstmt = con.prepareStatement(sql);
	 	         			pstmt.setString(1,node.getTextContent());
	 	         			resultCnt = pstmt.executeUpdate();	
	 	                }
	 	                
	            	}
	            	else // 값이 없으면 insert
	            	{
	            		if(node.getNodeName().equals("r12")){	                	
	 	                	System.out.println("r12 = "+node.getTextContent());
	 	                	 sql = " insert into rain(rain_name,rain_value,cre_date,mod_date,del_date) values('r12',?,now(),now(),now() ); "; 
	 	         			pstmt = con.prepareStatement(sql);
	 	         			pstmt.setString(1,node.getTextContent());
	 	         			resultCnt = pstmt.executeUpdate();	
	 	                }   
	 	                
	            	}
	            		
	               
	            list.add(rec);
	            }
	        }
	        
	       
		}catch(Exception e)
		{System.out.println("에러 :: jdom3.java : " + e.getMessage()+" 까지");
		StackTraceElement[] elog = e.getStackTrace();
		for(int i=0;i<elog.length;i++)
		{
			System.out.println(elog[i]);
		}
				
			resultCnt = -1;
		}finally {
			if(pstmt != null) try{ pstmt.close(); }catch(Exception e){} 
			if(con != null) try{ con.close(); }catch(Exception e){} 								
		}	
		 return list;
		}
		
	
	     // try-finally
	   
	
	public int getCount() throws Exception{
		int count = 0;
		try{
			Class.forName(Classname);
	        con = DriverManager.getConnection(ConnectionString, Id, Password);		
			sql = " select count(*) as tcount from rain; "; 
  			pstmt = con.prepareStatement(sql);
  			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				count = rs.getInt("tcount");
			}
				
		}catch(Exception e)		
		{
			System.out.println("에러 :: jdom3.java : " + e.getMessage()+" 까지");
			StackTraceElement[] elog = e.getStackTrace();
			for(int i=0;i<elog.length;i++)
			{
				System.out.println(elog[i]);
			}				
			
		}finally {
			if(pstmt != null) try{ pstmt.close(); }catch(Exception e){} 
			if(con != null) try{ con.close(); }catch(Exception e){} 								
		}	
			return count;
		
	}

	public String getR12() {
		return r12;
	}

	public void setR12(String r12) {
		this.r12= r12;
	}

	
	
	
	
	
	
}
