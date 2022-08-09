package org.aibles.worker2.mapper;


import org.aibles.worker2.dto.WorkerDto;
import org.aibles.worker2.entity.Worker;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WorkerMapper {
    private final ModelMapper modelMapper;


    public WorkerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public WorkerDto mapToDto(Worker worker) {
        return modelMapper.map(worker, WorkerDto.class);
    }

    public Worker mapToEntity(Worker worker, WorkerDto workerDto) {
        modelMapper.map(workerDto, worker);
        return worker;
    }

}
