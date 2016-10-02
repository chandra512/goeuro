package com.cworks.goeuro.json.jsonEntities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * This is GeoPosition
 * Created by chandra on 02-10-2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoPosition {

    private String latitude;

    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
