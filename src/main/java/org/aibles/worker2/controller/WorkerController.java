package org.aibles.worker2.controller;

import com.sipios.springsearch.anotation.SearchSpec;
import lombok.extern.slf4j.Slf4j;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.aibles.worker2.repository.WorkerRepository;
import org.aibles.worker2.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@RestController
@RequestMapping("/api/v1/workers")
@Slf4j
public class WorkerController {
    private  final WorkerService workerService;
    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerController(WorkerService workerService, WorkerRepository workerRepository) {
        this.workerService = workerService;
        this.workerRepository = workerRepository;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteWorker(@PathVariable("id") long workerId) {

        workerService.delete(workerId);
        return ResponseEntity.ok("Successful delete");
    }


    @PostMapping
    public ResponseEntity createdWorker(@RequestBody @Validated() WorkerDto workerDto ){
        final WorkerDto createdWorker = workerService.created(workerDto);
        return new ResponseEntity<>(createdWorker, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Worker>> workerList() {
        final List<Worker> getWorker = workerService.list();
        return new ResponseEntity<>(getWorker, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Worker>> searchForWorker(@RequestParam("query") String query) {
        return ResponseEntity.ok(workerService.searchWorkers(query));
    }

    @PutMapping("{id}")
    public ResponseEntity<WorkerDto> updateWorker(@PathVariable("id") Long workerId,
                                                  @RequestBody @Valid WorkerDto workerDto) {

        final WorkerDto updateWorker = workerService.update(workerId, workerDto);
        return new ResponseEntity<>(updateWorker, HttpStatus.OK);


    }




}
