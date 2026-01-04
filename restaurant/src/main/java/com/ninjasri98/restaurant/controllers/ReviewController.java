package com.ninjasri98.restaurant.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import com.ninjasri98.restaurant.domain.ReviewCreateUpdateRequest;
import com.ninjasri98.restaurant.domain.dtos.ReviewCreateUpdateRequestDto;
import com.ninjasri98.restaurant.domain.dtos.ReviewDto;
import com.ninjasri98.restaurant.domain.entities.Review;
import com.ninjasri98.restaurant.domain.entities.User;
import com.ninjasri98.restaurant.mappers.ReviewMapper;
import com.ninjasri98.restaurant.services.ReviewService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/restaurants/{restaurantId}/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(
            @PathVariable String restaurantId,
            @Valid @RequestBody ReviewCreateUpdateRequestDto review,
            @AuthenticationPrincipal Jwt jwt) {
        // Convert the review DTO to a domain object
        ReviewCreateUpdateRequest ReviewCreateUpdateRequest = reviewMapper.toReviewCreateUpdateRequest(review);
        // Extract user details from JWT
        User user = jwtToUser(jwt);
        // Create the review
        Review createdReview = reviewService.createReview(
                user, restaurantId, ReviewCreateUpdateRequest);
        // Return the created review as DTO
        return ResponseEntity.ok(reviewMapper.toDto(createdReview));
    }

    private User jwtToUser(Jwt jwt) {
        return new User(
                jwt.getSubject(), // User's unique ID
                jwt.getClaimAsString("preferred_username"), // Username
                jwt.getClaimAsString("given_name"), // First name
                jwt.getClaimAsString("family_name") // Last name
        );
    }

}
