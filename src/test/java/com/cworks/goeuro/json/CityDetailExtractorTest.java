package com.cworks.goeuro.json;

import com.cworks.goeuro.csvcreation.GoEuroFileService;
import com.cworks.goeuro.json.jsonEntities.GoEuroGeoPosition;
import com.cworks.goeuro.json.jsonEntities.GoEuroLocation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Map;

/**
 * This is Test Class
 * Created by chandra on 02-10-2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CityDetailExtractorTest {

    @InjectMocks
    private CityDetailExtractor cityDetailExtractor;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private GoEuroFileService goEuroFileService;


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void extractCityDetails() throws Exception {
        Mockito.when(this.restTemplate.getForEntity(Mockito.anyString(), Mockito.eq(GoEuroLocation[].class), Mockito.any(Map.class))).thenReturn(this.getResponse());
        Mockito.when(this.goEuroFileService.createFile(Mockito.anyString())).thenReturn(new File("Berlin"));
        Mockito.when(this.goEuroFileService.writeToCSV(Mockito.any(File.class), Mockito.any(GoEuroLocation[].class))).thenReturn(true);
        Assert.assertTrue(this.cityDetailExtractor.extractCityDetails("Berlin"));
        Mockito.verify(this.restTemplate).getForEntity(Mockito.anyString(), Mockito.eq(GoEuroLocation[].class), Mockito.any(Map.class));
        Mockito.verify(this.goEuroFileService).createFile(Mockito.anyString());
        Mockito.verify(this.goEuroFileService).writeToCSV(Mockito.any(File.class), Mockito.any(GoEuroLocation[].class));
    }


    private ResponseEntity<GoEuroLocation[]> getResponse() {
        GoEuroLocation goEuroLocation = new GoEuroLocation();
        goEuroLocation.set_id(12345l);
        goEuroLocation.setGeo_position(new GoEuroGeoPosition("123.566", "456.2345"));
        goEuroLocation.setName("Test");
        goEuroLocation.setType("Airport");
        GoEuroLocation[] array = {goEuroLocation};
        return new ResponseEntity<GoEuroLocation[]>(array, HttpStatus.ACCEPTED);
    }

}