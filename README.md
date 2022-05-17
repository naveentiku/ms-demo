# Take Home Engineering Challenge -  Food Trucks Location
### Purpose

Purpose of this project is demonstrate a Proof of concept that Search Food Trucks located in a particular latitude and longitude in San Francisco.
Information about the Food Trucks and its location is provided in a csv file.

### Design

This project follows the Model,View and Controller pattern and has been developed as java springboot WebAPI.
 
 #### -Controller
   
* **LocationController.java** : This program serves as controller and implements 2 methods 

      loadTruckLocation(): This method loads csv file as in memory cache as key value pair in a map where **key**="latitude"+"longitude" and **value**= csv row for that       latitude and longitude  as an object. This map is stored as singleton.This method uses apache libraries to read the csv file and store it as                              MAP.
