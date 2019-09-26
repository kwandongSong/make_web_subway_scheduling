<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jdom.jdom2" %> 
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>input</title>
</head>
<link href="./input.css" type="text/css" rel="stylesheet" id="war">

<script src="./input.js" type="text/javascript"></script> 
<body>
	<div class="button_base">
	  <button onclick="location='war_v2.html'" id="home">Go Home</button>
	</div>
	<div class="button_base">
	  	 <%--<button onclick="location='input.jsp'" id="input">경로 입력 하러 가기</button> --%>
		<button onclick="location='gettoilet.jsp'" id="input">경로 입력 완료</button>
	</div>
	<h1>Number 7 Subway</h1>
 	<hr color="green" size="10px">
	<div class ='Center'>
	
      <div id="ba2"><input type ="button" id="ha1" name="부평구청" ><br>부<br>평<br>구<br>청 </div>
      <div id="ba1"><input type ="button" id="ha2" name="굴포천" ><br>굴<br>포<br>천 </div>
      <div id="ba1"><input type ="button" id="ha3" name="삼산체육관"><br>삼<br>산<br>체<br>육<br>관 </div>
      <div id="ba1"><input type ="button" id="ha4" name="상동"><br>상<br>동</div>
      <div id="ba1"><input type ="button" id="ha5" name="부천시청"><br>부<br>천<br>시<br>청 </div>
      <div id="ba1"><input type ="button" id="ha6" name="신중동"><br>신<br>중<br>동 </div>
      <div id="ba1"><input type ="button" id="ha7" name="준의"><br>춘<br>의 </div>
      <div id="ba2"><input type ="button" id="ha8" name="부천종합운동장"><br>부<br>천<br>종<br>합<br>운<br>동<br>장</div>
      <div id="ba1"><input type ="button" id="ha9" name="까치울"><br>까<br>치<br>울 </div>
      <div id="ba1"><input type ="button" id="ha10" name="온수"><br>온<br>수 </div>
      <div id="ba1"><input type ="button" id="ha11" name="천왕"><br>천<br>왕 </div>
      <div id="ba1"><input type ="button" id="ha12" name="광명사거리"><br>광<br>명<br>사<br>거<br>리 </div>
      <div id="ba1"><input type ="button" id="ha13" name="광명사거리"><br>철<br>산 </div>
      <div id="ba1"><input type ="button" id="ha14" name="가산디지털"><br>가<br>산<br>디<br>지<br>털  </div>
      <div id="ba1"><input type ="button" id="ha15" name="남구로"><br>남<br>구<br>로  </div>
      <div id="ba1"><input type ="button" id="ha16" name="대림"><br>대<br>림  </div>
      
      <div id="ba1"><input type ="button" id="ha17" name="신풍"><br>신<br>풍 </div>
      <div id="ba1"><input type ="button" id="ha18" name="보라매"><br>보<br>라<br>매 </div>
      <div id="ba1"><input type ="button" id="ha19" name="신대방삼거리"><br>신<br>대<br>방<br>삼<br>거<br>리 </div>
      <div id="ba1"><input type ="button" id="ha20" name="장숭배기"><br>장<br>승<br>배<br>기 </div>
      <div id="ba1"><input type ="button" id="ha21" name="상도"><br>상<br>도 </div>
      <div id="ba1"><input type ="button" id="ha22" name="숭실대입구"><br>숭<br>실<br>대<br>입<br>구 </div>
      <div id="ba2"><input type ="button" id="ha23" name="남성"><br>남<br>성 </div>
      <div id="ba2"><input type ="button" id="ha24" name="총신대입구"><br>총<br>신<br>대<br>입<br>구<br></div>
      <div id="ba1"><input type ="button" id="ha25" name="내방"><br>내<br>방 </div>
      
      <div id="ba1"><input type ="button" id="ha26" name="고속터미널"><br>고<br>속<br>터<br>미<br>널 </div>
      <div id="ba1"><input type ="button" id="ha27" name="반포"><br>반<br>포 </div>
      <div id="ba1"><input type ="button" id="ha28" name="논현"><br>논<br>현 </div>
      <div id="ba1"><input type ="button" id="ha29" name="학동"><br>학<br>동 </div>
      <div id="ba1"><input type ="button" id="ha30" name="강남구청"><br>강<br>남<br>구<br>청 </div>
      <div id="ba1"><input type ="button" id="ha31" name="청담"><br>청<br>담 </div>
      <div id="ba2"><input type ="button" id="ha32" name="뚝섬유원지"><br>뚝<br>섬<br>유<br>원<br>지 </div>
      <div id="ba2"><input type ="button" id="ha33" name="건대입구"><br>건<br>대<br>입<br>구 </div>
      <div id="ba1"><input type ="button" id="ha34" name="어린이대공원"><br>어<br>린<br>이<br>대<br>공<br>원 </div>
      
      
      <div id="ba1"><input type ="button" id="ha35" name="군자"><br>군<br>자 </div>
      <div id="ba1"><input type ="button" id="ha36" name="중곡"><br>중<br>곡 </div>
      <div id="ba1"><input type ="button" id="ha37" name="용마산"><br>용<br>마<br>산 </div>
      <div id="ba1"><input type ="button" id="ha38" name="사가정"><br>사<br>가<br>정 </div>
      <div id="ba1"><input type ="button" id="ha39" name="면목"><br>면<br>목 </div>
      <div id="ba2"><input type ="button" id="ha40" name="상봉"><br>상<br>봉 </div>
      <div id="ba1"><input type ="button" id="ha41" name="중화"><br>중<br>화 </div>
      <div id="ba1"><input type ="button" id="ha42" name="먹골"><br>먹<br>골 </div>
      <div id="ba1"><input type ="button" id="ha43" name="태릉입구"><br>태<br>릉<br>입<br>구 </div>
      
      <div id="ba1"><input type ="button" id="ha44" name="공릉"><br>공<br>릉 </div>
      <div id="ba1"><input type ="button" id="ha45" name="하계"><br>하<br>계 </div>
      <div id="ba1"><input type ="button" id="ha46" name="중계"><br>중<br>계 </div>
      <div id="ba1"><input type ="button" id="ha47" name="노원"><br>노<br>원 </div>
      <div id="ba1"><input type ="button" id="ha48" name="마들"><br>마<br>들 </div>
      <div id="ba1"><input type ="button" id="ha49" name="수락산"><br>수<br>락<br>산 </div>
      <div id="ba1"><input type ="button" id="ha50" name="도봉산"><br>도<br>봉<br>산 </div>
      <div id="ba1"><input type ="button" id="ha51" name="장암"><br>장<br>암 </div>

	</div>
