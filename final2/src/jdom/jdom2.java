/*package jdom;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class jdom{

	public static void main(String[] args) {
		
		// page�� �Ľ��ؿ��� url�� ������ �ֱ� ���� ��.
		int page = 1;
		
		try {

			while (true) 
			{
				String subURL = "7ȣ��/�����Ÿ�";
				subURL =  URLEncoder.encode(subURL, "UTF-8");

				String url = "http://openapi.seoul.go.kr:8088/"
						+ "4b68696e4367766335364865714866"
						+ "/xml/CardSubwayTime/1/5/201904/"+subURL;

				System.out.println(url);
				// parsing�� url ���� ( API Ű �����ؼ� �̴� )
				
				// �������� �������� Document ��ü�� ������ �־�� �Ѵ�.
				// ���⼭ ������ document ��ü�� ���� �Ľ��� url�� ��Ҹ� �о� ���δ�.
				// doc.getDocumentElement().getNodeName()�� ����ϸ� �� XML�� �ֻ��� tag ���� �����´�.
				// ���⼭�� ServiceResult �� �ֻ��� tag���� �� ���̴�.

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

				Document doc = dBuilder.parse(url);

				doc.getDocumentElement().normalize();

				System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
				
				// ����� �Ľ��� ������ �ִ� tag�� �����ϴ� �κ��̴�.
				// ���⼭ �Ľ��� �����ʹ� <itemList>��� tag�ȿ� �ֱ� ������ ���� ����� �����ؾ��Ѵ�.
				// �׷��� nList�� <itemList> �±װ� �ϳ��� ���� �ǰ� , getLength()�� ���� ����Ʈ�� ���� Ȯ���� �� �ְԵȴ�.
				
				NodeList nList = doc.getElementsByTagName("row");

				System.out.println("�Ľ��� ����Ʈ �� : " + nList.getLength());
				
				// �� �κ��� list�� ��� �����͸� ����ϴ� �κ� 
				// ���� ��� list�� �ݺ����� ���ؼ� ����� ���̴�
				// getTextContent() �� ��ü ������ �ǹ�
				// getTagValue (" tag " , element ) : �Է��� tag ������ �ǹ�
				// getTagValue ( " tag " <- �������� tag�� �������� �־���� �� ) 
				// getTagValue�� ���� �޼ҵ带 ����� �� ��


				for (int temp = 0; temp < nList.getLength(); temp++) {
				
  // for���� ����� �� ���� ��� �����͸� ����� ���� ���ؼ��̴�.


					Node nNode = nList.item(temp);
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						
						Element eElement = (Element) nNode;
						
						System.out.println("----------------------------------------");
						System.out.println("ź�����      : " + getTagValue("EIGHT_RIDE_NUM", eElement));
						System.out.println("���������      : " + getTagValue("EIGHT_ALIGHT_NUM", eElement));
					}
				
				
				
				
				}
				
				//�ϳ��� ����Ʈ ���� ����ϸ� +1 �� �����ν� ���н�ų���� , 20��°���� ���ϱ� ���ؼ� , ���Ƿ� 
				page += 1;
				System.out.println("page number " + page);
				if(page > 1) 
				{
					break;
				}
				
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// getTagValue �޼ҵ� �ε� , �� �κ��� TagName�� ���������ν� nlList�� ������ ��Ű�� �κ� 
	
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

		Node nValue = (Node) nlList.item(0);
		if (nValue == null) {
			return null;
		}
		return nValue.getNodeValue();
	}


}
*/
package jdom;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.sql.Connection;
import java.sql.DriverManager;


public class jdom2{
	
	// getTagValue �޼ҵ� �ε� , �� �κ��� TagName�� ���������ν� nlList�� ������ ��Ű�� �κ� 
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

