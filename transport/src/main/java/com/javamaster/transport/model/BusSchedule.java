package com.javamaster.transport.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="bus_schedules")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name= "start_time",nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;


    @Column(name="end_time",nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;
}
