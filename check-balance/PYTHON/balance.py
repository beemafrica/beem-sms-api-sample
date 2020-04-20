import requests
import urllib.request
import urllib.parse

username='enter your Username'
password='Enter your password'
request='balance'

req = sendSMS(
    username=username,
    password= password,
    request=request,
)

def sendSMS(username, password, request):
    params = {
        'username':username,
        'password': password,
        'request':request,
        
    }
    
    url = 'http://www.bongolive.co.tz/api/request.php?{params}'.format(params=urllib.parse.urlencode(params))
    
    return requests.get(url, params=params) 

print (req)