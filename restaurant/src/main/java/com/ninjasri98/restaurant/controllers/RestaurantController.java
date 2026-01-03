package com.ninjasri98.restaurant.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninjasri98.restaurant.domain.RestaurantCreateUpdateRequest;
import com.ninjasri98.restaurant.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.ninjasri98.restaurant.domain.dtos.RestaurantDto;
import com.ninjasri98.restaurant.domain.dtos.RestaurantSummaryDto;
import com.ninjasri98.restaurant.domain.entities.Restaurant;
import com.ninjasri98.restaurant.mappers.RestaurantMapper;
import com.ninjasri98.restaurant.services.RestaurantService;

@RestController
@RequestMapping(path = "/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantMapper restaurantMapper;

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(
            @Valid @RequestBody RestaurantCreateUpdateRequestDto request) {
        RestaurantCreateUpdateRequest restaurantCreateUpdateRequest = restaurantMapper
                .toRestaurantCreateUpdateRequest(request);
        Restaurant restaurant = restaurantService.createRestaurant(restaurantCreateUpdateRequest);
        RestaurantDto createdRestaurantDto = restaurantMapper.toRestaurantDto(restaurant);
        return ResponseEntity.ok(createdRestaurantDto);
    }

    @GetMapping
    public Page<RestaurantSummaryDto> searchRestaurants(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) Float minRating,
            @RequestParam(required = false) Float latitude,
            @RequestParam(required = false) Float longitude,
            @RequestParam(required = false) Float radius,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size) {
        Page<Restaurant> searchResult = restaurantService.searchRestaurants(
                q,
                minRating,
                latitude,
                longitude,
                radius,
                PageRequest.of(page - 1, size));
        return searchResult.map(restaurantMapper::toSummaryDto);
    }

}
