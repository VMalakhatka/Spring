package com.malakhatkave.prackticepractice.Entity;

import com.malakhatkave.prackticepractice.CarOwner;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@Entity
@Table(name = "cars")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @OneToOne
    @JoinColumn(name = "stateNamber_id", referencedColumnName = "id")
    private StateNamber stateNamber;

    private CarOwner carOwnerId;
}
