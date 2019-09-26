<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jdom.jdom" %> 
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*"%>


<%@ page import= "java.util.Calendar "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>역골라서 비교해보자 </title>

</head>

<!-- <link href="./test_db.css" type="text/css" rel="stylesheet" id="test_db">  -->

<body>
<% 

            String code = request.getParameter("code"); // 요청 파라미터 code에 대한 값 설정

            String code2 = request.getParameter("code2"); // 요청 파라미터 code에 대한 값 설정
            int start =Integer.parseInt(code);
            int end =Integer.parseInt(code2);
               
            out.println(start);  
            out.println(end);  
                 Class.forName("com.mysql.jdbc.Driver");
              int hour1;
              int rr;
              int aa;
              String [] have_toilet = new String [8];
                   String hourW="";
                   
                   
                 String dbInfo = "jdbc:mysql://localhost:3306/final2";
                 String dbID   = "root";
                 String dbPW = "tnthd!8253";
                 int doocong=0;
                 
                 
                 ResultSet rs = null;
                 
                 ResultSet ts = null;
                 Calendar cal = Calendar.getInstance();
                 hour1 = cal.get(Calendar.HOUR_OF_DAY);
                 
                 java.sql.Connection conn =  java.sql.DriverManager.getConnection( dbInfo, dbID, dbPW );
                 java.sql.Statement stmt = conn.createStatement();
                 java.sql.Statement stmt2 = conn.createStatement();
                 String query = "select * from station order by num";
                 String query2 = "select * from toilet order by num";
                 rs = stmt.executeQuery(query);
                 ts = stmt2.executeQuery(query2);
                 
                 rs.beforeFirst();
                 ts.beforeFirst();

                 int count=0;
				 while (rs.next()){
					 doocong++;
					 if(doocong>=start&&doocong<=end)
					 {
						 
						 String r= rs.getString("station_name");
						 System.out.println("r:"+r);
		                 while (  ts.next() ) {
		                     //ts.next();
		                     

		                        //String r= rs.getString("station_name");
		                        String t= ts.getString("station_name");
		                        System.out.println("t:"+t);
		                        if(r.equals(t)){
		                        	out.println(t);
		                        	have_toilet[count]=t;
		                        	count++;
		                        }
		                        

		                      }
		                 ts.beforeFirst();
						 
					 }

					 
				 }
              
                  
                  rs.close();
                  stmt.close();
                  conn.close();    
                  
            request.setAttribute("h_t0",have_toilet[0]);    
            request.setAttribute("h_t1",have_toilet[1]);  
            request.setAttribute("h_t2",have_toilet[2]);  
            request.setAttribute("h_t3",have_toilet[3]);  
            request.setAttribute("h_t4",have_toilet[4]);  
            request.setAttribute("h_t5",have_toilet[5]);  
            request.setAttribute("h_t6",have_toilet[6]);  
            request.setAttribute("h_t7",have_toilet[7]);  
            
 %>
 
<jsp:forward page="./input.jsp" />

 </body>
 </html>