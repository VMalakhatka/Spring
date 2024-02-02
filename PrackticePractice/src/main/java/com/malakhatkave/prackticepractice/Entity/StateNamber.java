package com.malakhatkave.prackticepractice.Entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StateNamber {
    private long id;
    private String country;
    private long regionCode;
    private String series;
    private long number;
}
