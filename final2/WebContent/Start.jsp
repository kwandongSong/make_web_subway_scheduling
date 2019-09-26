<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jdom.jdom" %> 
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*"%>

<%@ page import= "java.util.Calendar "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Insert title here</title>
</head>
<link href="./Start.css" type="text/css" rel="stylesheet" id="war">

<% 
    jdom jdom = new jdom();   
   ArrayList list = new ArrayList();
   list = jdom.getAddress();
%>

<body>


<div class="container">
  
   <div class="button_baset">
      <button class="btn-1" onclick="location='war_v2.html'" id="home">Go Home</button>
     <!-- <button onclick="location='war_v2.html'" id="home"></button> -->
   </div>



<% 
                 Class.forName("com.mysql.jdbc.Driver");
              int hour1;
              int rr;
              int aa;

                   String hourW="";
                   
                   
                 String dbInfo = "jdbc:mysql://localhost:3306/final2";
                 String dbID   = "root";
                 String dbPW = "tnthd!8253";
                 int doocong=0;
                 
                 
                 ResultSet rs = null;
                 Calendar cal = Calendar.getInstance();
                 hour1 = cal.get(Calendar.HOUR_OF_DAY);
                 
                 java.sql.Connection conn =  java.sql.DriverManager.getConnection( dbInfo, dbID, dbPW );
                 java.sql.Statement stmt = conn.createStatement();
                 String query = "select * from people order by num";
                 rs = stmt.executeQuery(query);
                rs.beforeFirst();

                
                while (  rs.next() ) {
                   doocong++;
                   
                   if(doocong == hour1)
                   {
                   String r= rs.getString("ride");
                   String a = rs.getString("alight");
                 rr = Integer.parseInt(r);
                 aa = Integer.parseInt(a);
         
                 
                 int result =rr-aa;
               
                 System.out.println(result);
                     if(result>=15000)
                     {
%>
                        
                        <div class='relax'>
						       
						       <img class="cant" src="./images/cant.jpg" width="400px" height="400px" alt="cant" />
						</div>
						<div class="button_baseb">
         
					    <button class="btn-1" onclick="location='input.jsp'" id="input">Go battle</button>
					    </div>
					 </div>
					 <h1> 아,,,똥나오겠네 ;; </h1>
<%
                     }
                     else
                     {
%>
                        
                        <div class='relax'>
						       
						       <img class="cant" src="./images/can.jpg" width="400px" height="400px" alt="cant" />
						</div>
					    <div class="button_baseb">
         
					    <button class="btn-1" onclick="location='input.jsp'" id="input">Go battle</button>
					    </div>
					 </div>
					 <h1> 참을수 있다 ^^ </h1>
<%
                     }}
%>                     



<%

//out.println( "탄사람수:" + rs.getString("ride") );
//out.println( "내린사람수:" + rs.getString("alight") );
                    }                 
                 
                 rs.close();
                 stmt.close();
                 conn.close();                 
%>

</body>
</html>
