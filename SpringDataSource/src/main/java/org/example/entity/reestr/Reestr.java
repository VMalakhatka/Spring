package org.example.entity.reestr;

import lombok.*;

import java.util.Date;



public record Reestr(long id, String klass, String first_name, String last_name,
                     String subject, int mark, Date date_of_mark ) {
}
