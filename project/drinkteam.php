<?php session_start(); //ksekinaei ena session. ?>
<!DOCTYPE html>
<html>
<title>Drinkteam Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
body,h1 {font-family: "Raleway", Arial, sans-serif}
h1 {letter-spacing: 6px}
.w3-row-padding img {margin-bottom: 12px}

</style>

<style>
.myButton {
 position:fixed;
 right:120px;
 top:10px;  
 padding-top: 10px;
 color: black;
    
    
}
</style>
<style>
.logoutLblPos{
 position:fixed;
   right:30px;
   top:20px;
   
}
</style>

<style>
form {

    padding-top: 50px;
    padding-right: 30px;
    padding-bottom: 70px;
    padding-left: 20px;
    text-align: center;
}
</style>

</head>
<body>

<!-- !PAGE CONTENT! -->
<div class="w3-content" style="max-width:1500px">

<!-- Header -->
<header class="w3-panel w3-center w3-opacity" style="padding:120px 16px">
  
  <h1>Drink<img src="eikones_balas\balla.jpg" style="width:3.2%">Team</h1> 
  <br>
  
  <h3>Μάθε Μπαλίτσα</h3>
  
  <div class="w3-padding-32">
    <div class="w3-bar w3-border">
      <a href="#" class="w3-bar-item w3-button">Home</a>
      <a href="#" class="w3-bar-item w3-button">Add New Photos</a>
      <a href="#" class="w3-bar-item w3-button">Search photos</a>
	  <a href="#" class="w3-bar-item w3-button">Voting</a>
      <a href="#" class="w3-bar-item w3-button w3-hide-small">Search map photos</a>
	  <a href="#" class="w3-bar-item w3-button w3-hide-small">Top 5</a>
      <a href="#" class="w3-bar-item w3-button w3-hide-small">Contact us</a> 
      </div><br><br><br>
	  
	  <iframe width="560" height="315"
      src="https://www.youtube.com/embed/FhqHVBG7SsQ">
      </iframe>
	  <p>Το πιο αστείο Video της εβδομάδας by www.luben.gr</p>
	  

	  
	  <form align="right" name="form1" method="post" action="log_out.php">
  <label class="logoutLblPos">
  <input name="submit2" type="submit" id="submit2" value="Έξοδος">
  </label>
  <a href="#"style="color:blue" class="myButton">Επισκέπτης</a>
</form> 

 	  
</header>

<div style="background-color:#ff0000;color:white;padding:10px;">
  
  <p>Το πρώτο Ελληνικό αθλητικό site για ποδοσφαιρόφιλους αλλά και προπονητολάγνους.Φωτογραφίες,ψηφοφορίες,ειδήσεις,σχόλια.Στο παράπανω μενού μπορείς να βρείς μια μεγάλη 
  γκάμα φωτογραφιών και πληροφοριών όπως επίσης και τη δυνατότητα να ανεβάσεις αθλητικό υλικό.Εάν δεν είσαι μέλος μπόρείς να περιηγηθείς ως Επισκέπτης αλλά δεν μπορείς να 
  ανεβάσεις φωτογραφία.Γιατί χάνεις την ευκαιρία γίνε μέλος και εσύ!.</p>
</div> 


<div class="w3-row-padding w3-greenscale" style="margin-bottom:128px">
  <div class="w3-half">
    <img src="eikones_balas\drink-team.jpeg" style="width:190%">
	</div>
	</div>
	
<?php
	if(isset($_POST["username"])){
					//Syndeetai me thn bash , me stoixeia sundeshs localhost pou einai o server server. admin username kai password admin.
					$servername = "localhost";
					$username = "roinas";
					$password = "roinas";

					// Create connection
					$conn = new mysqli($servername, $username, $password,"project");

					// Check connection
					if ($conn->connect_error) {
						die("Connection failed: " . $conn->connect_error);
					} 
					//echo "Connected successfully";
					// epilegeis apo ton server thn bash project
											
					
					
					//$sql = "INSERT INTO USERS (USERNAME,PASSWORD,LASTNAME,FIRSTNAME,EMAIL ) VALUES('ANAGNOSG1','KODIKOS','ANAGNOSG','GEORGE','ANAGNOSG@GMAIL.COM')";
					//SELECT * FROM users where USERNAME = 'anagnosg' and PASSWORD = 'anagnosg'
					
					$sql = "SELECT * FROM users where USERNAME = '".$_POST["username"]."' and PASSWORD = '".$_POST["password"]."'";	
					
					
					$found = 0;
					
					//EKTELESH  QUERY
					$result = $conn->query($sql);
					if ($result->num_rows > 0) {
						$found = 1;

						}
					//kleineis to konnection me thn bash.
					$conn->close();
                    // bgazeis mhnimata.
					
					
					if ($found) {
						$_SESSION["USER"] = $_POST["username"];
                        ?><script> window.location.href = "drinkteam.php" </script><?php
                        
					}
					else{
                        
						echo "Το όνομα χρήστη ή ο κωδικός πρόσβασης δεν είναι έγκυρος!";
                        echo "<script>setTimeout(\"location.href = 'drinkteam.php';\",1500);</script>";
                        
					}
                    
					
	}
?>
<?php 
if (isset($_SESSION["USER"])){
	echo "Καλως ήρθες".$_SESSION["USER"]; 
?>
	
<?php
}
else { 
?>



<form method="POST">
  Username:<br>
  <input type="text" name="username" value="">
  <br>
  Password:<br>
  <input type="password" name="password" value="">
  <br><br>
 <button type="submit" >Είσοδος</button><Br><br>
  <a href="#" style="color:blue">Νέος&nbspχρήστης?</a><br><br>
  </form> 
<?php
}
  ?>
  <!-- Footer -->
<footer class="w3-container w3-padding-32 w3-light-grey w3-center w3-large"> 
  <i class="fa fa-facebook-official w3-hover-opacity"></i>
  <i class="fa fa-twitter w3-hover-opacity"></i>
  <i class="fa fa-linkedin w3-hover-opacity"></i>
  <p>Supported by <a href="http://www.aek365.com/a-584817/aponomh-kai-fiesta-sto-oaka.htm" target="_blank" class="w3-hover-text-yellow">aek_mono!</a></p>
  
</footer>

</body>
</html>
