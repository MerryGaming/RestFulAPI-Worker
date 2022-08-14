package org.aibles.worker2.repository;

import java.util.List;
import org.aibles.worker2.entity.Worker;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer>, JpaSpecificationExecutor<Worker> {

  List<Worker> findAll(Specification<Worker> spec);

}
