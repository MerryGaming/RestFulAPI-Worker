package org.aibles.worker2.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.aibles.worker2.exeption.ResourceNotFoundException;
import org.aibles.worker2.exeption.ServerInternalException;
import org.aibles.worker2.repository.WorkerRepository;
import org.aibles.worker2.service.WorkerService;
import org.apache.catalina.Session;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


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
            throw new ServerInternalException("Failse craeted!!! Try again");
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
        boolean checkIdWorker = workerRepository.existsById(id);
        if(!checkIdWorker) {
            throw new ResourceNotFoundException("Worker not found!!!");
        }
        workerRepository.deleteById(id);
        boolean checkIdWorkerDelete = workerRepository.existsById(id);
        if(checkIdWorkerDelete) {
            throw new ServerInternalException("Delete found!");
        }
        log.info("Delete");

    }


    /**
     * created worker
     * @return
     */
    @Override
    public List<Worker> list() {
        return workerRepository.findAll();
    }

    /**
     * search worker
     *
     * @param query
     * @return
     */
    @Override
    public List<Worker> searchWorkers(String query) {
        List<Worker> workers = workerRepository.searchWorker(query);
        return workers;
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
            throw new ServerInternalException("Update found, update again!!");
        });
        WorkerDto workerDtoUpdated = modelMapper.map(update, WorkerDto.class);
        log.info("(Update) worker update: {}, worker: {}", workerDtoUpdated, worker);
        return workerDtoUpdated;


    }

//    public List<Worker> search(String keyword) {
//        Session session = sessionFactory.getCurrentSession();
//
//        FullTextSession fullTextSession = Search.getFullTextSession(session);
//
//        QueryBuilder qb = fullTextSession.getSearchFactory()
//                .buildQueryBuilder().forEntity(Worker.class).get();
//        org.apache.lucene.search.Query query = qb
//                .keyword().onFields("title", "description", "author") // Chỉ định tìm theo cột nào
//                .matching(keyword)
//                .createQuery();
//
//        org.hibernate.Query hibQuery =
//                fullTextSession.createFullTextQuery(query, Worker.class);
//
//        List<Worker> results = hibQuery.list();
//        return results;
//    }


}
