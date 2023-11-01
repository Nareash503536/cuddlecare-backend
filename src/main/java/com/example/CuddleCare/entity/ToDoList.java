package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "to_do_list")
public class ToDoList {

//    private enum repeatTypes{
//        Daily,
//        Weekdays,
//        Weekly,
//        Monthly,
//        Yearly,
//        Custom
//    }

    public enum StatusTypes{
        NotCompleted,
        Completed
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id", nullable = false)
    private Long toDoID;

//    @Basic
//    @Column(name = "order_number")
//    private Number orderNumber;

//    @Basic
//    @Column(name = "repeat")
//    private repeatTypes repeat;

    @Basic
    @Column(name = "date")
    private Instant date;

    @Basic
    @Column(name = "time")
    private Time time;

    @Basic
    @Column(name = "task")
    private String task;

    @Basic
    @Column(name = "task_description")
    private String taskDescription;

    @Basic
    @Column(name = "status")
    private StatusTypes status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    private Baby baby;

    public Long getBabyId() {
        if (baby != null) {
            return baby.getBabyID();
        }
        return null;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caregiver_id", referencedColumnName = "caregiver_id")
    private Caregiver caregiver;

    public Long getCaregiverId() {
        if (caregiver != null) {
            return caregiver.getCaregiverID();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoList toDoList = (ToDoList) o;
        return Objects.equals(toDoID, toDoList.toDoID) && Objects.equals(date, toDoList.date) && Objects.equals(time, toDoList.time) && Objects.equals(task, toDoList.task) && status == toDoList.status && Objects.equals(taskDescription, toDoList.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toDoID, date, time, task, taskDescription, status);
    }
}
