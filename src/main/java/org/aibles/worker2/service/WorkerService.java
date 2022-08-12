package org.aibles.worker2.service;

import java.util.Map;
import org.aibles.worker2.dto.WorkerDto;

import java.util.List;
import org.aibles.worker2.entity.Worker;

public interface WorkerService {
    WorkerDto created (WorkerDto workerDto);
    void delete(Long id);
    List<Worker> list(Map<String, String> params);
    //List<Worker> searchWorkers(String query);
    WorkerDto update (Long id, WorkerDto workerDto);


}
