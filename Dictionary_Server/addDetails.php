<?php
extract($_GET);
$newWord = $_GET['newWord'];
$meaning = $_GET['meaning'];

$status = "Success";
$result = array();
$result['status'] = "Success";
echo json_encode($result);
?>