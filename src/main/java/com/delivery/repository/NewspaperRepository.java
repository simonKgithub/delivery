package com.delivery.repository;

import com.delivery.entity.Newspaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewspaperRepository extends JpaRepository<Newspaper, Long> {
}
