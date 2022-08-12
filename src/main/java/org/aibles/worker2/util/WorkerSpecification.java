package org.aibles.worker2.util;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aibles.worker2.entity.Worker;
import org.springframework.data.jpa.domain.Specification;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerSpecification implements Specification<Worker> {
  private SearchCriteria searchCriteria;

  @Override
  public Predicate toPredicate(
      Root<Worker> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    if (isNumber(searchCriteria.getValue())) {
      return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
    } else {
      return criteriaBuilder.like(
          root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
    }
  }

  private boolean isInteger(String string) {
    try {
      Integer number = Integer.parseInt(string);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  private boolean isFloat(String string) {
    try {
      Float number = Float.parseFloat(string);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  private boolean isNumber(String string) {
    return isInteger(string) || isFloat(string);
  }
}
