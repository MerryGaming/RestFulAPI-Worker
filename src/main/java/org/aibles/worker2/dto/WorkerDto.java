package org.aibles.worker2.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * */
@Data
@Getter
@Setter
public class WorkerDto { //implements Serializable {
    @NotBlank
    @Size(min = 2, max = 128)
    private String name;

    private int date;
    private int years_of_work;

    @NotBlank
    @Size(min = 5, max = 200)
    private String address;

    private double wage;
    private double allowance;

    public WorkerDto() {}

    public WorkerDto(String name, int date, int years_of_work,
                     String address, double wage, double allowance) {
        this.name = name;
        this.date = date;
        this.years_of_work = years_of_work;
        this.address = address;
        this.wage = wage;
        this.allowance = allowance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WorkerDto workerDto = (WorkerDto) o;
        return date == workerDto.date
                && years_of_work == workerDto.years_of_work
                && Double.compare(workerDto.wage, wage) == 0
                && Double.compare(workerDto.allowance, allowance) == 0
                && name.equals(workerDto.name)
                && address.equals(workerDto.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, years_of_work, address, wage, allowance);
    }

    @Override
    public String toString() {
        return "WorkerDto{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", years_of_work=" + years_of_work +
                ", address='" + address + '\'' +
                ", wage=" + wage +
                ", allowance=" + allowance +
                '}';
    }
}