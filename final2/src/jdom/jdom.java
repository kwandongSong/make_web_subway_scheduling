package jdom;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdom{
   
   int hour1;

   
   // getTagValue 메소드 인데 , 이 부분은 TagName을 가져옴으로써 nlList에 저장을 시키는 부분 
   private static String getTagValue(String tag, Element eElement) {
      NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

      Node nValue = (Node) nlList.item(0);
      if (nValue == null) {
         return null;
      }
      return nValue.getNodeValue();
   }
   
   
   public ArrayList getAddress() throws Exception {
      ArrayList list = new ArrayList();   
      
      try {
            String [] r = new String [24];
            String [] a = new String [24];
            int []rr = new int [24];
            int []aa = new int [24];
            String hourW = "";

            String subURL = "7호선/광명사거리";
            subURL =  URLEncoder.encode(subURL, "UTF-8");
            
            Calendar cal = Calendar.getInstance();
            hour1 = cal.get(Calendar.HOUR_OF_DAY);
            
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

            // 이 부분은 list에 담긴 데이터를 출력하는 부분 
            // 위에 담긴 list를 반복문을 통해서 출력할 것이다
            // getTextContent() 는 전체 정보를 의미
            // getTagValue (" tag " , element ) : 입력한 tag 정보를 의미
            // getTagValue ( " tag " <- 실질적인 tag의 변수값을 넣어줘야 함 ) 
            // getTagValue는 따로 메소드를 만들어 준 것

            
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
            
  // for문을 사용해 준 것은 모든 데이터를 출력해 보기 위해서이다.
               jdom rec = new jdom();
               Node nNode = nList.item(temp);

               
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;
                  System.out.println("----------------------------------------");
                  System.out.println(hour1);
                  
                  
                  for(int i=0;i<=23;i++) {
               hour1 = i+1;
               System.out.println(hour1);
                  if(hour1 == 1)
                  { hourW = "ONE";}
                  else if(hour1 == 2) 
                  { hourW = "TWO";}
                  else if(hour1 == 3) 
                  { hourW = "THREE";}
                  else if(hour1 == 4) 
                  { hourW = "FOUR";}
                  else if(hour1 == 5) 
                  { hourW = "FIVE";}
                  else if(hour1 == 6) 
                  { hourW = "SIX";}
                  else if(hour1 == 7) 
                  { hourW = "SEVEN";}
                  else if(hour1 == 8) 
                  { hourW = "EIGHT";}
                  else if(hour1 == 9) 
                  { hourW = "NINE";}
                  else if(hour1 == 10) 
                  { hourW = "TEN";}
                  else if(hour1 == 11) 
                  { hourW = "ELEVEN";}
                  else if(hour1 == 12) 
                  { hourW = "TWELVE";}
                  else if(hour1 == 13) 
                  { hourW = "THIRTEEN";}
                  else if(hour1 == 14) 
                  { hourW = "FOURTEEN";}
                  else if(hour1 == 15) 
                  { hourW = "FIFTEEN";}
                  else if(hour1 == 16) 
                  { hourW = "SIXTEEN";}
                  else if(hour1 == 17) 
                  { hourW = "SEVENTEEN";}
                  else if(hour1 == 18) 
                  { hourW = "EIGHTEEN";}
                  else if(hour1 == 19) 
                  { hourW = "NINETEEN";}
                  else if(hour1 == 20) 
                  { hourW = "TWENTY";}
                  else if(hour1 == 21) 
                  { hourW = "TWENTY_ONE";}
                  else if(hour1 == 22) 
                  { hourW = "TWENTY_TWO";}
                  else if(hour1 == 23) 
                  { hourW = "TWENTY_THREE";}
                  else if(hour1 == 24) 
                  { hourW = "MIDNIGHT";}
                  
                  
                  
    
       
                  r[i] = getTagValue(hourW + "_RIDE_NUM", eElement);
                  a[i] = getTagValue(hourW + "_ALIGHT_NUM", eElement);
                  

                 rr[i]= Integer.parseInt(r[i]);
                 aa[i]= Integer.parseInt(a[i]);

                  }
                  
                  
                  
                  
                  
                  
                  
                  
    
}
                  
                  /*
                  
                  if( rr - aa >=15000 )
                  {
                     System.out.println("아,,,똥나오겠네;;");
                  }
                  else
                  {
                     System.out.println("응가 참을만하다 ~^^"); 
                  }

                  System.out.println("탄사람수      : " + getTagValue(hourW + "_RIDE_NUM", eElement));
                  System.out.println("내린사람수      : " + getTagValue(hourW + "_ALIGHT_NUM", eElement));
                  */

                  list.add(rec);
                  
                  
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
                 for(int i=0;i<=23;i++) {
              
                	 System.out.println(rr[i]);
                 System.out.println(aa[i]);
                 
                 }
                 
                 String [] strarr = {"장암","도봉산","수락산","마들", "노원" , "중계", "하계", "공릉", "태릉입구", "먹골", 
                       "중화", "상봉", "면목", "사가정", "용마산", "중곡","군자","어린이 대공원",
                       "건대입구", "뚝섬유원지", "청담", "강남구청", "학동", "논현","반포", "고속터미널",
                       "내방","총신대입구","남성", "숭실대입구","상도","장승배기", "신대방사거리", "보라매",
                       "신풍", "대림","남구로","가산디지털단지","철산", "광명사거리", "천왕", "온수", 
                       "까치울","부천종합운동장", "춘의","신중동","부천시청", "상동", "삼산체육관", "굴포천", "부평구청"};
                 
                 
                 String [] strarr2 = {"부평구청","부천종합운동장", "남성","총신대입구","뚝섬유원지","건대입구", "상봉"};
                 int [] num1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
                       21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,
                       47,48,49,50,51};
                 int [] num2 = {1,8,23,24,32,33,40};
                 int [] num3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
                       21,22,23,24};
                 
                 
                 String dbCommand="";
                 
                 //지하철역 데이터 베이스 입력
                 for(int i=0;i<=50;i++)
                 {
                
                   // dbCommand =  " insert into station(num, station_name) values('"+num1[50-i]+"','"+ strarr[i]+"')";
                    dbCommand =  " update station set station_name='"+strarr[i]+"' where num='"+num1[50-i]+"'";
                    //dbCommand =  " insert into station set station_name='"+ strarr[i]+"'";
                    System.out.println( dbCommand );
                    stmt.executeUpdate( dbCommand );
                 }
                 
                //화장실역 데이터 베이스 입력
                 for(int i=0;i<=6;i++)
                 {
                    dbCommand =  " update toilet set station_name='"+strarr2[i]+"' where num='"+num2[i]+"'";
                    //dbCommand =  " insert into toilet set station_name='"+ strarr2[i]+"'";
                    System.out.println( dbCommand );
                    stmt.executeUpdate( dbCommand );
                 }
               
                //승하차 데이터 베이스 입력
                 for(int i=0;i<=23;i++)
                 {
                	 dbCommand =  " update people set ride='"+rr[i]+"', alight='"+aa[i]+"' where num='"+num3[i]+"'";
                    //dbCommand =  " insert into people(ride, alight, num) values('"+rr[i]+"','"+ aa[i]+"','"+ num3[i]+"' )";
                    //dbCommand =  " insert into toilet set station_name='"+ strarr2[i]+"'";
                    System.out.println( dbCommand );
                    stmt.executeUpdate( dbCommand );
                 }

                   
                //String dbCommand =  " insert into station set ride='"+r+"', alight='"+a+"'";

                 



                 // 4) 쿼리문 실행 (반환값 integer type)

                 



                 // 5) 쿼리문장이 실행된 결과를 ResultSet 객체의 참조변수에 담아준다(  java.sql.ResultSet )                

                 java.sql.ResultSet rs = stmt.executeQuery( "SELECT * FROM people");               

                

                 // 6) 결과를 가져와서 자료의 처음부터 끝까지를 화면에 뿌리기

                rs.beforeFirst();

                 while (  rs.next() ) {

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

                 }  // while

                 // 7) DB접속종료
                 conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return list;
   }
}

