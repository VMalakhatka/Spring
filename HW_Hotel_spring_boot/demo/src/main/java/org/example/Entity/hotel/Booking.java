package org.example.Entity.hotel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

//@EqualsAndHashCode(exclude = {"ingredients"})
//@ToString(exclude = {"ingredients"})

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "data")
    private LocalDate date;
    @Column(name = "wishes")
    private String wishes;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Room room;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Client client;
}
