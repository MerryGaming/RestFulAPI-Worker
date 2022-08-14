package org.aibles.worker2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data// dùng cái này thì k cần viết constructor với hashcode and equals ,toString nx
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column (name="name")
    private String name;

    @Column (name="date")
    private int date;

    @Column (name="years_of_work")
    private int years_of_work;

    @Column (name="address")
    private String address;
    @Column (name="wage")
    private double wage;

    @Column (name="allowance")
    private double allowance;



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Worker worker = (Worker) o;
        return id == worker.id
                && date == worker.date
                && years_of_work == worker.years_of_work
                && Double.compare(worker.wage, wage) == 0
                && Double.compare(worker.allowance, allowance) == 0
                && name.equals(worker.name)
                && address.equals(worker.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, years_of_work, address, wage, allowance);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", years_of_work=" + years_of_work +
                ", address='" + address + '\'' +
                ", wage=" + wage +
                ", allowance=" + allowance +
                '}';
    }
}
