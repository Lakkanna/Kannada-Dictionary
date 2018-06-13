<?php
	$link = mysqli_connect('127.0.0.1','root','');
	if (!$link)
		{ 
			die('Could not connect to MySQL: ' . mysqli_connect_error());
		}
	mysqli_select_db($link,"dictionary") or die (mysqli_connect_error());
?>