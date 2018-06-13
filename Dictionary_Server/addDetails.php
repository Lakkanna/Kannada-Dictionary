<?php
	include_once dirname(__FILE__).'/dbConnect.php';
	extract($_GET);
	$txt1=$newWord;
	$txt2=$meaning;
	$encoded_newWord=mb_convert_encoding($txt1, 'UTF-8');
	$encoded_meaning=mb_convert_encoding($txt2, 'UTF-8');
	//$meaning="Unnecessary, especially through being more than enough.";
	$response = array();
	$result = mysqli_query($link,"INSERT INTO `details` (`id`, `word`, `detail`) VALUES (NULL, '$encoded_newWord', '$encoded_meaning')");
	if($result)
	{
		$response['status'] = "$encoded_newWord word added!";
	}
	else
	{
		$response['status'] = "Failed to add word into database!(Word may already exists)";
	}
	
	//$response['status']= "success";
		header('Content-Type:Application/json');
	echo json_encode($response);
?>