# Take Home Engineering Challenge -  Food Trucks Location
### Purpose

Purpose of this project is demonstrate a Proof of concept that Search Food Trucks located in a particular latitude and longitude in San Francisco.
Information about the Food Trucks and its location is provided in a csv file.

### Design

This project follows the Model,View and Controller pattern and has been developed as java springboot WebAPI.
 
 #### -Controller
* package : package com.ms.demo.controller;
* Class : **LocationController.java**\
         This program serves as controller and implements 2 methods 

   *  loadTruckLocation(): This method loads csv file in memory cache as key value pair map where\
      **key**="latitude"+"longitude"\
      **value**= csv row for that latitude and longitude as an object.\
      This map is stored as singleton so to read the file only 1 time and cache it in memory.Method uses Apache libraries to read csv file and store it as MAP.This             method also returns a unique list of "latitude"+"longitude" for populating the location search combo in the UI aka View.Comments have been made in source code to         describe the action.
      
   *  searchLocations(): This method takes selected "latitude"+"longitude" input value from the view and searches the cached map for a match and return the selected       records/objects  for rendering the search result on the UI.This search result will be the list of trucks in the selected  "latitude" and "longitude"
      
 #### -Model
 * package : com.ms.demo.model
 * Class : **LocationSelection.java**\
           This Class object is used to store search criteria to search truck location.
 * Class : **TruckLocation**\
           This class object has properties that are mapped to the required colums of the CSV file to store CSV per row record in 1 instance of this class. objects                  instances or Collection of object insance of this class will be returned to be rendered on ui\view
           
 #### -view
 * **Trucklocation.html** : This html loads search combo with "latitude"+"longitude" as search criteria as returned from controller method loadTruckLocation() which returns    unique list of "latitude"+"longitude" extracted out from csv file.
 
 * **SearchResult.html** : This html file displays the search results returned from searchLocations() method of the controller class matching the search criteria.
