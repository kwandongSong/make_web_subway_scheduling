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
		
		// page는 파싱해오는 url을 구분해 주기 위한 것.
		int page = 1;
		
		try {

			while (true) 
			{
				String subURL = "7호선/광명사거리";
				subURL =  URLEncoder.encode(subURL, "UTF-8");

				String url = "http://openapi.seoul.go.kr:8088/"
						+ "4b68696e4367766335364865714866"
						+ "/xml/CardSubwayTime/1/5/201904/"+subURL;

				System.out.println(url);
				// parsing할 url 지정 ( API 키 포함해서 이다 )
				
				// 페이지에 접근해줄 Document 객체를 생성해 주어야 한다.
				// 여기서 생성한 document 객체를 통해 파싱할 url의 요소를 읽어 들인다.
				// doc.getDocumentElement().getNodeName()를 출력하면 위 XML의 최상위 tag 값을 가져온다.
				// 여기서는 ServiceResult 가 최상위 tag값이 될 것이다.

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

				Document doc = dBuilder.parse(url);

				doc.getDocumentElement().normalize();

				System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
				
				// 여기는 파싱할 정보가 있는 tag에 접근하는 부분이다.
				// 여기서 파싱할 데이터는 <itemList>라는 tag안에 있기 때문에 나는 여기로 접근해야한다.
				// 그러면 nList에 <itemList> 태그가 하나씩 담기게 되고 , getLength()를 통해 리스트의 수를 확인할 수 있게된다.
				
				NodeList nList = doc.getElementsByTagName("row");

				System.out.println("파싱할 리스트 수 : " + nList.getLength());
				
				// 이 부분은 list에 담긴 데이터를 출력하는 부분 
				// 위에 담긴 list를 반복문을 통해서 출력할 것이다
				// getTextContent() 는 전체 정보를 의미
				// getTagValue (" tag " , element ) : 입력한 tag 정보를 의미
				// getTagValue ( " tag " <- 실질적인 tag의 변수값을 넣어줘야 함 ) 
				// getTagValue는 따로 메소드를 만들어 준 것


				for (int temp = 0; temp < nList.getLength(); temp++) {
				
  // for문을 사용해 준 것은 모든 데이터를 출력해 보기 위해서이다.


					Node nNode = nList.item(temp);
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						
						Element eElement = (Element) nNode;
						
						System.out.println("----------------------------------------");
						System.out.println("탄사람수      : " + getTagValue("EIGHT_RIDE_NUM", eElement));
						System.out.println("내린사람수      : " + getTagValue("EIGHT_ALIGHT_NUM", eElement));
					}
				
				
				
				
				}
				
				//하나의 리스트 값을 출력하면 +1 을 함으로써 구분시킬려고 , 20번째까지 구하기 위해서 , 임의로 
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
	
	// getTagValue 메소드 인데 , 이 부분은 TagName을 가져옴으로써 nlList에 저장을 시키는 부분 
	
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
	
	// getTagValue 메소드 인데 , 이 부분은 TagName을 가져옴으로써 nlList에 저장을 시키는 부분 
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
				String station = stat; //내릴 역 입력받아됨 
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
				// parsing할 url 지정 ( API 키 포함해서 이다 )
				
				// 페이지에 접근해줄 Document 객체를 생성해 주어야 한다.
				// 여기서 생성한 document 객체를 통해 파싱할 url의 요소를 읽어 들인다.
				// doc.getDocumentElement().getNodeName()를 출력하면 위 XML의 최상위 tag 값을 가져온다.
				// 여기서는 ServiceResult 가 최상위 tag값이 될 것이다.

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

				Document doc = dBuilder.parse(url);

				doc.getDocumentElement().normalize();

				System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
				
				// 여기는 파싱할 정보가 있는 tag에 접근하는 부분이다.
				// 여기서 파싱할 데이터는 <itemList>라는 tag안에 있기 때문에 나는 여기로 접근해야한다.
				// 그러면 nList에 <itemList> 태그가 하나씩 담기게 되고 , getLength()를 통해 리스트의 수를 확인할 수 있게된다.
				
				NodeList nList = doc.getElementsByTagName("row");

				// 이 부분은 list에 담긴 데이터를 출력하는 부분 
				// 위에 담긴 list를 반복문을 통해서 출력할 것이다
				// getTextContent() 는 전체 정보를 의미
				// getTagValue (" tag " , element ) : 입력한 tag 정보를 의미
				// getTagValue ( " tag " <- 실질적인 tag의 변수값을 넣어줘야 함 ) 
				// getTagValue는 따로 메소드를 만들어 준 것

				
				//direction 1=right 3=left 반복횟수 

				for (int temp = 0; temp < direction; temp++) {
				
  // for문을 사용해 준 것은 모든 데이터를 출력해 보기 위해서이다.
					jdom2 rec = new jdom2();
					Node nNode = nList.item(temp);
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						
						Element eElement = (Element) nNode;
						
						System.out.println("----------------------------------------");
						System.out.println("남은시간    : " + getTagValue("arvlMsg2", eElement));
						remaintime =getTagValue("arvlMsg2", eElement);
						list.add(rec);
					}
				}
				
	              // 1) 해당 클래스를 메모리에 로드해서 해당 클래스가 존재하는지 여부를 확인

	              Class.forName("com.mysql.jdbc.Driver");

	           
	              String dbInfo = "jdbc:mysql://localhost:3306/final2";

	              String dbID   = "root";

	              String dbPW = "tnthd!8253";

	             

	              // 2) 해당 드라이버의 클래스를 이용하여 DB접속시도(java.sql.*)

	              java.sql.Connection conn =  java.sql.DriverManager.getConnection( dbInfo, dbID, dbPW );



	              // 3) DB에 명령어를 전달할 수 있는 객체가 생성되어진다( java.sql.Statement)

	              java.sql.Statement stmt = conn.createStatement();

	              


	             

	              
	              System.out.println(remaintime);

	              String dbCommand =  " update realtime set remain='"+remaintime+"'";

	             

	              System.out.println( dbCommand );



	              // 4) 쿼리문 실행 (반환값 integer type)

	             stmt.executeUpdate( dbCommand );



	              // 5) 쿼리문장이 실행된 결과를 ResultSet 객체의 참조변수에 담아준다(  java.sql.ResultSet )                

	              java.sql.ResultSet rs = stmt.executeQuery( "SELECT * FROM realtime");               

	             

	              // 6) 결과를 가져와서 자료의 처음부터 끝까지를 화면에 뿌리기

	             rs.beforeFirst();

	              

	              while (  rs.next() ) {

	                        System.out.println(  rs.getString("remain") );

	              }  // while
	              // 7) DB접속종료

	              conn.close();
				
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



}

