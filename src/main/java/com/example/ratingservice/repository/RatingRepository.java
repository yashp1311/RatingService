package com.example.ratingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ratingservice.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
}