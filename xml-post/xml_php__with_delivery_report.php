<?php
        define ("URL_API_DOMAIN", "http://www.bongolive.co.tz/api/broadcastSMS.php");
        $sendername = "Bongo Live";
        $username = "testaccount";
        $password = "123456";
        $apikey = "c4a12fa8-ed6f-11df-a1f1-00181236674f";
        $callbackURL = "http://www.yourdomain.com/sms/dlr.php";
        $messageXML = "
<Broadcast>
    <Authentication>
        <Sendername>".$sendername."</Sendername>
        <Username>".$username."</Username>
        <Password>".$password."</Password>
        <Apikey>".$apikey."</Apikey>
    </Authentication>
        <Message>
            <Content>Test Message</Content>
            <Receivers>
                <Receiver id='7772237998'>255655123123</Receiver>
            </Receivers>
                <Callbackurl>".$callbackURL."</Callbackurl>
        </Message>
 </Broadcast>";
 $data = array('messageXML' => $messageXML);
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, URL_API_DOMAIN);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($ch, CURLOPT_TIMEOUT, 4);
    curl_setopt($ch, CURLOPT_POST, 1);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $data);

  $response = curl_exec($ch);
  echo "response = $response ";
 ?>