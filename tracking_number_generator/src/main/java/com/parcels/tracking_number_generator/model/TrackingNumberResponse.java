package com.parcels.tracking_number_generator.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class TrackingNumberResponse {

    private String tracking_number;
    private OffsetDateTime created_at;

    // Constructor, getters and setters
    public TrackingNumberResponse(String tracking_number, OffsetDateTime created_at) {
        this.tracking_number = tracking_number;
        this.created_at = created_at;
    }

}

