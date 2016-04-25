<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:forEach items="${tilaukset}" var="tilaus" >

<p><c:out value="${tilaus.numero }"></c:out></p>

<p><c:out value="${tilaus.tilausAsiakas.osoite}"></c:out></p>
<p><c:out value="${tilaus.tilausAsiakas.postinro}"></c:out></p>
<p><c:out value="${tilaus.tilausAsiakas.tmp}"></c:out></p>
<p><c:out value="${tilaus.tilausAsiakas.etunimi}"></c:out></p>

<p><c:out value="${tilaus.tilausAsiakas.sukunimi}"></c:out></p>

<p><c:out value="${tilaus.tilausAsiakas.email}"></c:out></p>

<p><c:out value="${tilaus.yhteishinta}"></c:out></p>


<form action="Tilaukselle" method="get">

<input type="hidden" value="${tilaus.numero }" name="numero">

<input type="submit" value="Katso Tilausta">

<br>
<br>
<br>
</form>

</c:forEach>


</body>
</html>