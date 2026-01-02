package com.ninjasri98.restaurant.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ninjasri98.restaurant.domain.dtos.PhotoDto;
import com.ninjasri98.restaurant.domain.entities.Photo;
import com.ninjasri98.restaurant.mappers.PhotoMapper;
import com.ninjasri98.restaurant.services.PhotoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    private final PhotoService photoService;
    private final PhotoMapper photoMapper;

    @PostMapping
    public PhotoDto uploadPhoto(
            @RequestParam("file") MultipartFile file) {
        Photo savedPhoto = photoService.uploadPhoto(file);
        return photoMapper.toDto(savedPhoto);
    }
}
