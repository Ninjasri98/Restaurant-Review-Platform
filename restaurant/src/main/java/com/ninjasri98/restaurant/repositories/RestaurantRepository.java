package com.ninjasri98.restaurant.repositories;

import com.ninjasri98.restaurant.domain.entities.Restaurant;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RestaurantRepository extends ElasticsearchRepository<Restaurant, String> {

}
