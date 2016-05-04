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

<h1><c:out value="${tayte.tayteNimi}"></c:out></h1>
<form action="Taytteelle" method="post">
<input type="hidden" name="id" value="${tayte.id}">
<label>Tayte nro <c:out value="${tayte.id}"></c:out></label>
<br>
<label>Nimi</label>
<input type="text" value="${tayte.tayteNimi}" name="nimi" >
<br>
<label>Lisää saatavuutta (<c:out value="${tayte.saatavuus}"></c:out>)</label>
<input type="text" placeholder="0" name="maara" >
<br>
<input type="submit" value="Lähetä tiedot">
</form>

<form action="SelaaTaytteet" method="get">

<input type="submit" value="Lopeta muokkaaminen">

</form>

</body>
</html>