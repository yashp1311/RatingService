package com.example.ratingservice.service;

import java.util.List;

import com.example.ratingservice.model.Rating;

public interface RatingService {

    public List<Rating> getAllRatings();

    public Rating getRatingById(String id);

    List<Rating> getRatingsByHotelId(String hotelId);

    List<Rating> getRatingsByUserId(String userId);

    public Rating createRating(Rating rating);

    public void deleteRating(String id);

    public Rating updateRating(String id, Rating rating);
}