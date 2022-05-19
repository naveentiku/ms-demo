package com.ms.demo.model;

import java.util.Collection;
import com.opencsv.bean.CsvBindByName;


/* Truck Location object that maps to the required columns of the CSV file
 *  com.opencsv.bean.CsvToBean;
 *  com.opencsv.bean.CsvToBeanBuilder;
 *  has been used to parse and map the csv file.
 */

public class TruckLocation{
	 @CsvBindByName(column = "Longitude")
	private String longitude;
	 @CsvBindByName(column = "Latitude")
	private String latitude;
	 @CsvBindByName(column = "LocationDescription")
	private String LocationDescription;
	 @CsvBindByName(column = "Address")
	private String locationAddress;
	 @CsvBindByName(column = "FoodItems")
	private String foodItems;
	 @CsvBindByName(column = "Applicant")
	private String truckName;
	 
	 public TruckLocation() {}
	
	public TruckLocation (String longitude,String latitude,String LocationDescription,String locationAddress,String foodItems,String truckName)
	{
		this.longitude=longitude;
		this.latitude=latitude;
		this.LocationDescription=LocationDescription;
		this.locationAddress=locationAddress;
		this.foodItems=foodItems;
		this.truckName=truckName;
		
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLocationDescription() {
		return LocationDescription;
	}

	public void setLocationDescription(String LocationDescription) {
		this.LocationDescription = LocationDescription;
	}

	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public String getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TruckLocation) {
            return ((TruckLocation) obj).latitude.equals(this.latitude);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.latitude.hashCode();
    }

}
