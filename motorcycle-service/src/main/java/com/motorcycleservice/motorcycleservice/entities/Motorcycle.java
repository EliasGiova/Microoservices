package com.motorcycleservice.motorcycleservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table (name = "motos")
public class Motorcycle {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String marca;
    private String modelo;
    private int userId;
}
