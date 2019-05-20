<?php

//

$email = $_GET['email'];
$username = $_GET['username'];
$password = $_GET['password'];

$password = str_replace("ⱣⱤⱪⱩḁḩḭṉẄẂṖẍẔẚἾỶẪỈỦἎἆỡ", "", $password);
$password = str_replace("ⱣⱤⱪⱩḁḩἾỶẪỈỦἎἆỡ", "", $password);

$to      = $email;
$subject = 'Password Recovery';
$message = "Hey, $username!\n\nYou have requested to recover your password using the Shell application. Your password is provided below : \n\n$password";
$message.= "\n\nIf you were not expecting this email, please contact the administrator.";
$headers = 'From: Shell Support <support@shell.com>';

mail($to, $subject, $message, $headers);

$domain = substr(strrchr($email, "@"), 1);

header("Location: http://www.".$domain);
exit();

?>