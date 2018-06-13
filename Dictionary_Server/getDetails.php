<?php
	extract($_POST);
	//$text = "Test";
	$text=$word;
	//$encoded_word="Test";
	$encoded_word=mb_convert_encoding($text, 'UTF-8');
	$response = array();
	include_once dirname(__FILE__).'/dbConnect.php';
	$result = mysqli_query($link,"SELECT word,detail FROM `details` WHERE word='$encoded_word'");
			if($result)
			{
				if($row=mysqli_fetch_row($result))
				{
					$response['word']=$row[0];
					$response['detail']=$row[1];//"Dictionary is dict";//$row[1];
					$response['message'] = "Successful!";
					$response['error'] = false;
				}	
				else{
					//echo "word not found";
					$response['word']="";
					$response['detail']="";
				$response['error'] = true;
				$response['message'] = "word not found!";
				}
			}
			else{
				$response['word']="";
				$response['detail']="";
				$response['error'] = true;
				$response['message'] = "Something went wrong!";
			}
			header('Content-Type:Application/json');
	echo json_encode($response);

?>