<?php session_start();

if(isset($_POST["signout"])){
unset($_SESSION["USER"]);
echo "Επιτυχημλένη έξοδος"
echo "<script>setTimeout(\"location.href = 'drinkteam.php';\",1500);</script>";
}
?>
<!DOCTYPE html>
<html>
<head>
<title>Font Awesome Icons</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<h1>sign-out</h1>

<form method="POST">
<input type="submit" value="Έξοδος"/> 

<input type="hidden" name="signout" value="signout" />
</form>

</body>
</html> 