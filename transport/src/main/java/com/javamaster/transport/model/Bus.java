package com.javamaster.transport.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name="buses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bus {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "bus_id")
    private Long id;

   @NotBlank(message = "Bus no is mandatory")
   @Column(name ="bus_no",unique = true, nullable = false)
   private String busNumber;

   @NotBlank(message = "Bus registration no is mandatory")
    @Column(name = "reg_no",unique = true, nullable = false)
    private String regNumber;

    @Column(nullable = false)
    private EBusType type;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BusSchedule> busSchedules;
}
