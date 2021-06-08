<?php

$data = file_get_contents('https://www.callback.example');

$data = json_decode($data, true);
    $request_id=$data['request_id'];
    $recipient_id=$data['recipient_id'];
    $dest_addr=$data['dest_addr'];
    $Status=$data['Status'];

$res= array('request_id' => $request_id, 'successful'=>'TRUE');
 
$json = json_encode($res);
echo $json;
?>