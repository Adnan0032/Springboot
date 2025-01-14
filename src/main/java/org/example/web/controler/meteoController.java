package org.example.web.controler;

import org.example.web.apis.configuration;
import org.example.web.model.Etalab;
import org.example.web.apis.configuration.*;
import org.example.web.model.features;
import org.example.web.apis.Meteo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@Controller
public class meteoController {
    RestTemplate  restTemplate = new RestTemplate();
    public static String API_KEY = "5f35ceb8eef4901ce09c85905a20a173251cfcf3e29cecace9d1a3d7c8da4938";

    @GetMapping("/meteo")
    public String meteoGet(){
        return "meteo";
    }

    @PostMapping("/meteo")
    public String meteoPost(
            @RequestParam(name="address", required=true) String address,
            Model model ){
        String link = address.toLowerCase().replace(" ", "+");;

        Etalab etalabAPIAddress = restTemplate.getForObject("https://api-adresse.data.gouv.fr/search/?q=" + link + "&limit=1", Etalab.class);
        System.out.println(etalabAPIAddress);

        features feature = etalabAPIAddress.features.get(0);
        float Lat = feature.getGeometry().getCoordinates().get(1);
        float Lon = feature.getGeometry().getCoordinates().get(0);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        String meteo_url = "https://api.meteo-concept.com/api/forecast/daily/0?token=" + API_KEY + "&latlng=" + Lat + "," + Lon;
        System.out.println("meteo url: " + meteo_url);
        ResponseEntity<Meteo> response = restTemplate.exchange(meteo_url, HttpMethod.GET, requestEntity, Meteo.class);


        model.addAttribute("Longitude", Lon);
        model.addAttribute("Latittude", Lat);
        model.addAttribute("Address", address);
        model.addAttribute("City Name",response.getBody().getCity().get("name"));


        String rawDateTime = response.getBody().getForecast().get("datetime");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(rawDateTime, inputFormatter);
        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateTime = localDateTime.format(outputFormatter);

        model.addAttribute("datetime", formattedDateTime);
        model.addAttribute("fog_Probability", response.getBody().getForecast().get("probafog") + "%");
        model.addAttribute("Wind_Speed", response.getBody().getForecast().get("wind10m") + " km/h");
        model.addAttribute("rain_Probablity", response.getBody().getForecast().get("probarain") + " %");
        model.addAttribute("minimum_Temperature", response.getBody().getForecast().get("tmin") + " °C");
        model.addAttribute("maximum_Temperature", response.getBody().getForecast().get("tmax") + " °C");

        return "meteo";
    }
}