package com.ninjasri98.restaurant.services;

import com.ninjasri98.restaurant.domain.ReviewCreateUpdateRequest;
import com.ninjasri98.restaurant.domain.entities.Review;
import com.ninjasri98.restaurant.domain.entities.User;

public interface ReviewService {
    Review createReview(User author, String restaurantId, ReviewCreateUpdateRequest review);
}
