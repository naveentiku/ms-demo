# Take Home Engineering Challenge -  Food Trucks Location
### Purpose

Purpose of this project is demonstrate a Proof of concept that searches Food Trucks located in a particular latitude and longitude in San Francisco.
Information about the Food Trucks and its location is provided in a csv file.

### Design

This project design follows the Model,View and Controller pattern and has been developed as java springboot WebAPI.\
Idea has been to read the file and store it in memory using singleton pattern so that file is read once and searches are fast.Decsion to load file in memory rather than storing it in database was taken due to small size of the file. If file would have been a very large file then I would have considered a database instead of loading csv in memory.
 ### Project Structure
 #### -Controller
* package : package com.ms.demo.controller;
* Class : **LocationController.java**\
         This program serves as controller and implements 2 methods 

   *  loadTruckLocation(): This method loads csv file in memory cache with helper class as key value pair map where\
      **key**="latitude"+"longitude"\
      **value**= csv row for that latitude and longitude as an object.\
      This map is created and stored as singleton with help of helper class so to read the file only 1 time and cache it in memory.Method uses Apache libraries to read  
      csv file and store it as MAP.This method also returns a unique list of "latitude"+"longitude" for populating the location search combo in the UI aka 
      View.Comments have been made in source code to describe the action and logic.
      
   *  searchLocations(): This method takes selected "latitude"+"longitude" input value from the view and searches the cached map for a match and return the selected           records/objects  for rendering the search result on the UI.This search result will be the list of trucks in the selected  "latitude" and "longitude"
      
 #### -Model
 * package : com.ms.demo.model
 * Class : **LocationSelection.java**\
           The object of this Class is used to store search criteria to search truck location.
 * Class : **TruckLocation**\
           The object of this class has properties that are mapped to the required colums of the CSV file to store CSV per row record in 1 instance of this class.     
           object instances or Collection of object insance of this class will be returned to be rendered on ui\view as search result.
           
 #### -Helper
 * package : com.ms.demo.helper
 * Class : **LocationCache**
           This file implements getter and setter methods as per singleton pattern to read and set the csv in memory cache.
           
 #### -View
 * **Trucklocation.html** : This html loads search combo with "latitude"+"longitude" as search criteria as returned from controller method loadTruckLocation() which 
                            returns unique list of "latitude"+"longitude" extracted out from csv file.
 
 * **SearchResult.html** : This html file displays the search results returned from searchLocations() method of the controller class matching the search criteria.


#### Tools Used
*  This project has been developed using :
   * Eclipse IDE for Enterprise Java and Web Developers.
   * org.springframework.boot
   * com.opencsv
   * org.apache.commons.collections4
   * Java 11
   
#### How to run
*  TruckLocation.jar is an executable jar with embbeded tomcat server so can be tested as standalone program located in main branch.
*  Install java if already not present.
*  download and run executable jar with following command
   *  **java -jar target/TruckLocation.jar**  from the location where jar is copied.
   *  Once Application starts you will see a message similar to this on console "main] com.ms.demo.MSTruckDemoApp  : Started MSTruckDemoApp in 1.874 seconds (JVM running       for 2.339)"
*  Access the application with following URL: http://127.0.0.1:8080/TruckLocation
   *  Ensure no other process is already running on this port.
   *  Please use browser back button to go back to search page.
   *  I have not implemented storing of log in a log file due to lack of time, so error messages if any will be printed on console.

