package com.cworks.goeuro.csvcreation;

import com.cworks.goeuro.json.jsonEntities.GoEuroGeoPosition;
import com.cworks.goeuro.json.jsonEntities.GoEuroLocation;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by chandra on 03-10-2016.
 */
public class GoEuroFileServiceTestIT {

    GoEuroFileService goEuroFileService = new GoEuroFileService();

    @Test
    public void writeToCSV() throws Exception {
        File file = this.goEuroFileService.createFile("Berlin");
        Assert.assertNotNull(file);
        Assert.assertTrue(this.goEuroFileService.writeToCSV(file, this.getResponse()));
    }

    private GoEuroLocation[] getResponse() {
        GoEuroLocation goEuroLocation = new GoEuroLocation();
        goEuroLocation.set_id(12345l);
        goEuroLocation.setGeo_position(new GoEuroGeoPosition("123.566", "456.2345"));
        goEuroLocation.setName("Test");
        goEuroLocation.setType("Airport");
        GoEuroLocation[] array = {goEuroLocation};
        return array;
    }


    @Test
    public void createFile() throws Exception {

    }

}