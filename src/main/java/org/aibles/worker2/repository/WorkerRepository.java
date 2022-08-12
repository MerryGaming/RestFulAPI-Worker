package org.aibles.worker2.repository;

import org.aibles.worker2.entity.Worker;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>, JpaSpecificationExecutor<Worker> {
//    @Query(value = "SELECT * FROM worker p WHERE p.name LIKE %:query%",nativeQuery = true)
//    List<Worker> searchWorker(@Param("query") String query);
//@Query(value = "SELECT p FROM Worker p WHERE p.name LIKE %:query%")
//List<Worker> searchWorker(@Param("query") String query);
  List<Worker> findAll(Specification<Worker> specification);
}

