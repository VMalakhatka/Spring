package org.example.mapper;

import org.example.Entity.hotel.Booking;
import org.example.Entity.hotel.Client;
import org.example.Entity.hotel.Room;
import org.example.dto.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public RoomResponseDto roomResponseDto(Room room){

        return new RoomResponseDto(room.getNumber(), room.getComment(),
               room.getBookings().stream().map(this::bookingResponseDto).collect(Collectors.toSet())  );
    }

    public BookingResponseDto bookingResponseDto(Booking booking){
        return new BookingResponseDto(booking.getDate(),booking.getWishes(),clientResponseDto(booking.getClient()));
    }

    public ClientResponseDto clientResponseDto(Client client){
        return new ClientResponseDto(client.getFirstName(), client.getLastName(), client.getBirthday());
    }

    public void toRoom(RoomRequestDto dto, Room room, Client client){
        List<Booking> bookings= new ArrayList<>();
        LocalDate start =dto.start().minusDays(1);
        while (dto.end().isAfter(start)){
            Booking booking=new Booking();
            booking.setClient(client);
            for(Booking b: room.getBookings())
                if(b.getDate().equals(start)) throw new IllegalArgumentException("bocking same date");
            booking.setDate(start);
            booking.setWishes(dto.comment());
            room.addBooking(booking);
            start=start.plusDays(1);
        }
    }
}
