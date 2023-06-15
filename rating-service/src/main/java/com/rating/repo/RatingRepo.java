package com.rating.repo;

import com.rating.entities.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Ratings, String> {

    List<Ratings> findAllByUserId(String userId);
}
