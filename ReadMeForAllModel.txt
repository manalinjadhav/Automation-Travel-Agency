--------Reference Project Data !!!----

-Tomcat Server working on port-9999


******URL for Booking Controller******

 http://localhost:9999/book/view-booking-status
 http://localhost:9999/book/view-book-by-id/{bookingID}
 http://localhost:9999/book/book-vehicle
 http://localhost:9999/book/cancel-booking/{bookingId}
 
 *******Url for DriverController*******
 
 http://localhost:9999/dri/view-all-driv
 http://localhost:9999/dri/view-driv-by-id/{driverID}
 http://localhost:9999/dri/add-driv
 http://localhost:9999/dri/delete-driv
 http://localhost:9999/dri/modify-driv
 
 ******URL for RouteController******
 
 http://localhost:9999/Rou/view-all-Rou
 http://localhost:9999/Rou/get-Rou-by-id/{routeID}
 http://localhost:9999/Rou/add-Rou
 http://localhost:9999/Rou/delete-Rou
 http://localhost:9999/Rou/modify-rou
 
 *****URL for VehicleController********
 
 http://localhost:9999/vehi/view-all-vehi
 http://localhost:9999/vehi/view-vehi-by-id/{vehicleID}
 http://localhost:9999/vehi/add-vehi
 http://localhost:9999/vehi/modify-vehi
 http://localhost:9999/vehi/delete-vehi
 
 
 ******* Json format for vehicle add******

{
    "vehNo": "MH 20 DF 3322",
  "vehName": "veer travel",
  "vehType": "seater",
  "vehSeatCapacity":4,
  "farePerKM": 0,
  "route": {
    "routeId": 1

  
  },
  "driver": {
    "driverId": 1
   
  }
}

<modify vehicle Json format>

{
    "vehId": 1,
    "vehNo": "MH 20 DF 4531",
    "vehName": "veer travel",
    "vehType": "seater",
    "vehSeatCapacity": 4,
    "farePerKM": 0,
    "route": {
      "routeId": 1,
      "source": "travel",
      "distination": "pune",
      "duration": "4hr",
      "distance": "200km"
    },
    "driver": {
      "driverId": 1,
      "driverName": "jay",
      "driverAddress": "sr.no12 ,goa",
      "driverContactNo": 2323124322,
      "driLinceNo": "12345jdjj5436"
    }
  }
  

/************add driver Json format******************/


{  
  "driverName": "string",
  "driverAddress": "string",
  "driverContactNo": 0,
  "driLinceNo": "string"
}

<modify driver Json format>


  {
    "driverId": 2,
    "driverName": "monu",
    "driverAddress": "sr.no12 ,pune",
    "driverContactNo": 9975732576,
    "driLinceNo": "4352314sdfg31452"
  }


/*******************add Route Json*******************/

{ 
  "source": "string",
  "distination": "string",
  "duration": "string",
  "distance": "string"
}

<modify route Json format>

  {
    "routeId": 5,
    "source": "car",
    "distination": "mumbai",
    "duration": "4hr",
    "distance": "300km"
  }


/*******************book vehicle Json****************/


{
  "bookDate": "2022-07-24",
  "journeyDate": "2022-07-24",
  "boardingPoint": "string",
  "dropPoint": "string",
  "source": "string",
  "noOfPassenger": 0
}


***************book vehicle JSON format*************
{
  
  "bookDate": "2022-07-24",
  "journeyDate": "2022-07-26",
  "boardingPoint": "sonalhall",
  "dropPoint": "manapa",
  "source": "car",
  "noOfPassenger": 4,

  "vehicle": {
    "vehId": 1
   
  }
}

******Swagger Link********

     http://localhost:9999/swagger-ui/index.html#/

***** DB Query for table******

   select * from driver_table;
   select * from booking_table;
   select * from route_table;
   select * from user_table;
   select * from vehicle_table;
   