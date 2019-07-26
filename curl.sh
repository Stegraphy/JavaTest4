#!/usr/bin/env bash
JAVA_IP=192.168.174.129

echo "=========>login"
curl -H "Content-Type:application/json" -X POST --data '{"name": "MARY","password":"SMITH"}' http://$JAVA_IP:18080/login -s

echo "=========> use original method to  paging"
curl -H "Content-Type:application/json" -X GET --data '{"page": 3,"pageSize":4}' http://$JAVA_IP:18080/film/list1

echo "=========> use pagehelper select"
curl -H "Content-Type:application/json" -X GET --data '{"page": 3,"pageSize":4}' http://$JAVA_IP:18080/film/list

echo "===============> insert customer"
#first_name, last_name, email, address
curl -H "Content-Type:application/json" -X PUT --data '{"first_name": "leo","last_name":"li","email":"test@qq.com","address":"47 MySakila Drive"}' http://$JAVA_IP:18080/customer

echo "================>update customer"
curl -H "Content-Type:application/json" -X POST --data '{"first_name": "leoupdate","last_name":"li","email":"test@qq.com","address":"47 MySakila Drive"}' http://$JAVA_IP:18080/customer/600

echo "============> delete customer"
curl -X DELETE --cookie "id=600" http://$JAVA_IP:18080/customer/600