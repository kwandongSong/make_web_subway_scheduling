<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<% 
	String htt0= (String) request.getAttribute("h_tt0");
	String htt1= (String) request.getAttribute("h_tt1");
	String htt2= (String) request.getAttribute("h_tt2");
	String htt3= (String) request.getAttribute("h_tt3");
	String htt4= (String) request.getAttribute("h_tt4");
	String htt5= (String) request.getAttribute("h_tt5");
	String htt6= (String) request.getAttribute("h_tt6");
	String htt7= (String) request.getAttribute("h_tt7");
	out.println(htt0);
	out.println(htt1);
	out.println(htt2);
	out.println(htt3);
	out.println(htt4);
	out.println(htt5);
	out.println(htt6);
	out.println(htt6);
%>


</body>
</html>