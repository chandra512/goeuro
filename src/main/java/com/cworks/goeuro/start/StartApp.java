package com.cworks.goeuro.start;

/**
 * This is class responsible for starting application
 * Created by chandra on 02-10-2016.
 */

import com.cworks.goeuro.json.CityDetailExtractor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class StartApp {

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println(" We cannot process empty Array!");
            System.exit(0);
        } else {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/application-context.xml");
            CityDetailExtractor cityDetailExtractor = applicationContext.getBean(CityDetailExtractor.class);
            for (String cityName : args) {
                cityDetailExtractor.extractCityDetails(cityName);
            }
        }
    }
}
