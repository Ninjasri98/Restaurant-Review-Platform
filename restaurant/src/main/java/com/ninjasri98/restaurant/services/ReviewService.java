package com.ninjasri98.restaurant.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ninjasri98.restaurant.domain.ReviewCreateUpdateRequest;
import com.ninjasri98.restaurant.domain.entities.Review;
import com.ninjasri98.restaurant.domain.entities.User;

public interface ReviewService {
    Review createReview(User author, String restaurantId, ReviewCreateUpdateRequest review);

    Page<Review> getRestaurantReviews(String restaurantId, Pageable pageable);

    Optional<Review> getRestaurantReview(String restaurantId, String reviewId);
}
