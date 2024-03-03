package org.example.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.user.User;


@Entity
@Table(name = "passports")
@Data
@NoArgsConstructor
public class Passport {
    @Id
    @Column(name="user_id")
    private Long userId;
    @Column(name="serial")
    private String serial;
    @Column(name="number")
    private Long number;
    @OneToOne (fetch = FetchType.LAZY)
    @MapsId
    private User user;

}
