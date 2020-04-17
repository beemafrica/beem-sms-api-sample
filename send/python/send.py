sender='Enter Sendername'
username='enter Username'
password='Enter password'
apiKey='Enter apikey'
destnum='Enter destnation number'
msg='Enter your message'
senddate='Enter sendedate'


req = sendSMS(
    sender=sender,
    username=username,
    password= password,
    apiKey=apiKey,
    destnum=destnum,
    message=msg,
    senddate=senddate
)

def sendSMS(sendername, username, password, apikey, destnum, message, senddate):
    
    
    params = {
        'sendername':sendername,
        'username':username,
        'password': password,
        'apikey':apikey,
        'destnum':destnum,
        'message':message,
        'sendedate':senddate
    }
    
    url = 'http://www.bongolive.co.tz/api/sendSMS.php?{params}'.format(params=urllib.parse.urlencode(params))
    
    return requests.get(url, params=params) 

print (req)