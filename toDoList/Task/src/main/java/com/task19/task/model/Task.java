package com.task19.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue
    private int id;

    @NonNull private String taskText;
    @NonNull private String createDate;
    @NonNull private String endDate;
    @NonNull private String status;

    public Task(@NonNull String status, @NonNull String endDate, @NonNull String createDate, @NonNull String taskText) {
        this.status = status;
        this.endDate = endDate;
        this.createDate = createDate;
        this.taskText = taskText;
    }
}
