import urllib.request
import urllib.error
import re
import numpy as np
url = 'http://www.tmsf.com//newhouse/property_house_330184_30395281_10057929.htm'
try:
    request = urllib.request.Request(url)
    #response = urllib.request.urlopen(request)
    #content = response.read().decode('utf-8')
    #print (content)
except urllib.error.URLError as e:
    if hasattr(e, "code"):
        print (e.code)
    if hasattr(e, "reason"):
        print (e.reason)

strings = "http://www.tmsf.com//newhouse/property_house_330184_30395281_10058136.htm\r\n\n   http://www.tmsf.com//newhouse/property_house_330184_30395281_10057993.htm"
s = re.sub(r'\s','',strings)
import numpy as np
a = np.array([0,1,3,2,6,4,5])
b = np.array([0,1,2,3,4,5,6])
print(b[np.argsort(a)])
print (strings+s)