<script>
	
	
	let start;
	let value;
	let end;
	let flag=0;
	
	function showElement() {
	   	   if(flag==0)
	   		   {
	   			   start= this.name;
	   			  // getvalue();
	   		       alert("Start station : " +start);
	   		       if(start=="부평구청"){
	   		    	 value=1;
	   		       }
	   		    	  
	   		       flag=1;
	   		   }
	   	   else if(flag==1)
	   		   {
	   			   end= this.name;
	   		       alert("End station : " +end);
	   	       	   flag=0;
	   	           
	   		   }
	      }
	
   window.onload = function() {
      let el1 = document.getElementById("ha1");
      el1.addEventListener("click", showElement);
      let el2 = document.getElementById("ha2");
      el2.addEventListener("click", showElement);
      let el3 = document.getElementById("ha3");
      el3.addEventListener("click", showElement);
      let el4 = document.getElementById("ha4");
      el4.addEventListener("click", showElement);
      let el5 = document.getElementById("ha5");
      el5.addEventListener("click", showElement);
      
      let el6 = document.getElementById("ha6");
      el6.addEventListener("click", showElement);
      let el7 = document.getElementById("ha7");
      el7.addEventListener("click", showElement);
      let el8 = document.getElementById("ha8");
      el8.addEventListener("click", showElement);
      let el9 = document.getElementById("ha9");
      el9.addEventListener("click", showElement);
      let el10 = document.getElementById("ha10");
      el10.addEventListener("click", showElement);
      
      let el11 = document.getElementById("ha11");
      el11.addEventListener("click", showElement);
      let el12 = document.getElementById("ha12");
      el12.addEventListener("click", showElement);
      let el13 = document.getElementById("ha13");
      el13.addEventListener("click", showElement);
      let el14 = document.getElementById("ha14");
      el14.addEventListener("click", showElement);
      let el15 = document.getElementById("ha15");
      el15.addEventListener("click", showElement);
      
      let el16 = document.getElementById("ha16");
      el16.addEventListener("click", showElement);
      let el17 = document.getElementById("ha17");
      el17.addEventListener("click", showElement);
      let el18 = document.getElementById("ha18");
      el18.addEventListener("click", showElement);
      let el19 = document.getElementById("ha19");
      el19.addEventListener("click", showElement);
      let el20 = document.getElementById("ha20");
      el20.addEventListener("click", showElement);
      
      let el21 = document.getElementById("ha21");
      el21.addEventListener("click", showElement);
      let el22 = document.getElementById("ha22");
      el22.addEventListener("click", showElement);
      let el23 = document.getElementById("ha23");
      el23.addEventListener("click", showElement);
      let el24 = document.getElementById("ha24");
      el24.addEventListener("click", showElement);
      let el25 = document.getElementById("ha25");
      el25.addEventListener("click", showElement);
      
      let el26 = document.getElementById("ha26");
      el26.addEventListener("click", showElement);
      let el27 = document.getElementById("ha27");
      el27.addEventListener("click", showElement);
      let el28 = document.getElementById("ha28");
      el28.addEventListener("click", showElement);
      let el29 = document.getElementById("ha29");
      el29.addEventListener("click", showElement);
      let el30 = document.getElementById("ha30");
      el30.addEventListener("click", showElement);
      
      let el31 = document.getElementById("ha31");
      el31.addEventListener("click", showElement);
      let el32 = document.getElementById("ha32");
      el32.addEventListener("click", showElement);
      let el33 = document.getElementById("ha33");
      el33.addEventListener("click", showElement);
      let el34 = document.getElementById("ha34");
      el34.addEventListener("click", showElement);
      let el35 = document.getElementById("ha35");
      el35.addEventListener("click", showElement);
      
      let el36 = document.getElementById("ha36");
      el36.addEventListener("click", showElement);
      let el37 = document.getElementById("ha37");
      el37.addEventListener("click", showElement);
      let el38 = document.getElementById("ha38");
      el38.addEventListener("click", showElement);
      let el39 = document.getElementById("ha39");
      el39.addEventListener("click", showElement);
      let el40 = document.getElementById("ha40");
      el40.addEventListener("click", showElement);
      
      let el41 = document.getElementById("ha41");
      el41.addEventListener("click", showElement);
      let el42 = document.getElementById("ha42");
      el42.addEventListener("click", showElement);
      let el43 = document.getElementById("ha43");
      el43.addEventListener("click", showElement);
      let el44 = document.getElementById("ha44");
      el44.addEventListener("click", showElement);
      let el45 = document.getElementById("ha45");
      el45.addEventListener("click", showElement);
      
      let el46 = document.getElementById("ha46");
      el46.addEventListener("click", showElement);
      let el47 = document.getElementById("ha47");
      el47.addEventListener("click", showElement);
      let el48 = document.getElementById("ha48");
      el48.addEventListener("click", showElement);
      let el49 = document.getElementById("ha48");
      el48.addEventListener("click", showElement);
      let el50 = document.getElementById("ha48");
      el48.addEventListener("click", showElement);
      let el51 = document.getElementById("ha48");
      el48.addEventListener("click", showElement);
      
   }
  	 
      
 
