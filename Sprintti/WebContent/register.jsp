<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="tyyli.css" rel="stylesheet" type="text/css">
<link href="styles.css" rel="stylesheet" type="text/css">
<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="materialize.min.css"
	media="screen,projection" />
<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Register</title>

<!-- CSS  -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
		rel="stylesheet">
	<link href="materialize.css" type="text/css" rel="stylesheet"
		media="screen,projection" />
	<link href="style.css" type="text/css" rel="stylesheet"
		media="screen,projection" />
	<link href='https://fonts.googleapis.com/css?family=Pacifico'
		rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Oswald'
		rel='stylesheet' type='text/css'>
		
</head>
<body>

<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      
      <div class="navbar-fixed">
		<%@ include file="pizzerianav.jsp" %>
	</div>
	<br>
	<br>
	<h4>Rekister�idy</h4><br>
	<p><b><i>T�yt� kaikki allaolevat kohdat ja paina "Rekister�idy".</b></i></p>
	<br><br><br>
	 <div class="row">
    <form class="col s5" action="LuoAsiakas" method="post">
      <div class="row">
        <div class="input-field col s6">
         <i class="material-icons prefix">perm_identity</i>
          <input id="Etunimi" length="15" type="text" class="validate" name="enimi">
          <label for="Sukunimi">Etunimi</label>
        </div>
        <div class="input-field col s6">
         <i class="material-icons prefix">perm_identity</i>
          <input id="Sukunimi" length="15" type="text" class="validate" name="snimi">
          <label for="Sukunimi">Sukunimi</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
        <i class="material-icons prefix">phone</i>
          <input type="text" length="15" id="numero" class="validate" name="numero">
          <label for="numero">Puhelinnumero (+358)</label>
        </div>
      </div>
      
      <div class="row">
        <div class="input-field col s12">
         <i class="material-icons prefix">email</i>
          <input id="email" type="email" length="20" class="validate" name="email">
          <label for="email">Email</label>
        </div>
      </div>
      
      <div class="row">
        <div class="input-field col s12">
        <i class="material-icons prefix">vpn_key</i>
          <input id="Salasana"  length="15" type="password" class="validate" name="salasana">
          <label for="Salasana">Salasana</label>
        </div>
      </div>
      
      <br>
			<button class="btn waves-effect waves-light" type="submit"
				name="">
				Rekister�idy <i class="material-icons right"></i>
			</button>
    </form>
  </div>
	
	
</body>
</html>