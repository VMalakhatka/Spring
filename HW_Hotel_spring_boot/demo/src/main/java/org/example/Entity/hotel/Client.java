package org.example.Entity.hotel;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(exclude = {"bookings"})
@ToString(exclude = {"bookings"})
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String  firstName;
    @Column(name = "last_name")
    private String  lastName;
    @Column(name = "birthday")
    private LocalDate birthday;
    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private Set<Booking> bookings=new HashSet<>();
    public void addBooking(Booking booking){
        bookings.add(booking);
        booking.setClient(this);
    }
    public void removeBooking(Booking booking){
        bookings.remove(booking);
        booking.setClient(null);
    }
}