</script>
<% 		
			      String[] rt = new String[51];
			      String[] rt_num = new String[51];
			      
			      int to=0;

	              Class.forName("com.mysql.jdbc.Driver");


	           
	              String dbInfo = "jdbc:mysql://localhost:3306/final2";

	              String dbID   = "root";

	              String dbPW = "tnthd!8253";
	              ResultSet rs = null;
	              
	              java.sql.Connection conn =  java.sql.DriverManager.getConnection( dbInfo, dbID, dbPW );
	              java.sql.Statement stmt = conn.createStatement();
	              String query = "select * from station order by num";
	              rs = stmt.executeQuery(query);
		          rs.beforeFirst();
				
		          int i=0;
		          while (rs.next() ) {
					  
		             // out.println( "지하철역" + rs.getString("station_name") );
		              rt[i] = rs.getString("station_name");
		              rt_num[i] = rs.getString("num");
			          //String rt="전역 출발";
		              System.out.println(rt[i]);
		         	  i++;
		          }	   
		          
	              rs.close();
	              stmt.close();
	              conn.close();	  
	              
%>

   
<form action="toilet.jsp">

		출발역 : <select name="code">
		<option value="1">부평구청</option>
		<option value="2">굴포천</option>
		<option value="3">삼산체육관</option>
		<option value="4">상동</option>
		<option value="5">부천시청</option>
		<option value="6">신중동</option>
		<option value="7">준의</option>
		<option value="8">부천종합운동장</option>
		<option value="9">까치울</option>
		<option value="10">온수</option>
		<option value="11">천왕</option>
		<option value="12">광명사거리</option>
		<option value="13">철산</option>
		<option value="14">가산디지털단지</option>
		<option value="15">남구로</option>
		<option value="16">대림</option>
		<option value="17">신풍</option>
		<option value="18">보라매</option>
		<option value="19">신대방삼거리</option>
		<option value="20">장승배기</option>
		<option value="21">상도</option>
		<option value="22">숭실대입구</option>
		<option value="23">남성</option>
		<option value="24">총신대입구</option>
		<option value="25">내방</option>
		<option value="26">고속터미널</option>
		<option value="27">반포</option>
		<option value="28">논현</option>
		<option value="29">학동</option>
		<option value="30">강남구청</option>
		<option value="31">청담</option>
		<option value="32">뚝섬유원지</option>
		<option value="33">건대입구</option>
		<option value="34">어린이대공원</option>
		<option value="35">군자</option>
		<option value="36">중곡</option>
		<option value="37">용마산</option>
		<option value="38">사가정</option>
		<option value="39">면목</option>
		<option value="40">상봉</option>
		<option value="41">중화</option>
		<option value="42">먹골</option>
		<option value="43">태릉입구</option>
		<option value="44">공릉</option>
		<option value="45">하계</option>
		<option value="46">중계</option>
		<option value="47">노원</option>
		<option value="48">마들</option>
		<option value="49">수락산</option>
		<option value="50">도봉산</option>
		<option value="51">장암</option>
		</br>
		</select>
		도착역 : <select name="code2">
		<option value="1">부평구청</option>
		<option value="2">굴포천</option>
		<option value="3">삼산체육관</option>
		<option value="4">상동</option>
		<option value="5">부천시청</option>
		<option value="6">신중동</option>
		<option value="7">준의</option>
		<option value="8">부천종합운동장</option>
		<option value="9">까치울</option>
		<option value="10">온수</option>
		<option value="11">천왕</option>
		<option value="12">광명사거리</option>
		<option value="13">철산</option>
		<option value="14">가산디지털단지</option>
		<option value="15">남구로</option>
		<option value="16">대림</option>
		<option value="17">신풍</option>
		<option value="18">보라매</option>
		<option value="19">신대방삼거리</option>
		<option value="20">장승배기</option>
		<option value="21">상도</option>
		<option value="22">숭실대입구</option>
		<option value="23">남성</option>
		<option value="24">총신대입구</option>
		<option value="25">내방</option>
		<option value="26">고속터미널</option>
		<option value="27">반포</option>
		<option value="28">논현</option>
		<option value="29">학동</option>
		<option value="30">강남구청</option>
		<option value="31">청담</option>
		<option value="32">뚝섬유원지</option>
		<option value="33">건대입구</option>
		<option value="34">어린이대공원</option>
		<option value="35">군자</option>
		<option value="36">중곡</option>
		<option value="37">용마산</option>
		<option value="38">사가정</option>
		<option value="39">면목</option>
		<option value="40">상봉</option>
		<option value="41">중화</option>
		<option value="42">먹골</option>
		<option value="43">태릉입구</option>
		<option value="44">공릉</option>
		<option value="45">하계</option>
		<option value="46">중계</option>
		<option value="47">노원</option>
		<option value="48">마들</option>
		<option value="49">수락산</option>
		<option value="50">도봉산</option>
		<option value="51">장암</option>
		</br>
		</select>
		<input type="submit" value="이동">
