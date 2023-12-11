package com.kovunov.cpan252.tekkenuserdashboard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Getter
    private String name;
    private String description;
    private int quantity;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "distribution_centre_id", nullable = false)
    private DistributionCentre distributionCentre;
}
