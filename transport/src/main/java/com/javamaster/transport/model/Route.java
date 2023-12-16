package com.javamaster.transport.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="routes")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Route name is mandatory")
    @Column(name ="route_name",unique = true, nullable = false)
    private String routeName;

    @NotBlank(message = "Route name is mandatory")
    @Column(name ="pickup_point", nullable = false)
    private String pickupPoint;

    @NotBlank(message = "Route name is mandatory")
    @Column(name ="drop_point", nullable = false)
    private String dropPoint;
}
