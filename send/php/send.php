<?php
// Your ID and token
$authToken = 'Basic NWYwOTU4ZDM1ZDgwM2ZlYzpNamhsTUdGbFkyWXpObUk1TVRZd01qZzRZamhtWW1GbU5HSTJOakZsTnprMU16WXlaRFJsTTJOa09HWXdZamd3TlRZeU1HUm1aRFUwTldGa05qSTBOZz09';
$Url ='https://sms.bongolive.africa/api/v1/send';
// The data to send to the API
error_reporting(E_ALL);
ini_set('display_errors', 1);
$postData = array(
    'source_addr' => 'INFO',
    'schedule_time' => '',
    'message' => 'Hello World',
    'recipients' => array('recipient_id' => '1','dest_addr'=>'255700000001')
);
// Setup cURL
$ch = curl_init($Url);
curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);
curl_setopt_array($ch, array(
    CURLOPT_POST => TRUE,
    CURLOPT_RETURNTRANSFER => TRUE,
    CURLOPT_HTTPHEADER => array(
        'Authorization: '.$authToken,
        'Content-Type: application/json'

    ),
    CURLOPT_POSTFIELDS => json_encode($postData)
));

// Send the request
$response = curl_exec($ch);

// Check for errors
if($response === FALSE){
    echo $response;

    die(curl_error($ch));
}

// Decode the response
$responseData = json_decode($response, TRUE);
echo "success";
var_dump($responseData);