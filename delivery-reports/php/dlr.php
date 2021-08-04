<?php
$username = '<api_key>';
$password = '<secret_key>';

$URL = 'https://apisms.beem.africa/public/v1/delivery-reports';

$dest_addr = '<dest_addr>';
$request_id = '<request_id>';
$body = array('request_id' => $request_id,'dest_addr' => $dest_addr);

// Setup cURL
$ch = curl_init();
error_reporting(E_ALL);
ini_set('display_errors', 1);

$URL = $URL . '?' . http_build_query($body);

curl_setopt($ch, CURLOPT_URL, $URL);
curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);
curl_setopt_array($ch, array(
    CURLOPT_HTTPGET => true,
    CURLOPT_RETURNTRANSFER => true,
    CURLOPT_HTTPHEADER => array(
        'Authorization:Basic ' . base64_encode("$username:$password"),
        'Content-Type: application/json',
    ),
));

// Send the request
$response = curl_exec($ch);

// Check for errors
if ($response === false) {
    echo $response;

    die(curl_error($ch));
}
var_dump($response);
?>