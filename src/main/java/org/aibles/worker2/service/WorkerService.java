package org.aibles.worker2.service;

import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WorkerService {
    WorkerDto created (WorkerDto workerDto);
    void delete(Long id);
    List<Worker> list();
    List<Worker> searchWorkers(String query);
    WorkerDto update (Long id, WorkerDto workerDto);
}
