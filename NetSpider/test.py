import urllib.request
import urllib.error
url = 'http://www.tmsf.com//newhouse/property_house_330184_30395281_10057929.htm'
try:
    request = urllib.request.Request(url)
    response = urllib.request.urlopen(request)
    content = response.read().decode('utf-8')
    print (content)
except urllib.error.URLError as e:
    if hasattr(e, "code"):
        print (e.code)
    if hasattr(e, "reason"):
        print (e.reason)
