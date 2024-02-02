package com.malakhatkave.prackticepractice.Entity;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PenaltzEvent {
    private long id;
    private LocalDate eventDate;
    private Fine fine;
    private Car car;
}
