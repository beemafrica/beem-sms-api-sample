var request = require("request");

var options = { method: 'GET',
    url: 'http://www.bongolive.co.tz/api/sendSMS.php?',
    qs: 
        { sendername: 'Enter your sendername',
            username: 'Enter username',
            password: 'Enter your password',
            apikey: 'Enter your apikey',
            destnum: 'Enter your destnation number',
            message: 'Enter your message',
            senddate: '',
            format: 'json' },
        headers: { 'cache-control': 'no-cache' } };

request(options, function (error, response, body) {
    if (error) throw new Error(error);
        console.log(body);
            });