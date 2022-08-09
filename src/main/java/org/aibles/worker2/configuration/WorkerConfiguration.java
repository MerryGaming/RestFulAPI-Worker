package org.aibles.worker2.configuration;

import org.aibles.worker2.repository.WorkerRepository;
import org.aibles.worker2.service.WorkerService;
import org.aibles.worker2.service.impl.WorkerServiceImpl;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = "org.aibles.worker2.repository")
@ComponentScan(basePackages = "org.aibles.worker2.repository")
public class WorkerConfiguration {


    @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    @Bean
    public WorkerService workerService (WorkerRepository repository,ModelMapper modelMapper) {
        return new WorkerServiceImpl(repository, modelMapper);
    }





}
