package com.example.CastroJeepCodes.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@Table(name = "Jeep_Codes")
@NoArgsConstructor
@AllArgsConstructor
public class Jeep {
    @Id
    @Column(name = "jeep_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jeepId;

    @Column(name = "jeepCode")
    private String jeepCode;

    @Column(name="route")
    private String route;

    @Column(name = "destinationId")
    private int destinationId;
}
