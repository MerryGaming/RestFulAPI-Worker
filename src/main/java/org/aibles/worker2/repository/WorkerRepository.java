package org.aibles.worker2.repository;

import org.aibles.worker2.entity.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>, JpaSpecificationExecutor<Worker> {
    @Query("SELECT p FROM worker p WHERE " +
            "p.name LIKE CONCAT('%',:query, '%')")
    List<Worker> searchWorker(String query);
}
