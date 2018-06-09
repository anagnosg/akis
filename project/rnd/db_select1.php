
<?php
$servername = "localhost";
$username = "roinas";
$password = "roinas";

// Create connection
$conn = new mysqli($servername, $username, $password);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
echo "Connected successfully";
$sql = "SELECT PASSWORD from project.users";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "password: " . $row["PASSWORD"]."<br>";
    }
} else {
    echo "0 results";
}
$conn->close();
?>





