BAGGAGE ENDPOINTS
		curl -X GET http://localhost:8080/basicRestCalls/baggage/intl/items
		curl -X GET http://localhost:8080/basicRestCalls/baggage/intl/item/3
		
		curl -X POST -HContent-type:application/json -HAccept:application/json --data '{"passengerId":"100013","weight":"37","flightNumber":"140","from":"MNL","to":"TPE","departureDateAndTime":"06/11/2017 02.10","airline":"CX"}' http://localhost:8080/basicRestCalls/baggage/intl/item

		curl -X PUT -HContent-type:application/json -HAccept:application/json --data '{"passengerId":"100099","weight":"99","flightNumber":"1499","from":"EWR","to":"DUB","departureDateAndTime":"06/11/2019 02.10","airline":"UA"}' http://localhost:8080/basicRestCalls/baggage/intl/item/2/

		curl -X DELETE http://localhost:8080/basicRestCalls/baggage/intl/item/2/
