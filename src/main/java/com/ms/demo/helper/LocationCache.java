package com.ms.demo.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import com.ms.demo.model.TruckLocation;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
/*
 * This class caches csv file as Key value Map.
 */
public final class LocationCache {
	
	private static LocationCache cacheObj;
	private static  MultiValuedMap<String, TruckLocation>  locationobj=null;
	private static  List<TruckLocation> locationList=null;
	
	private LocationCache() {}
	
	// Static method to create instance of Singleton class
    public static LocationCache getInstance()
    {
        if (cacheObj == null)
        	cacheObj = new LocationCache();
  
        return cacheObj;
    }
	  
    public  void setCache(List<TruckLocation> locList) {
    	/*
    	 *  Create a Map to store the csv file as value object against "latitude"+"longitude" as key.
    	 */
    	MultiValuedMap<String, TruckLocation> locMap=null;
    	locMap = new ArrayListValuedHashMap<>();
         for (TruckLocation locObj:locList) {
		            locMap.put(locObj.getLatitude()+locObj.getLongitude(),locObj);           	
		    }
    	
    	locationobj=locMap;
     }
    public List<TruckLocation> getLocationList(){
    	
    	return locationList;
    }
    public   MultiValuedMap<String, TruckLocation>  getCache() {
    	return locationobj;
     }
    
    public  List<TruckLocation> readCSV() {
    	
    	
    	// parse CSV file to create a list of `TruckLocation` objects
    	try {
    			InputStream inputStream = getInstance().getClass().getResourceAsStream("/TruckLocation.csv");	
    			BufferedReader  reader = new BufferedReader(new InputStreamReader(inputStream));
    	        CsvToBean<TruckLocation> csvToBean =new CsvToBeanBuilder(reader).withType(TruckLocation.class).withIgnoreLeadingWhiteSpace(true).build();
    				
    	           // convert `CsvToBean` object to list of locations
    				
    	        	locationList = csvToBean.parse();
    	            
    	            /*Used a singleton class to cache CSV file as Key value Map, key being "latitude"+"longitude"
    	              and value as the row of CSV so that file is read only once.
    	            */
    	           
    			   
    			      
		    }catch (Exception ex) {
		        ex.printStackTrace();
		        System.out.println(ex);
		      }
		    return locationList;
    }
    
    
}
