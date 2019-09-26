<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jdom.jdom2" %> 
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link href="./result.css" type="text/css" rel="stylesheet" id="war">
<%-- <script src="./result.js" type="text/javascript"></script> --%>
</head>
<body>
<% 
	String code = request.getParameter("code3");
	System.out.println("real?"+code);
 	jdom2 jdom2 = new jdom2();	
	ArrayList list = new ArrayList();
	list = jdom2.getAddress(code);
%>
	<div id="countdown"></div>
<script>
		var bam = new Audio('./sounds/bambambam.mp3');
		var alarm = new Audio('./sounds/alarm.mp3');
		var close = new Audio('./sounds/closedoor.mp3');
		var go = new Audio('./sounds/go.mp3');

		function countdown( elementName, minutes, seconds )
		{
		    var element, endTime, hours, mins, msLeft, time;
		
		    function twoDigits( n )
		    {
		        return (n <= 9 ? "0" + n : n);
		    }
		
		    function updateTimer()
		    {
		    	//1000= 1초
		        msLeft = endTime - (+new Date);

		        if ( msLeft < 1000 ) {
		            element.innerHTML = "countdown's over!";
		            go.play();
		            location.reload();
		        } else {
		            time = new Date( msLeft );
		            
		            //소리 재생 
			        if(msLeft>19000&&msLeft<20000){ 	
			        	bam.play();
			        }
			        else if(msLeft>14000&&msLeft<15000){ 	
				        alarm.play();	
			        }
			        else if(msLeft>10000&&msLeft<11000){ 	
				        close.play();	
			        }
			        else if(msLeft>4000&&msLeft<5000){ 	
				        go.play();	
			        }
		            hours = time.getUTCHours();
		            mins = time.getUTCMinutes();
		            element.innerHTML ='다음 열차 도착시간:' + (hours ? hours + ':' + twoDigits( mins ) : mins) + ':' + twoDigits( time.getUTCSeconds() );
		            setTimeout( updateTimer, time.getUTCMilliseconds() + 500 );
		        }
		    }
		
		    element = document.getElementById( elementName );
		    endTime = (+new Date) + 1000 * (60*minutes + seconds) + 500;
		    updateTimer();
		}
</script>
<% 



			      int to=0;



	              Class.forName("com.mysql.jdbc.Driver");


	           
	              String dbInfo = "jdbc:mysql://localhost:3306/final2";

	              String dbID   = "root";

	              String dbPW = "tnthd!8253";
	              ResultSet rs = null;
	              
	              java.sql.Connection conn =  java.sql.DriverManager.getConnection( dbInfo, dbID, dbPW );
	              java.sql.Statement stmt = conn.createStatement();
	              String query = "select * from realtime";
	              rs = stmt.executeQuery(query);
		          rs.beforeFirst();


		   
		          while (rs.next() ) {

		              //out.println( "						남은시간:" + rs.getString("remain") );

		              String rt = rs.getString("remain");
		              %>
		              <div id="beauti">
		              			도착정보 :<%=rt %>
		              </div>
		              <%
			          //String rt="1분후";
		              //out.println(rt+"좀 되라");
		         
			          if (rt.equals("전역 출발")) 
			          {
			        	  rt="2분";
			        	  char left=rt.charAt(0);
			        	  to =left-'0';
			        	 // out.println(to);
			          }
			          else if (rt.equals("전역 도착"))
			          {
			        	  rt="3분";
			        	  char left=rt.charAt(0);
			        	  to =left-'0';
			        	  //out.println(to);
			          }
			          else if (rt.equals("전역 진입"))
			          {
			        	  rt="4분";
			        	  char left=rt.charAt(0);
			        	  to =left-'0';
			        	  //out.println(to);
			          }
			          else if (rt.equals(code+" 진입") || rt.equals(code+" 도착") )
			          {
			        	  rt="1분";
			        	  char left=rt.charAt(0);
			        	  to =left-'0';
			        	  //out.println(to);
			          }
			          else if (rt.equals(code+" 출발")) 
			          {
			        	 Thread.sleep(15000);
			        	 %>
			        	 <script> location.reload();</script>
			        	  <% 
			          }
			          else{
			        	  char left=rt.charAt(0);
			        	  to =left-'0';
			        	  //out.println(to);
			          }
		          }	   
		          

	              
	              rs.close();
	              stmt.close();
	              conn.close();	  
	              
%>

<script>
	var time="<%=to%>";
	countdown( "countdown", time, 0 );
	
</script>

<section class="stage">
  <div class="sky">
    <div class="cloud"></div>
    <div class="cloud"></div>
  </div>
  <div class="train">
    <div class="wagon"></div>
    <div class="wagon"></div>
    <div class="wagon"></div>
    <div class="locomotive">
      <div class="cabin"></div>
      <div class="motor"></div>
      <div class="chimney">
        <div class="smoke"></div>
      </div>
      <div class="light"></div>
    </div>
  </div>
  
</section>
</body>
</html>