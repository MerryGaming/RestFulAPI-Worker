package org.aibles.worker2.service;

import java.util.List;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.aibles.worker2.util.WorkerCriteria;

public interface WorkerService {
    WorkerDto created (WorkerDto workerDto);
    void delete(int id);
    //Page<Worker> list();

    List<Worker> list(WorkerCriteria workerCriteria);

    //List<Worker> searchWorkers(String query);
    WorkerDto update (int id, WorkerDto workerDto);
}
