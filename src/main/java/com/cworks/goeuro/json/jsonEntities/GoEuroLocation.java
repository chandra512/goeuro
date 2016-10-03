package com.cworks.goeuro.json.jsonEntities;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Go Euro Location Json handler
 * <p>
 * Created by chandra on 02-10-2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoEuroLocation {

    private Long _id;

    private String name;

    private GoEuroGeoPosition geo_position;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GoEuroGeoPosition getGeo_position() {
        return geo_position;
    }

    public void setGeo_position(GoEuroGeoPosition geo_position) {
        this.geo_position = geo_position;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
