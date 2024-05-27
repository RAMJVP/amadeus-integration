package com.flightsearch.offer;


import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;

public class AmadeusIntegration {

    public static void main(String[] args) {
        // Initialize the Amadeus client with your API key and secret
        Amadeus amadeus = Amadeus
                .builder("TqdbwDA0rjgI5WyANW9tyYJkiL5bcpoD", "3FxMixGlDoGrHJGA")
                .build();

        try {
            // Search for flights
            FlightOfferSearch[] flights = amadeus.shopping.flightOffersSearch.get(
                    Params.with("originLocationCode", "NYC")
                          .and("destinationLocationCode", "LON")
                          .and("departureDate", "2024-10-01")
                          .and("adults", 1)
            );

            if (flights != null && flights.length > 0) {
                for (FlightOfferSearch flight : flights) {
                    System.out.println(flight);
                }
            } else {
                System.out.println("No flights found.");
            }
        } catch (ResponseException e) {
            e.printStackTrace();
        }
    }
}
