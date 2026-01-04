package com.ninjasri98.restaurant.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ninjasri98.restaurant.domain.ReviewCreateUpdateRequest;
import com.ninjasri98.restaurant.domain.dtos.ReviewCreateUpdateRequestDto;
import com.ninjasri98.restaurant.domain.dtos.ReviewDto;
import com.ninjasri98.restaurant.domain.entities.Review;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {
    ReviewCreateUpdateRequest toReviewCreateUpdateRequest(ReviewCreateUpdateRequestDto dto);

    ReviewDto toDto(Review review);
}