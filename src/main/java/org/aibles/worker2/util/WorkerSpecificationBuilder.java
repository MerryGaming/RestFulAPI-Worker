package org.aibles.worker2.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.aibles.worker2.entity.Worker;
import org.springframework.data.jpa.domain.Specification;

public class WorkerSpecificationBuilder {
  private final List<SearchCriteria> params;

  public WorkerSpecificationBuilder() {
    this.params = new ArrayList<>();
  }

  public void add(String key, String value) {
    this.params.add(new SearchCriteria(key, value));
  }

  public Specification<Worker> build() {
    if (params.size() == 0) {
      return null;
    }
    List<Specification<Worker>> specs =
        params.stream().map(WorkerSpecification::new).collect(Collectors.toList());
    Specification<Worker> result = specs.get(0);

    for (int i = 1; i < params.size(); i++) {
      result = Specification.where(result).and(specs.get(i));
    }

    return result;
  }
}
