package com.ninjasri98.restaurant.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.ninjasri98.restaurant.domain.entities.Photo;

import java.util.Optional;

public interface PhotoService {
    Photo uploadPhoto(MultipartFile file);

    Optional<Resource> getPhotoAsResource(String id);
}
