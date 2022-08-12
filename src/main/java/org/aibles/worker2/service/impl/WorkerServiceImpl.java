package org.aibles.worker2.service.impl;

import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.aibles.worker2.exeption.ResourceNotFoundException;
import org.aibles.worker2.exeption.InternalServerException;
import org.aibles.worker2.mapper.WorkerMapper;
import org.aibles.worker2.repository.WorkerRepository;
import org.aibles.worker2.service.WorkerService;
import org.aibles.worker2.util.WorkerSpecificationBuilder;
import org.modelmapper.ModelMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.domain.Specification;


@Slf4j
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final ModelMapper modelMapper;



    public WorkerServiceImpl(WorkerRepository workerRepository, ModelMapper modelMapper) {
        this.workerRepository = workerRepository;
        this.modelMapper = modelMapper;
    }




    /**
     * created worker
     *
     * @param workerDto
     * @return
     */

    @Override
    @Transactional
    public WorkerDto created(WorkerDto workerDto) {
        Worker worker =  modelMapper.map(workerDto, Worker.class);
        Worker create = workerRepository.save(worker);
        Optional.ofNullable(create).orElseThrow(() -> {
            throw new InternalServerException("Failse craeted!!! Try again");
        });
        WorkerDto workerDtoCreate =  modelMapper.map(create, WorkerDto.class);
        log.info("(Create) Dto: {}", workerDtoCreate);
        return workerDtoCreate;

    }

    /**
     * delete worker
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public void delete(Long id) {
        workerRepository.deleteById(id);
        log.info("Delete");
    }


    /**
     * created worker
     * @return
     */
//    @Override
//    public List<Worker> list() {
//        return workerRepository.findAll();
//    }


    /**
     * search worker
     *
     * @return
     */
    @Override
//    public List<Worker> searchWorkers(String query) {
//        List<Worker> workers = workerRepository.searchWorker(query);
//        return workers;
//    }
    public List<Worker> list(Map<String, String> params) {

        log.info("list worker by params : {}", params);
        WorkerSpecificationBuilder builder = new WorkerSpecificationBuilder();
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));
        }
        Specification<Worker> specification = builder.build();

        return workerRepository.findAll(specification).stream()
            .map(WorkerMapper::mapToDto)
            .collect(Collectors.toList());
    }


    /**
     * update worker
     *
     * @param id
     * @param workerDto
     * @return
     */
    @Override
    @Transactional
    public WorkerDto update(Long id, WorkerDto workerDto) {
        Worker workerCheck = workerRepository.findById( id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Worker not found! ");
        });
        Worker worker = modelMapper.map(workerDto, Worker.class);
        worker.setId(workerCheck.getId());
        Worker update = workerRepository.save(worker);
        Optional.of(update).orElseThrow(() -> {
            throw new InternalServerException("Update found, update again!!");
        });
        WorkerDto workerDtoUpdated = modelMapper.map(update, WorkerDto.class);
        log.info("(Update) worker update: {}, worker: {}", workerDtoUpdated, worker);
        return workerDtoUpdated;


    }


}