		Node nValue = (Node) nlList.item(0);
		if (nValue == null) {
			return null;
		}
		return nValue.getNodeValue();
	}
	
	
	public ArrayList getAddress(String stat) throws Exception {
		ArrayList list = new ArrayList();	
		
		try {
				
				String remaintime="";
				String station = stat; //���� �� �Է¹޾Ƶ� 
				String key="sample"; //sample 
				
				int direction;
				direction=1; //right 
				//direction=3;  //left
				//String key="53654551706776633130387944735579" //sample
				
				station =  URLEncoder.encode(station, "UTF-8");

				String url = "http://swopenapi.seoul.go.kr/api/subway/"
						+ key
						+ "/xml/realtimeStationArrival/1/5/"+station;

				System.out.println(url);
				// parsing�� url ���� ( API Ű �����ؼ� �̴� )
				
				// �������� �������� Document ��ü�� ������ �־�� �Ѵ�.
				// ���⼭ ������ document ��ü�� ���� �Ľ��� url�� ��Ҹ� �о� ���δ�.
				// doc.getDocumentElement().getNodeName()�� ����ϸ� �� XML�� �ֻ��� tag ���� �����´�.
				// ���⼭�� ServiceResult �� �ֻ��� tag���� �� ���̴�.

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

				Document doc = dBuilder.parse(url);

				doc.getDocumentElement().normalize();

				System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
				
				// ����� �Ľ��� ������ �ִ� tag�� �����ϴ� �κ��̴�.
				// ���⼭ �Ľ��� �����ʹ� <itemList>��� tag�ȿ� �ֱ� ������ ���� ����� �����ؾ��Ѵ�.
				// �׷��� nList�� <itemList> �±װ� �ϳ��� ���� �ǰ� , getLength()�� ���� ����Ʈ�� ���� Ȯ���� �� �ְԵȴ�.
				
				NodeList nList = doc.getElementsByTagName("row");

				// �� �κ��� list�� ��� �����͸� ����ϴ� �κ� 
				// ���� ��� list�� �ݺ����� ���ؼ� ����� ���̴�
				// getTextContent() �� ��ü ������ �ǹ�
				// getTagValue (" tag " , element ) : �Է��� tag ������ �ǹ�
				// getTagValue ( " tag " <- �������� tag�� �������� �־���� �� ) 
				// getTagValue�� ���� �޼ҵ带 ����� �� ��

				
				//direction 1=right 3=left �ݺ�Ƚ�� 

				for (int temp = 0; temp < direction; temp++) {
				
  // for���� ����� �� ���� ��� �����͸� ����� ���� ���ؼ��̴�.
					jdom2 rec = new jdom2();
					Node nNode = nList.item(temp);
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						
						Element eElement = (Element) nNode;
						
						System.out.println("----------------------------------------");
						System.out.println("�����ð�    : " + getTagValue("arvlMsg2", eElement));
						remaintime =getTagValue("arvlMsg2", eElement);
						list.add(rec);
					}
				}
				
	              // 1) �ش� Ŭ������ �޸𸮿� �ε��ؼ� �ش� Ŭ������ �����ϴ��� ���θ� Ȯ��

	              Class.forName("com.mysql.jdbc.Driver");

	           
	              String dbInfo = "jdbc:mysql://localhost:3306/final2";

	              String dbID   = "root";

	              String dbPW = "tnthd!8253";

	             

	              // 2) �ش� ����̹��� Ŭ������ �̿��Ͽ� DB���ӽõ�(java.sql.*)

	              java.sql.Connection conn =  java.sql.DriverManager.getConnection( dbInfo, dbID, dbPW );



	              // 3) DB�� ��ɾ ������ �� �ִ� ��ü�� �����Ǿ�����( java.sql.Statement)

	              java.sql.Statement stmt = conn.createStatement();

	              


	             

	              
	              System.out.println(remaintime);

	              String dbCommand =  " update realtime set remain='"+remaintime+"'";

	             

	              System.out.println( dbCommand );



	              // 4) ������ ���� (��ȯ�� integer type)

	             stmt.executeUpdate( dbCommand );



	              // 5) ���������� ����� ����� ResultSet ��ü�� ���������� ����ش�(  java.sql.ResultSet )                

	              java.sql.ResultSet rs = stmt.executeQuery( "SELECT * FROM realtime");               

	             

	              // 6) ����� �����ͼ� �ڷ��� ó������ �������� ȭ�鿡 �Ѹ���

	             rs.beforeFirst();

	              

	              while (  rs.next() ) {

	                        System.out.println(  rs.getString("remain") );

	              }  // while
	              // 7) DB��������

	              conn.close();
				
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



}

