<?php
extract($_POST);
$word = $_POST['word'];
$data = array();
$data['error'] = false;
$data['message'] = "Success";
$data['detail'] ="Word meaning is lucky";
echo json_encode($data);
?>