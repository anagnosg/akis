<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    
}

* {
    box-sizing: border-box;
}

/* Add padding to containers */
.container {
    padding: 10px;
    background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 50%;
    padding: 5px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border-color: black;
    background-color: white;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Overwrite default styles of hr */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 10px;
}

/* Set a style for the submit button */
.register {
    background-color: white;
    color: black;
    padding: 10px 15px;
    margin: 8px 0;
    border-color: blue;
    cursor: pointer;
    width: 40%;
    opacity: 0.9;
}

.register:hover {
    opacity: 1;
}

/* Add a blue text color to links */
a {
    color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
    background-color: #f1f1f1;
    text-align: center;
}
</style>
</head>
<body>



<?php
				if(isset($_POST["username"])){

				/*	$con = mysql_connect("localhost","admin","admin");
					if (!$con){
						die('Could not connect: ' . mysql_error());
					}

					mysql_select_db("my_db", $con);

			
					$sql = "INSERT INTO `my_db`.`users_id` (`username`, `password`, `firstname`, `lastname`, `email`)".
					"VALUES ('". mysql_real_escape_string($_POST["username"])
					."', '".mysql_real_escape_string($_POST["password"])
					."', '".mysql_real_escape_string($_POST["firstname"])
					."', '".mysql_real_escape_string($_POST["lastname"])
					."', '".mysql_real_escape_string($_POST["email"])
					."');";			

			
					mysql_query($sql);
					mysql_close($con);
                       
				    echo "Τα στοιχεία σας στάλθηκαν επιτυχως!!!";
                    echo "<script>setTimeout(\"location.href = 'index.php';\",3000);</script>";
                        */
				}
				else {
					?>
<form>

    
    
    <hr>

    Username: &nbsp;  &nbsp; &nbsp;  &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp;  
    <INPUT type="text" name="username" size="15" maxlength="15"> <BR> 

    Password: &nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp; &nbsp; &nbsp;  &nbsp; 
    <INPUT type="text" name="password" size="15" maxlength="15"> <BR> 
 
    Confirm Password: &nbsp;
    <INPUT type="text" name="confirm password" size="15" maxlength="15"> <BR>
    
    Όνομα: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <INPUT type="text" name="Όνομα" size="15" maxlength="15"> <BR>
    
    Επίθετο: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <INPUT type="text" name="Επίθετο" size="15" maxlength="15"> <BR>
    
    e-mail:  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
    <INPUT type="text" name="e-mail" size="15" maxlength="15"> <BR>
    
    
    <hr>
    <p>Η συμπλήρωση όλων των πεδίων είνα υποχρεωτική</p>

    <button type="submit" class="register">Εγγραφή</button>
    <button type="submit" class="register">Καθαρισμός Πεδίων</button>
  </div>
  
  
</form>
<?php
				}
?>
</body>
</html>
