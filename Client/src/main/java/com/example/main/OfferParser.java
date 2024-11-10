package com.example.main;

import com.example.model.Offer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfferParser {
    public static List<Offer> parseOffers(String offersString) {
        List<Offer> offers = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Remove the brackets at the start and end of the string
        offersString = offersString.substring(1, offersString.length() - 1);

        // Split the string into individual offer descriptions
        String[] offerParts = offersString.split("}, Offer\\{");

        for (String part : offerParts) {
            part = part.replace("Offer{", "").replace("}", "");
            String[] fields = part.split(", ");

            int id = Integer.parseInt(fields[0].split("=")[1]);
            double newPrice = Double.parseDouble(fields[1].split("=")[1]);

            // Parse the dates
            Date availabilityStart = null;
            Date availabilityEnd = null;
            try {
                availabilityStart = dateFormat.parse(fields[2].split("=")[1]);
                availabilityEnd = dateFormat.parse(fields[3].split("=")[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            int numberOfBeds = Integer.parseInt(fields[4].split("=")[1]);
            String pic = fields[5].split("=")[1];

            Offer offer = new Offer(id, newPrice, availabilityStart, availabilityEnd, numberOfBeds, pic);
            offers.add(offer);
        }

        return offers;
    }
}
