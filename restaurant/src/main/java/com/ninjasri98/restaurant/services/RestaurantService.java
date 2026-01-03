package com.ninjasri98.restaurant.services;

import com.ninjasri98.restaurant.domain.RestaurantCreateUpdateRequest;
import com.ninjasri98.restaurant.domain.entities.Restaurant;

public interface RestaurantService {
    Restaurant createRestaurant(RestaurantCreateUpdateRequest restaurant);

    Page<Restaurant> searchRestaurants(
            String query,
            Float minRating,
            Float latitude,
            Float longitude,
            Float radius,
            Pageable pageable);

}
