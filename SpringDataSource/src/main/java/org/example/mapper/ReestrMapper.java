package org.example.mapper;

import org.example.dto.ReestrDto;
import org.example.entity.reestr.Reestr;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ReestrMapper {
    public ReestrDto toReestrDto(Reestr reestr) {
        return new ReestrDto(reestr.id(), reestr.klass(), reestr.first_name(),reestr.last_name(),
                reestr.subject(),reestr.mark(),reestr.date_of_mark());
    }
    public Reestr toReestr(ReestrDto reestrDto){
        return new Reestr(reestrDto.id(),reestrDto.klass(), reestrDto.first_name(),reestrDto.last_name(),
                reestrDto.subject(),reestrDto.mark(),reestrDto.date_of_mark());
    }
}
