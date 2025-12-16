package com.example.ratingservice.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.ratingservice.model.Rating;
import com.example.ratingservice.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    @Cacheable(value = "ratings", key = "#id")
    public Rating getRatingById(String id) {
        return ratingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public Rating createRating(Rating rating) {
        rating.setCreatedAt(LocalDateTime.now().format(dateFormatter));
        rating.setUpdatedAt(LocalDateTime.now().format(dateFormatter));
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public Rating updateRating(String id, Rating rating) {
        return ratingRepository.findById(id)
                .map(existingRating -> {
                    existingRating.setRating(rating.getRating());
                    existingRating.setFeedback(rating.getFeedback());
                    existingRating.setUpdatedAt(LocalDateTime.now().format(dateFormatter));
                    return ratingRepository.save(existingRating);
                })
                .orElse(null);
    }
}