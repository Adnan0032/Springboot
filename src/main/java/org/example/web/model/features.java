package org.example.web.model;


public class features {
    private String type;
    private org.example.web.model.geometry geometry;
    private Properties properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public org.example.web.model.geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(org.example.web.model.geometry geometry) {
        this.geometry = geometry;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}