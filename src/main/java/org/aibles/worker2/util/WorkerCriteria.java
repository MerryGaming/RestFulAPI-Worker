package org.aibles.worker2.util;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import lombok.Data;
import org.aibles.worker2.entity.Worker;
import org.springframework.data.jpa.domain.Specification;

@Data
public class WorkerCriteria {

  private String name;
  private int date;
  private int years_of_work;
  private String address;
  private double wage;
  private double allowance;

  public  Specification<Worker> toSpecification() {
    return (root, query, criteriaBuilder)
        -> {
      List<Predicate> predicate = new ArrayList<>();
      if (StringUtils.isNotBlank(name)) {
        predicate.add(criteriaBuilder.like(root.get("name"), StringUtils.wrap(name, '%')));
      }
      if (date != 0) {
        predicate.add(criteriaBuilder.equal(root.get("date"), date));
      }
      if (years_of_work != 0) {
        predicate.add(criteriaBuilder.equal(root.get("years_of_work"), years_of_work));
      }
      if (StringUtils.isNotBlank(address)) {
        predicate.add(criteriaBuilder.like(root.get("color"), StringUtils.wrap(address, '%')));
      }
      if (wage != 0) {
        predicate.add(criteriaBuilder.equal(root.get("wage"), wage));
      }
      if (allowance != 0) {
        predicate.add(criteriaBuilder.equal(root.get("allowance"), allowance));
      }

      return criteriaBuilder.and(predicate.toArray(Predicate[]::new));
    };
  }
}
