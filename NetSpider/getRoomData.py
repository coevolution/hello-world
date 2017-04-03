# -*- coding:utf-8 -*-
import urllib.request
import urllib.error
import random
import re

numberDict = {'numberzero':'0','numberone':'1','numbertwo':'2','numberthree':'3','numberfour':'4','numberfive':'5','numbersix':'6','numberseven':'7','numbereight':'8','numbernine':'9','numberdor':'.'}
page = 2
url = 'http://www.tmsf.com/newhouse/property_330184_30395281_price.htm?isopen=&presellid=10057922&buildingid=&area=&allprice=&housestate=&housetype=&page=' + str(page)
#url = 'https://www.baidu.com/s?wd=python3%20%E6%B3%A8%E9%87%8A&rsv_spt=1&rsv_iqid=0xe26ee9d200000999&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&rqlang=cn&tn=baiduhome_pg&rsv_enter=1&oq=python%2526lt%253B%2520except&rsv_t=aa48LjLVrdM1P0053JYzqRSd4pewHnGhVXj%2BVd8fcvQEt0nQoKrT4GK6dvAGkFAzlW0s&inputT=1748&rsv_pq=8d5609f3000075bd&rsv_sug3=57&rsv_sug1=43&rsv_sug7=100&rsv_sug2=0&rsv_sug4=2174'
my_headers=["Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36",
"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36",
"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:30.0) Gecko/20100101 Firefox/30.0"
"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.75.14 (KHTML, like Gecko) Version/7.0.3 Safari/537.75.14",
"Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Win64; x64; Trident/6.0)",
"Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36"
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
    reponse = urllib.request.urlopen(req)
    content = reponse.read().decode("utf-8")
    return content

class SDU:
    def __init__(self,urls,i):
        #房号list
        self.room = []
        self.roomNumber = []
        #开发商list
        self.productor = []
        self.productorName = []
        #当前状态list
        self.status = []
        self.statusName = []
        #楼盘名称list
        self.building = []
        self.buildingName = []
        #户型list
        self.roomShape = []
        self.roomShapeName = []
        #建筑面积list
        self.builingArea = []
        self.builingAreaNumber = []
        #所在层数list
        self.floor = []
        self.floorNumber = []
        #套内面积list
        self.innerArea = []
        self.innerAreaNumber = []
        #房屋坐落list
        self.location = []
        self.locationName = []
        #分摊面积list
        self.sharedArea = []
        self.sharedAreaNumber = []
        #房屋用途list
        self.usage = []
        self.usageName = []
        #预售证号list
        self.presaleNumber = []
        self.presaleNumberName = []
        #房屋结构list
        self.constructure = []
        self.constructureName = []
        #毛坯单价list
        self.simpleperprice = []
        self.simpleperpriceNumber = []
        #物 业 费list
        self.management = []
        self.managementName = []
        #申报时间list
        self.apply = []
        self.applyTime = []
        #朝 向list
        self.towards = []
        self.towardsName = []
        #总 价list
        self.sumprice = []
        self.sumpriceName = []

        pattern = re.compile('"([^"]+?)"')
        #dicts = dict()[]
        #一房一价链接1
        for url in urls:
            originalUrl = url
            page = get_content(originalUrl,my_headers)
            strTemp = re.search("<h2.*?>.*?</h2>.*?<table.*?>(.*?)</table>",page,re.S)
            #print (strTemp.group(0))

            myItems = re.findall('<tr>.*?<strong.*?>(.*?)</strong>.*?<td.*?>(.*?)</td>.*?<strong.*?>(.*?)</strong>.*?<td.*?>(.*?)</td>.*?</tr>',strTemp.group(0),re.S)
            #print (myItems)

            self.room.append(myItems[0][0])
            self.roomNumber.append(re.sub(r'\s','',myItems[0][1]))
            self.productor.append(myItems[0][2])
            self.productorName.append(re.sub(r'\s','',myItems[0][3]))
            self.status.append(myItems[1][0])
            self.statusName.append(re.sub(r'\s','',myItems[1][1]))
            self.building.append(myItems[1][2])
            self.buildingName.append(re.sub(r'\s','',myItems[1][3]))
            self.roomShape.append(myItems[2][0])
            self.roomShapeName.append(re.sub(r'\s','',myItems[2][1]))
            self.builingArea.append(myItems[2][2])
            #建筑面积转换
            numbers = pattern.findall(myItems[2][3])
            buffers = ""
            for number in numbers:
                buffers+=numberDict.get(number)
            self.builingAreaNumber.append(buffers)
            self.floor.append(myItems[3][0])
            self.floorNumber.append(re.sub(r'\s','',myItems[3][1]))
            self.innerArea.append(myItems[3][2])
            #套内面积转换
            numbers = pattern.findall(myItems[3][3])
            buffers = ""
            for number in numbers:
                buffers+=numberDict.get(number)
            self.innerAreaNumber.append(buffers)
            self.location.append(myItems[4][0])
            self.locationName.append(re.sub(r'\s','',myItems[4][1]))
            self.sharedArea.append(myItems[4][2])
            #分摊面积转换
            numbers = pattern.findall(myItems[4][3])
            buffers = ""
            for number in numbers:
                buffers+=numberDict.get(number)
            self.sharedAreaNumber.append(buffers)
            self.usage.append(myItems[5][0])
            self.usageName.append(re.sub(r'\s','',myItems[5][1]))
            self.presaleNumber.append(myItems[5][2])
            self.presaleNumberName.append(re.sub(r'\s','',myItems[5][3]))
            self.constructure.append(myItems[6][0])
            self.constructureName.append(re.sub(r'\s','',myItems[6][1]))
            self.simpleperprice.append(myItems[6][2])
            #毛坯单价转换
            numbers = pattern.findall(myItems[6][3])
            buffers = ""
            for number in numbers:
                buffers+=numberDict.get(number)
            self.simpleperpriceNumber.append(buffers)
            self.management.append(myItems[7][0])
            self.managementName.append(re.sub(r'\s','',myItems[7][1]))
            self.apply.append(myItems[7][2])
            self.applyTime.append(re.sub(r'\s','',myItems[7][3]))
            self.towards.append(myItems[8][0])
            self.towardsName.append(re.sub(r'\s','',myItems[8][1]))
            self.sumprice.append(myItems[8][2])
            #总 价
            numbers = pattern.findall(myItems[8][3])
            buffers = ""
            for number in numbers:
                buffers+=numberDict.get(number)
            self.sumpriceName.append(buffers)
         for
            #打印
            print (self.room[i]+": "+self.roomNumber[i])
            print (self.productor[i]+": "+self.productorName[i])
            print (self.status[i]+": "+self.statusName[i])
            print (self.building[i]+": "+self.buildingName[i])
            print (self.roomShape[i]+": "+self.roomShapeName[i])
            print (self.builingArea[i]+": "+self.builingAreaNumber[i])
            print (self.floor[i]+": "+self.floorNumber[i])
            print (self.innerArea[i]+": "+self.innerAreaNumber[i])
            print (self.location[i]+": "+self.locationName[i])
            print (self.sharedArea[i]+": "+self.sharedAreaNumber[i])
            print (self.usage[i]+": "+self.usageName[i])
            print (self.presaleNumber[i]+": "+self.presaleNumberName[i])
            print (self.constructure[i]+": "+self.constructureName[i])
            print (self.simpleperprice[i]+": "+self.simpleperpriceNumber[i])
            print (self.management[i]+": "+self.managementName[i])
            print (self.apply[i]+": "+self.applyTime[i])
            print (self.towards[i]+": "+self.towardsName[i])
            print (self.sumprice[i]+": "+self.sumpriceName[i])
            i+=1
        index1 = self.simpleperpriceNumber.index(max(self.simpleperpriceNumber))
        index2 = self.simpleperpriceNumber.index(min(self.simpleperpriceNumber))
        print ("最高"+self.simpleperprice[index1]+": "+self.simpleperpriceNumber[index1]+" "+self.roomNumber[index1])
        print ("最低"+self.simpleperprice[index2]+": "+self.simpleperpriceNumber[index2]+" "+self.roomNumber[index2])
f = open('result2.txt','r')
#for line in f.readlines():
try:
    sdu = SDU(f.readlines(),0)
except urllib.error.URLError as e:
    print("###URLError.reason:"+e.reason)
except urllib.error.HTTPError as e:
    print("###HTTPError.reason:"+e.reason)

