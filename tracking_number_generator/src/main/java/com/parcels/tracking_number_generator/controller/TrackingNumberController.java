package com.parcels.tracking_number_generator.controller;

import com.parcels.tracking_number_generator.service.TrackingNumberService;
import com.parcels.tracking_number_generator.model.TrackingNumberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TrackingNumberController {

    private final TrackingNumberService trackingNumberService;

    @Autowired
    public TrackingNumberController(TrackingNumberService trackingNumberService) {
        this.trackingNumberService = trackingNumberService;
    }

    @GetMapping("/next-tracking-number")
    public TrackingNumberResponse getNextTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam Double weight,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime created_at,
            @RequestParam UUID customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug) {

        // Validate input data
        if (origin_country_id.isEmpty() || destination_country_id.isEmpty() || customer_id == null) {
            throw new IllegalArgumentException("Missing required parameters.");
        }
        // Generate the tracking number using the service
        String trackingNumber = trackingNumberService.generateTrackingNumber(
                origin_country_id, destination_country_id, weight, created_at, customer_id, customer_name, customer_slug);

        return new TrackingNumberResponse(trackingNumber, OffsetDateTime.now());
    }
}

