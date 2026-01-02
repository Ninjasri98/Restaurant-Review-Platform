package com.ninjasri98.restaurant.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ninjasri98.restaurant.domain.dtos.PhotoDto;
import com.ninjasri98.restaurant.domain.entities.Photo;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {
    PhotoDto toDto(Photo photo);
}
