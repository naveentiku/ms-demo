package com.ms.demo.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.ms.demo.helper.LocationCache;
import com.ms.demo.model.LocationSelection;
import com.ms.demo.model.TruckLocation;
@Controller
public class LocationController {
	

	
	MultiValuedMap<String, TruckLocation> locMap=null;
	Collection<TruckLocation> coll=null;
	/* Method to load CSV file  in memory cache and to populate "latitude"+"longitude" in
	 * search combo on Search html page.
	 */
	@RequestMapping(value="/TruckLocation",method = RequestMethod.GET)
	public String loadTruckLocation(Model model)
	{			
		List<TruckLocation> locList=null;
		try {
			
			//Read csv and load it into cache, to make sure file is only read once
		 		LocationCache cacheobj=LocationCache.getInstance();
		 		if(cacheobj.getCache()==null) {
		 			locList=cacheobj.readCSV();
		            cacheobj.setCache(locList);
		            System.out.println("cache");
		 		}
		   
            /*Create a new list "locationNoDup" without duplicate locations  
             * to populate the "latitude"+"longitude" in locate search combo on TruckLocation.html
             */
            List<TruckLocation> locationNoDup = new ArrayList<>(new HashSet<>(cacheobj.getLocationList()));
            LocationSelection selection=new LocationSelection();
            model.addAttribute("location", locationNoDup);
            model.addAttribute("LocationSelection", selection);
            
            
        } catch (Exception ex) {
          ex.printStackTrace();
          System.out.println(ex);
        }

		return "TruckLocation";
	}
	
	/* Method to search Location record based on "latitude"+"longitude"
	 * 
	 */
	@RequestMapping(value="/TruckLocation",method = RequestMethod.POST)
	public String searchLocations(@ModelAttribute("LocationSelection") LocationSelection selection, Model model)
	{
		try {
				//Retrieve location map from cache 
				LocationCache cacheobj=LocationCache.getInstance();
				locMap=cacheobj.getCache();
				//Search map based on "latitude"+"longitude" combination
				Iterator<TruckLocation> it=locMap.get(selection.getSelection()).iterator();
				
		       	 //return search result object(s)
		       	 List<TruckLocation> locList=(List<com.ms.demo.model.TruckLocation>) locMap.get(selection.getSelection());
		       	 model.addAttribute("locSrhResult", locList);
			
		} 
		catch (Exception ex) {
        	ex.printStackTrace();
          System.out.println(ex);
        }
		
		return "SearchResult";
	}

}
