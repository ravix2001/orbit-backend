package com.ravi.orbit.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ReviewDTO {

    private UUID id;
    private String reviewerName;
    private String reviewText;
    private int rating;
    private String createdAt;

}
