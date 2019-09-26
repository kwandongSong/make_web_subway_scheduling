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

   
   // getTagValue �޼ҵ� �ε� , �� �κ��� TagName�� ���������ν� nlList�� ������ ��Ű�� �κ� 
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

            String subURL = "7ȣ��/�����Ÿ�";
            subURL =  URLEncoder.encode(subURL, "UTF-8");
            
            Calendar cal = Calendar.getInstance();
            hour1 = cal.get(Calendar.HOUR_OF_DAY);
            
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

            // �� �κ��� list�� ��� �����͸� ����ϴ� �κ� 
            // ���� ��� list�� �ݺ����� ���ؼ� ����� ���̴�
            // getTextContent() �� ��ü ������ �ǹ�
            // getTagValue (" tag " , element ) : �Է��� tag ������ �ǹ�
            // getTagValue ( " tag " <- �������� tag�� �������� �־���� �� ) 
            // getTagValue�� ���� �޼ҵ带 ����� �� ��

            
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
            
  // for���� ����� �� ���� ��� �����͸� ����� ���� ���ؼ��̴�.
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
                     System.out.println("��,,,�˳����ڳ�;;");
                  }
                  else
                  {
                     System.out.println("���� �������ϴ� ~^^"); 
                  }

                  System.out.println("ź�����      : " + getTagValue(hourW + "_RIDE_NUM", eElement));
                  System.out.println("���������      : " + getTagValue(hourW + "_ALIGHT_NUM", eElement));
                  */

                  list.add(rec);
                  
                  
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
                 for(int i=0;i<=23;i++) {
              
                	 System.out.println(rr[i]);
                 System.out.println(aa[i]);
                 
                 }
                 
                 String [] strarr = {"���","������","������","����", "���" , "�߰�", "�ϰ�", "����", "�¸��Ա�", "�԰�", 
                       "��ȭ", "���", "���", "�簡��", "�븶��", "�߰�","����","��� �����",
                       "�Ǵ��Ա�", "�Ҽ�������", "û��", "������û", "�е�", "����","����", "����͹̳�",
                       "����","�ѽŴ��Ա�","����", "���Ǵ��Ա�","��","��¹��", "�Ŵ���Ÿ�", "�����",
                       "��ǳ", "�븲","������","��������д���","ö��", "�����Ÿ�", "õ��", "�¼�", 
                       "��ġ��","��õ���տ��", "����","���ߵ�","��õ��û", "��", "���ü����", "����õ", "����û"};
                 
                 
                 String [] strarr2 = {"����û","��õ���տ��", "����","�ѽŴ��Ա�","�Ҽ�������","�Ǵ��Ա�", "���"};
                 int [] num1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
                       21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,
                       47,48,49,50,51};
                 int [] num2 = {1,8,23,24,32,33,40};
                 int [] num3 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
                       21,22,23,24};
                 
                 
                 String dbCommand="";
                 
                 //����ö�� ������ ���̽� �Է�
                 for(int i=0;i<=50;i++)
                 {
                
                   // dbCommand =  " insert into station(num, station_name) values('"+num1[50-i]+"','"+ strarr[i]+"')";
                    dbCommand =  " update station set station_name='"+strarr[i]+"' where num='"+num1[50-i]+"'";
                    //dbCommand =  " insert into station set station_name='"+ strarr[i]+"'";
                    System.out.println( dbCommand );
                    stmt.executeUpdate( dbCommand );
                 }
                 
                //ȭ��ǿ� ������ ���̽� �Է�
                 for(int i=0;i<=6;i++)
                 {
                    dbCommand =  " update toilet set station_name='"+strarr2[i]+"' where num='"+num2[i]+"'";
                    //dbCommand =  " insert into toilet set station_name='"+ strarr2[i]+"'";
                    System.out.println( dbCommand );
                    stmt.executeUpdate( dbCommand );
                 }
               
                //������ ������ ���̽� �Է�
                 for(int i=0;i<=23;i++)
                 {
                	 dbCommand =  " update people set ride='"+rr[i]+"', alight='"+aa[i]+"' where num='"+num3[i]+"'";
                    //dbCommand =  " insert into people(ride, alight, num) values('"+rr[i]+"','"+ aa[i]+"','"+ num3[i]+"' )";
                    //dbCommand =  " insert into toilet set station_name='"+ strarr2[i]+"'";
                    System.out.println( dbCommand );
                    stmt.executeUpdate( dbCommand );
                 }

                   
                //String dbCommand =  " insert into station set ride='"+r+"', alight='"+a+"'";

                 



                 // 4) ������ ���� (��ȯ�� integer type)

                 



                 // 5) ���������� ����� ����� ResultSet ��ü�� ���������� ����ش�(  java.sql.ResultSet )                

                 java.sql.ResultSet rs = stmt.executeQuery( "SELECT * FROM people");               

                

                 // 6) ����� �����ͼ� �ڷ��� ó������ �������� ȭ�鿡 �Ѹ���

                rs.beforeFirst();

                 while (  rs.next() ) {

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

                 }  // while

                 // 7) DB��������
                 conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return list;
   }
}

