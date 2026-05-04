package com.net.drivefast.app.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.net.drivefast.app.domain.Client;
import com.net.drivefast.app.persistence.projection.ClientCostProjection;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

    @Query(value = """
            SELECT c.name as name_client, SUM(r.total_value) as cost_total
            FROM client c
            INNER JOIN rental r
            ON c.id = r.client_id
            GROUP BY c.name
            """
    , nativeQuery = true)
    List<ClientCostProjection> calculateCostByClient();
}