</form>
<% 
	String ht0= (String) request.getAttribute("h_t0");
	String ht1= (String) request.getAttribute("h_t1");
	String ht2= (String) request.getAttribute("h_t2");
	String ht3= (String) request.getAttribute("h_t3");
	String ht4= (String) request.getAttribute("h_t4");
	String ht5= (String) request.getAttribute("h_t5");
	String ht6= (String) request.getAttribute("h_t6");
	
	
    
%>
<form action="result.jsp">

		화장실 : <select name="code3">
		<option value="<%=ht0 %>"><%=ht0 %></option>
		<option value="<%=ht1 %>"><%=ht1 %></option>
		<option value="<%=ht2 %>"><%=ht2 %></option>
		<option value="<%=ht3 %>"><%=ht3 %></option>
		<option value="<%=ht4 %>"><%=ht4 %></option>
		<option value="<%=ht5 %>"><%=ht5 %></option>
		<option value="<%=ht6 %>"><%=ht6 %></option>
		
		</select>

		<input type="submit" value="내리기!">
</form>

<div id="baba">

1:<%=ht0 %>
2:<%=ht1 %>
3:<%=ht2 %>
4:<%=ht3 %>
5:<%=ht4 %>
6:<%=ht5 %>
7:<%=ht6 %>
</div>


</body>
</html>