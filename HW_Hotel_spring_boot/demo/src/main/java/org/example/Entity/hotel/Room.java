package org.example.Entity.hotel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(exclude = {"bookings"})
@ToString(exclude = {"bookings"})
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "number")
    private int number;
    @Column(name = "comment")
    private String comment;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Booking> bookings;
    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setRoom(this);
        System.out.println(booking);
    }
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
        booking.setRoom(null);
    }

}
