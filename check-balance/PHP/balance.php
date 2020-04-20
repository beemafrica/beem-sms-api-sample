?php

define ("URL_API_DOMAIN", "http://www.bongolive.co.tz/api/");
$username = "Enter your username";
$password = "Enter your password";
$request = "balance";

$posturl = "http://www.bongolive.co.tz/api/request.php?username=$username&password=$password&request=$request";

$ch=curl_init();
curl_setopt($ch, CURLOPT_URL, $posturl);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
$response = curl_exec($ch);

echo "response $response";

?>