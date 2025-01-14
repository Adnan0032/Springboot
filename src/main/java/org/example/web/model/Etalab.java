package org.example.web.model;
import java.util.ArrayList;
import java.util.List;
public class Etalab {

        public String type;
        public List<org.example.web.model.features> features = new ArrayList<>();
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

