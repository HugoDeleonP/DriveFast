package com.net.drivefast.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.net.drivefast.app.domain.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long>{

    @Query("""
            SELECT r
            FROM Rental r
            JOIN r.client c
            WHERE c.id = :clientId
            """)
    List<Rental> searchAllByClientId(@Param("clientId") Long clientId);
}
