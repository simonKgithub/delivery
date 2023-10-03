package com.delivery.repository;

import com.delivery.entity.Place;
import com.delivery.entity.PlaceNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceNewsRepository extends JpaRepository<PlaceNews, Long> {

    @Query("select p from PlaceNews  p where p.place = :place")
    List<PlaceNews> findByPlace(@Param("place") Place place);
}
