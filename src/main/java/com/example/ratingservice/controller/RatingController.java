package com.example.ratingservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingservice.model.Rating;
import com.example.ratingservice.service.RatingService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    @GetMapping("/rating/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String id) {
        Rating rating = ratingService.getRatingById(id);
        return ResponseEntity.status(HttpStatus.OK).body(rating);
    }

    @PostMapping("/rating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating createdRating = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
    }

    @PutMapping("/rating/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable String id, @RequestBody Rating rating) {
        Rating updatedRating = ratingService.updateRating(id, rating);
        return ResponseEntity.status(HttpStatus.OK).body(updatedRating);
    }

    @DeleteMapping("/rating/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable String id) {
        ratingService.deleteRating(id);
        return ResponseEntity.status(HttpStatus.OK).body("Rating deleted successfully.");
    }
}