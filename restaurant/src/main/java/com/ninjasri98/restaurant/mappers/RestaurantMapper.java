package com.ninjasri98.restaurant.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import com.ninjasri98.restaurant.domain.RestaurantCreateUpdateRequest;
import com.ninjasri98.restaurant.domain.dtos.GeoPointDto;
import com.ninjasri98.restaurant.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.ninjasri98.restaurant.domain.dtos.RestaurantDto;
import com.ninjasri98.restaurant.domain.dtos.RestaurantSummaryDto;
import com.ninjasri98.restaurant.domain.entities.Restaurant;
import com.ninjasri98.restaurant.domain.entities.Review;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {
    RestaurantCreateUpdateRequest toRestaurantCreateUpdateRequest(RestaurantCreateUpdateRequestDto dto);

    @Mapping(source = "reviews", target = "totalReviews", qualifiedByName = "populateTotalReviews")
    RestaurantDto toRestaurantDto(Restaurant restaurant);

    @Mapping(target = "latitude", expression = "java(geoPoint.getLat())")
    @Mapping(target = "longitude", expression = "java(geoPoint.getLon())")
    GeoPointDto toGeoPointDto(GeoPoint geoPoint);

    @Mapping(source = "reviews", target = "totalReviews", qualifiedByName = "populateTotalReviews")
    RestaurantSummaryDto toSummaryDto(Restaurant restaurant);

    @Named("populateTotalReviews")
    default Integer populateTotalReviews(List<Review> reviews) {
        return reviews.size();
    }

}
