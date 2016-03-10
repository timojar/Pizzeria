<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> <a href="controller">Listalle</a></p>

<form action="tayteController" method="post">
<label>Täytteen nimi</label>
<input type="text" name="tayteNimi">

<label>Saatavuus</label>
<input type="text" name="saatavuus">

<input type="submit" value="Luo täyte">

</form>



</body>
</html>