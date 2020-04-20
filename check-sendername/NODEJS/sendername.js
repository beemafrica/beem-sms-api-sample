var request = require("request");

var options = { method: 'GET',
  url: 'http://www.bongolive.co.tz/api/request.php?',
  qs: {

     username: 'Enter your username',
	 password: 'Enter your password',
	 request: 'sender',
	 
	 
     format: 'json' },
  headers: { 'cache-control': 'no-cache' } };

request(options, function (error, response, body) {
  if (error) throw new Error(error);
	  console.log(body);
	});