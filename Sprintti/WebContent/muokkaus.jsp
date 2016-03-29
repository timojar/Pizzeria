<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ page import="fi.omapizzeria.admin.bean.*"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${pizza}" var="pizzat">

<h1>
<c:out value="${pizzat.nimi }"></c:out>
</h1>

<form action="MuokkaaPizza" method="post">
<input type="hidden" name="id" value="${pizzat.id}">
<label>Nimi</label>

<input type="text" name="nimi" placeholder="${pizzat.nimi }">
<br>
<label>Hinta</label>
<input type="text" name="hinta" placeholder="${pizzat.hinta }">

<p>

<c:out value="${pizzat.kuvaus}"></c:out>
</p>

		<br>
			<label>Valitse uudet täytteet (max 6)</label>
				<br>
			
			<c:forEach items="${taytelista}" var="tayte"> 
		
		<label> <input type="checkbox" name="taytteet" value="${tayte.tayteNimi}"> 
		<c:out value="${tayte.tayteNimi}">
		</c:out> </label>
		
			
			</c:forEach>
<input type="submit" value="Tallenna">

</form>

				
<c:choose>

<c:when test="${pizzat.piiloitus != 'nosale'}">
<form action="piilotaPaljastapizza" method="post" id="hide">	
<input type="hidden" name="hide" value="${pizzat.id }">		
<input	type="submit"  value="Poista ruokalistasta">
</form>	
</c:when>


				
				

<c:when test="${pizzat.piiloitus == 'nosale'}">
<form action="piilotaPaljastapizza" method="post" id="reveal">	
<input type="hidden" name="reveal" value="${pizzat.id }">		
<input	type="submit"  value="Lisää ruokalistaan">
</form>	

</c:when>


</c:choose>

</c:forEach>



<form action="controller">

<input type="submit" value="Lopeta muokkaaminen">

</form>



</body>
</html>