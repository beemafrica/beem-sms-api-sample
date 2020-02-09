<?php
        //======================REQUIRED INFORMATION ============================
        
        date_default_timezone_set('Africa/Nairobi');
        $sendername = "Enter your sender name";
        $username = "Enter your Bongolive username";
        $password = "Enter your Bongolive Password";
        $apikey = "Enter Key obtained from your Bongolive Account";
        $mob="Enter destination mobile number with plus sign eg 255688121252";
        $message = "Enter your message content here";
        
        //==========================END OF REQUIRED INFORMATION ====================
        
        
        //==================OPTIONAL REQUIREMENTS =========================================
        
        $senddate = ""; //leave blank if you want an sms to be sent immediately or eg 31/03/2014 12:54:00 or 2014-03-31 12:54:00
        $proxy_ip = ""; //leave blank if your network environment does not support proxy
        $proxy_port = ""; //set your network port, leave black if your network environment does not support proxy
        
        //===================== END OF OPTIONAL REQUIREMENT ===========================
        
        
        //===============================DO NOT EDIT ANYTHING BELOW ===================
        
        $sendername = urlencode($sendername);
        $apiKey = urlencode($apikey);
        $destnum = urlencode($mob);
        $message = urlencode($message);


        if(!empty($senddate)) {
            $senddate = strtotime("2014-05-03 13:50:00");
        }

        $posturl = "http://www.bongolive.co.tz/api/sendSMS.php?sendername=$sendername&username=$username&password=$password&apikey=$apiKey&destnum=$destnum&message=$message&senddate=$senddate";
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $posturl);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_CONNECTTIMEOUT ,0);
        curl_setopt($ch, CURLOPT_TIMEOUT, 500); //tim

        if ($proxy_ip !="") {
            curl_setopt($ch, CURLOPT_PROXYPORT, $proxy_port);
            curl_setopt($ch, CURLOPT_PROXYTYPE, 'HTTP');
            curl_setopt($ch, CURLOPT_PROXY, $proxy_ip);
        }

        $response = curl_exec($ch);
        
        //===============YOU CAN EDIT BELOW ===
        echo $response;
?>