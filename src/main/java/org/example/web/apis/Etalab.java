package org.example.web.apis;

import java.util.ArrayList;
import java.util.List;

public class Etalab {
    public String type;
    public String version;
    public List<org.example.web.apis.features> features = new ArrayList<>();
    public String attribution;
    public String licence;
    public String query;
    public int limit = 1;

    //toString
    @Override
    public String toString() {
        return "EtalabAPIAddress{" +
                "feature{s=" + features +
                ", query='" + query + '\'' +
                '}';
    }
}
