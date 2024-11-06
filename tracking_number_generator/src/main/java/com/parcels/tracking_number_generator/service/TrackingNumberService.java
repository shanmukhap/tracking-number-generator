package com.parcels.tracking_number_generator.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class TrackingNumberService {

    public String generateTrackingNumber(String originCountryId, String destinationCountryId, Double weight,
                                         java.time.OffsetDateTime createdAt, UUID customerId, String customerName,
                                         String customerSlug) {
        try {
            // Step 1: Generate base string based on input parameters
            String baseString = originCountryId + destinationCountryId + weight + createdAt.toString() + customerId.toString() + customerName + customerSlug;

            // Step 2: Hash the base string to generate a unique identifier
            String hash = generateHash(baseString);
            return hash.substring(0, 16).toUpperCase();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating tracking number", e);
        }
    }

    private String generateHash(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}

