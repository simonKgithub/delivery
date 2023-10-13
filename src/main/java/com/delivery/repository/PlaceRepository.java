package com.delivery.repository;

import com.delivery.entity.Area;
import com.delivery.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("select p from Place p where p.area = :area and p.deliveryStatus = 'Y' order by p.deliveryOrder asc")
    List<Place> findAllOrderByDeliveryOrder(@Param("area") Area area);
}
