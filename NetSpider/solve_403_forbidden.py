# -*- coding:utf-8 -*-
import urllib.request
import urllib.error
import random
import re

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
    reponse = urllib.request.urlopen(req)
    content = reponse.read().decode("utf-8")
    return content
class SDU:
    def __init__(self):
        #一房一价链接1
        url1 = 'http://www.tmsf.com//newhouse/property_house_330184_30395281_10057929.htm'
        page = get_content(url1,my_headers)
        #print (page)
        strTemp = re.findall('<div.*?>.*?<h2.*?>.*?</div>',page,re.S)
        print (strTemp)
        myItems = re.findall('<tr>.*?<strong.*?>(.*?)</strong>.*?<td.*?>(.*?)</td>.*?<strong.*?>(.*?)</strong>.*?<td.*?>(.*?)</td>.*?</tr>',strTemp.[0],re.S)
        print (myItems)
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

        #for item in myItems:
        '''
        self.room.append(myItems[0][0])
        self.roomNumber.append(myItems[0][1])
        self.productor.append(myItems[0][2])
        self.productorName.append(myItems[0][3])
        self.status.append(myItems[1][0])
        self.statusName.append(myItems[1][1])
        self.building.append(myItems[1][2])
        self.buildingName.append(myItems[1][3])
        self.roomShape.append(myItems[2][0])
        self.roomShapeName.append(myItems[2][1])
        self.builingArea.append(myItems[2][2])
        self.builingAreaNumber.append(myItems[2][3])
        self.floor.append(myItems[3][0])
        self.floorNumber.append(myItems[3][1])
        self.innerArea.append(myItems[3][2])
        self.innerAreaNumber.append(myItems[3][3])
        self.location.append(myItems[4][0])
        self.locationName.append(myItems[4][1])
        self.sharedArea.append(myItems[4][2])
        self.sharedAreaNumber.append(myItems[4][3])
        self.usage.append(myItems[5][0])
        self.usageName.append(myItems[5][1])
        self.presaleNumber.append(myItems[5][2])
        self.presaleNumberName.append(myItems[5][3])
        self.constructure.append(myItems[6][0])
        self.constructureName.append(myItems[6][1])
        self.simpleperprice.append(myItems[6][2])
        self.simpleperpriceNumber.append(myItems[6][3])
        self.management.append(myItems[7][0])
        self.managementName.append(myItems[7][1])
        self.apply.append(myItems[7][2])
        self.applyTime.append(myItems[7][3])
        self.towards.append(myItems[8][0])
        self.towardsName.append(myItems[8][1])
        self.sumprice.append(myItems[8][2])
        self.sumpriceName.append(myItems[8][3])
        '''

        self.room.append(myItems[0][0])
        self.roomNumber.append(myItems[0][1])
        self.productor.append(myItems[0][2])
        self.productorName.append(myItems[0][3])
        self.status.append(myItems[1][0])
        self.statusName.append(myItems[1][1])
        self.building.append(myItems[1][2])
        self.buildingName.append(myItems[1][3])
        self.roomShape.append(myItems[2][0])
        self.roomShapeName.append(myItems[2][1])
        self.builingArea.append(myItems[2][2])
        self.builingAreaNumber.append(myItems[2][3])
        self.floor.append(myItems[3][0])
        self.floorNumber.append(myItems[3][1])
        self.innerArea.append(myItems[3][2])
        self.innerAreaNumber.append(myItems[3][3])
        self.location.append(myItems[4][0])
        self.locationName.append(myItems[4][1])
        self.sharedArea.append(myItems[4][2])
        self.sharedAreaNumber.append(myItems[4][3])
        self.usage.append(myItems[5][0])
        self.usageName.append(myItems[5][1])
        self.presaleNumber.append(myItems[5][2])
        self.presaleNumberName.append(myItems[5][3])
        self.constructure.append(myItems[6][0])
        self.constructureName.append(myItems[6][1])
        self.simpleperprice.append(myItems[6][2])
        self.simpleperpriceNumber.append(myItems[6][3])
        self.management.append(myItems[7][0])
        self.managementName.append(myItems[7][1])
        self.apply.append(myItems[7][2])
        self.applyTime.append(myItems[7][3])
        self.towards.append(myItems[8][0])
        self.towardsName.append(myItems[8][1])
        self.sumprice.append(myItems[8][2])
        self.sumpriceName.append(myItems[8][3])

        print (self.room[0])
        print (self.productor[0])
        print (self.status[0])
        print (self.building[0])
        print (self.roomShape[0])
        print (self.builingArea[0])
        print (self.floor[0])
        print (self.innerArea[0])
        print (self.location[0])
        print (self.sharedArea[0])
        print (self.usage[0])
        print (self.presaleNumber[0])
        print (self.constructure[0])
        print (self.simpleperprice[0])
        print (self.management[0])
        print (self.apply[0])
        print (self.towards[0])
        print (self.sumprice[0])

        print (self.roomNumber[0])
        print (self.productorName[0])
        print (self.statusName[0])
        print (self.buildingName[0])
        print (self.roomShapeName[0])
        print (self.builingAreaNumber[0])
        print (self.floorNumber[0])
        print (self.innerAreaNumber[0])
        print (self.locationName[0])
        print (self.sharedAreaNumber[0])
        print (self.usageName[0])
        print (self.presaleNumberName[0])
        print (self.constructureName[0])
        print (self.simpleperpriceNumber[0])
        print (self.managementName[0])
        print (self.applyTime[0])
        print (self.towardsName[0])
        print (self.sumpriceName[0])
sdu = SDU()

