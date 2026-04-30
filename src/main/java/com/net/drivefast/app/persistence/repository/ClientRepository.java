package com.net.drivefast.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.net.drivefast.app.domain.Client;
import com.net.drivefast.app.persistence.projection.ClientCostProjection;

public interface ClientRepository extends JpaRepository<Client, Long>{

    @Query(name = """
            SELECT c.name, r.total_value
            FROM client c
            INNER JOIN rental r
            ON r.client_id = c.id
            GROUP BY c.name
            """
    , nativeQuery = true)
    List<ClientCostProjection> calculateCostByClient();
}
