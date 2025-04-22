package com.task19.task.model;

import com.task19.user.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull private String taskText;
    @NonNull private LocalDateTime createDate;
    @NonNull private LocalDateTime endDate;
    @NonNull private String status;

    public Task(@NonNull String taskText, @NonNull LocalDateTime createDate, @NonNull LocalDateTime endDate, @NonNull String status) {
        this.taskText = taskText;
        this.createDate = createDate;
        this.endDate = endDate;
        this.status = status;
    }

    @ManyToOne
    private User user;
}
