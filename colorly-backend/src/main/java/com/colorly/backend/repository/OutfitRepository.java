package com.colorly.backend.repository;

import java.util.List;

import com.colorly.backend.model.Outfit;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OutfitRepository extends CrudRepository<Outfit, Integer> {
    @Query(value = "SELECT outfit.* FROM outfit LEFT OUTER JOIN outfit_likers ON (outfit.id=outfit_likers.outfit_id) GROUP BY outfit.id ORDER BY count(outfit_likers.outfit_id) DESC LIMIT 10", nativeQuery = true)
    List<Outfit> findTopTen();
}
