package org.example.dto;

import java.util.Date;

public record ReestrDto(long id, String klass, String first_name, String last_name,
                        String subject, int mark, Date date_of_mark){
}
