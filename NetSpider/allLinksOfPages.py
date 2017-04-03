# -*- coding:utf-8 -*-
import urllib.request
import urllib.error
import random
import re

#
page = 2
url = 'http://www.tmsf.com/newhouse/property_330184_30395281_price.htm?isopen=&presellid=10057922&buildingid=&area=&allprice=&housestate=&housetype=&page=' + str(page)
#url = 'https://www.baidu.com/s?wd=python3%20%E6%B3%A8%E9%87%8A&rsv_spt=1&rsv_iqid=0xe26ee9d200000999&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&rqlang=cn&tn=baiduhome_pg&rsv_enter=1&oq=python%2526lt%253B%2520except&rsv_t=aa48LjLVrdM1P0053JYzqRSd4pewHnGhVXj%2BVd8fcvQEt0nQoKrT4GK6dvAGkFAzlW0s&inputT=1748&rsv_pq=8d5609f3000075bd&rsv_sug3=57&rsv_sug1=43&rsv_sug7=100&rsv_sug2=0&rsv_sug4=2174'
my_headers=["Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36",
"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36",
"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:30.0) Gecko/20100101 Firefox/30.0"
"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.75.14 (KHTML, like Gecko) Version/7.0.3 Safari/537.75.14",
"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Win64; x64; Trident/6.0)"
]
def get_content(url, headers):
    '''
    @获取403禁止访问的网页
    '''
    random_header = random.choice(headers)
    req = urllib.request.Request(url)
    req.add_header("User-Agent", random_header)
    req.add_header("Host","www.tmsf.com" )
    req.add_header("Referer","http://www.tmsf.com/")
    req.add_header("GET", url)
    reponse = urllib.request.urlopen(req,timeout=10)
    content = reponse.read().decode("utf-8")
    return content
class AllLinks:
    def __init__(self):
        #一房一价链接1
        pageNumber = 1
        url0 = 'http://www.tmsf.com/newhouse/property_330184_30395281_price.htm?isopen=&presellid=10057922&buildingid=&area=&allprice=&housestate=&housetype=&page='
        #for()
        pageContent = get_content(url0+str(pageNumber),my_headers)


originalUrl = "http://www.tmsf.com/"
subString = '/newhouse/property_house_'
url0 = 'http://www.tmsf.com/newhouse/property_330184_30395281_price.htm?isopen=&presellid=10057922&buildingid=&area=&allprice=&housestate=&housetype=&page='
fileObject = open("allLinksOfPages.txt",'w+',)
list2 = list()
pageNumber = 1
while True:
    try:
        pageContent = get_content(url0+str(pageNumber),my_headers)
    except urllib.error.URLError(e):
        list2.append("page:"+str(pageNumber)+"###reason:"+str(e.reason))
    except socket.timeout(e):
        list2.append("page:"+str(pageNumber)+"###reason:"+str(e.reason))
    #strTemp = re.search('onbuildshow_contant.*?<a href=\"(.*?)\"',pageContent,re.S)

    strTemp = re.findall('<a href=\".*?\".*?>',pageContent,re.S)
    for stringBuffer in strTemp:
        #fileObject.write("###############################"+stringBuffer+'\n')
        if subString in stringBuffer:
            #fileObject.write(stringBuffer+'\n')
            list2.append(stringBuffer)
    #print (list2)
    #fileObject.write("page:"+str(pageNumber)+"##length:"+str(len(list2))+'\n')
    pageNumber+=1
    #if not pageContent:
    if pageNumber > 19:
            break
s = set()
for a in list2:
    result2 = re.findall('"([^"]+?)"', a)
    s.add(result2[0])

fileObject2 = open("result2.txt",'w')
for res in s:
    fileObject2.write(originalUrl+res+'\n')