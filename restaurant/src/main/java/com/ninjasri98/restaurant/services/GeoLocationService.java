package com.ninjasri98.restaurant.services;

import com.ninjasri98.restaurant.domain.GeoLocation;
import com.ninjasri98.restaurant.domain.entities.Address;

public interface GeoLocationService {
    GeoLocation geoLocate(Address address);
}
