package com.delivery.repository;

import com.delivery.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("select p from Place p order by p.deliveryOrder asc")
    List<Place> findAllOrderByDeliveryOrder();
}
