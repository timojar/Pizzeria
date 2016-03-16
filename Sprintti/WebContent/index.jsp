<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<link href="tyyli.css" rel="stylesheet" type="text/css">

<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet" href="materialize.min.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>
<body>
	<!--Import jQuery before materialize.js-->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>

	<!-- --- <div id="raamit">

<div id="header">

<div id="nav1">
<p> MENU </p>
</div>

<div id="nav2">
<p> ABOUT </p>
</div>

<div id="nav3">
<p>  </p>
</div>

<div id="nav4">
<p> ORDER ONLINE </p>
</div>

<div id="nav5">
<p> GROUP DINING</p>
</div>


 </div>

<div id="sisalto"> 



<div id="slideshow">
<p> SLIDESHOW </p>

</div>

<div id="container1">
<p> Osoite <br> Googlemap </p>
</div>

<div id="container2">
<p> Aukioloajat </p>
</div>

<div id="container3">
<p> Facebook <i class="material-icons">add</i> <br><br> Instagram  <i class="material-icons">stay_current_portrait</i> <br><br> Ota yhteyttä <i class="material-icons">dialpad</i> </p>
</div>

</div>

<div id="footer"> <footer class="page-footer">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">Late Night Show with Aarninsalo</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
              
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2014 Copyright Text
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>


</div>
</div>

</body>
</html> 
 -->

	<!-- CSS  -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
		rel="stylesheet">
	<link href="materialize.css" type="text/css" rel="stylesheet"
		media="screen,projection" />
	<link href="style.css" type="text/css" rel="stylesheet"
		media="screen,projection" />
		<link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
</head>
<body>

    <div class="navbar-fixed">
	 <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo center"><img src="Kuvat/Logo.png" alt=pizza height="76" width="160"></a>
      <ul id="nav-mobile" class="left hide-on-med-and-down">
        <li><a href="sass.html">Menu</a></li>
        <li><a href="badges.html">Order Online</a></li>
        <li><a href="collapsible.html">About</a></li>
        <li><a href="#">Group Dining</a>
      </ul>
    </div>
  </nav>
  </div>
	<div class="section no-pad-bot" id="index-banner">
		<div class="container">
			<br> <br>
			<h1 class="header center orange-text">Castello e Fiori</h1>
			<div class="row center">
				<h5 class="header col s12 light">Moderni, mutta perinteinen. Vuodesta 1800.</h5>
			</div>
			<div class="row center">
				<a href="http://materializecss.com/getting-started.html"
					id="download-button"
					class="btn-large waves-effect waves-light orange">Siirry ruokalistaan</a>
			</div>
			<br> <br>

		</div>
	</div>

<div class="slider">
    <ul class="slides">
      <li>
        <img src="Kuvat/EtusivuPitsa.jpg"> <!-- random image -->
        <div class="caption center-align">
          <h3>Castello e Fiori</h3>
          <h5 class="light grey-text text-lighten-3">Benvenuti!</h5>
        </div>
      </li>
      <li>
        <img src="Kuvat/fiori_Castle.jpg"> <!-- random image -->
        <div class="caption left-align">
          <h3>Tule ja koe Italia</h3>
          <h5 class="light grey-text text-lighten-3">Nauti aidosta tunnelmasta.</h5>
        </div>
      </li>
      <li>
        <img src="Kuvat/inside_pizzeria.jpg"> <!-- random image -->
        <div class="caption right-align">
          <h3>Valitse oma makusi</h3>
          <h5 class="light grey-text text-lighten-3">Valikoimamme on perinteinen ja moderni.</h5>
        </div>
      </li>
      <li>
        <img src="Kuvat/sunset.jpg"> <!-- random image -->
        <div class="caption center-align">
          <h3>This is our big Tagline!</h3>
          <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        </div>
      </li>
    </ul>
  </div>

	<div class="container">
		<div class="section">

			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">room</i>
						</h2>
						<h5 class="center">Sijainti</h5>

						<p class="light">
						<br><br>
							<b>Ravintolamme sijaitsee helppojen kulkuyhteyksien päässä, Pasilan
							sydämessä.<br><br> Osoite: Ratapihantie 13, 00520 Helsinki</b><br><br>
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d991.3802553818812!2d24.93392552634419!3d60.201246179597305!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0000000000000000%3A0xda28003f60191bc5!2sHaaga-Helia+ammattikorkeakoulu!5e0!3m2!1sfi!2sfi!4v1457958126559"
								width="400" height="300" frameborder="0" style="border: 0"
								allowfullscreen></iframe>
						</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">schedule</i>
						</h2>
						<h5 class="center">Aukioloajat</h5>

						<p class="light">
						<br><br>
							<b>Olemme avoinna seuraavina kellonaikoina: <br><br>
							
							<div class="row">
      <div class="col s12 m5">
        <div class="card-panel teal">
          <span class="white-text"> Ma-Pe
							10:00-23:00<br> La 11.00-22.00<br> Su 12.00-18.00<br><br></b>
          </span>
        </div>
      </div>
    </div> Erikoistapauksissa ja varatuissa tilaisuuksissa ajankohdat voivat vaihdella. Lisätietoa niistä saat olemalla meihin yhteydessä.<br><br>
							<b><i>Tervetuloa kokemaan aitoa italialaista perinnettä.</i></b>
						</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons">stay_current_portrait</i>
						</h2>
						<h5 class="center">Ota yhteyttä</h5>

						<p class="light"><br><br><b>Löydät meidät yleisimmistä sosiaalisen median
							sivustoista, mukaan lukien Facebookista ja Instagramista. Voit
							myös ottaa meihin suoraan yhteyttä.<br><br>
							
						<!--	<b>Facebook</b> <a href="https://facebook.com/" target="_blank"><i class="small material-icons">forum</i></a><br><br>
							 <b>Instagram</b> <a href="https://www.instagram.com/" target="_blank"><i class="small material-icons">forum</i></a><br><br>
							  <b>Linkedin</b> <a href="https://www.instagram.com/" target="_blank"><i class="small material-icons">forum</i></a></p>
							  -->
							  <br><br><br>
							  <a class="waves-effect waves-light btn-large"><i class="material-icons left">cloud</i>Facebook</a>
							  <a class="waves-effect waves-light btn-large"><i class="material-icons left">cloud</i>Instagram</a><br><br>
							  <a class="waves-effect waves-light btn-large"><i class="material-icons left">cloud</i>Linkedin</a>
							   <a class="waves-effect waves-light btn-large"><i class="material-icons left">cloud</i>Twitter</a>
					</div>
				</div>
			</div>

		</div>
		<br> <br>

		<div class="section"></div>
	</div>

 <footer class="page-footer">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Tietoa yrityksestä</h5>
                <p class="grey-text text-lighten-4">Castello e Fiori on
					perinteinen italialaishenkinen Pizzaravintola, jolla on perinteet
					syvällä Italian historiassa. Perustettu vuonna 1800, perustamme
					suosiomme perinteisiin ja aitoihin italialaisiin makuelämyksiin.
					Tule ja koe aitoa Venetsialaista henkeä.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Menu</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Group dining</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Order online</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Social media</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2016 Late Night Show with Aarninsalo
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>
        
	<!--  Scripts-->
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="js/materialize.js"></script>
	<script src="js/init.js"></script>

</body>
</html>