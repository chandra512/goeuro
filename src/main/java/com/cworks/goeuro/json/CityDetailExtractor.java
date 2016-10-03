package com.cworks.goeuro.json;

import com.cworks.goeuro.csvcreation.GoEuroFileService;
import com.cworks.goeuro.json.jsonEntities.GoEuroLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for Extracting details
 * Created by chandra on 02-10-2016.
 */
@Service
public class CityDetailExtractor {

    private static final String CITY_NAME = "CITY_NAME";

    private static final String URL_PREFIX = "http://api.goeuro.com/api/v2/position/suggest/en/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GoEuroFileService goEuroFileService;

    public boolean extractCityDetails(final String cityName) {
        boolean returnVal = false;
        try {
            Map<String, String> map = new HashMap();
            map.put(CITY_NAME, cityName);
            ResponseEntity<GoEuroLocation[]> val = this.restTemplate.getForEntity(URL_PREFIX + cityName, GoEuroLocation[].class, map);
            File file = this.goEuroFileService.createFile(cityName);
            returnVal = this.goEuroFileService.writeToCSV(file, val.getBody());
        } catch (Exception e) {
            System.out.println(" Exception while creating file " + cityName);
        }
        return returnVal;
    }
}
