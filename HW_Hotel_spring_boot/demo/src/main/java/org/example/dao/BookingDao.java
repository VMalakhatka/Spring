package org.example.dao;

import org.example.Entity.hotel.Client;
import org.example.Entity.hotel.Room;

import java.util.List;

public interface BookingDao {
//    List<BookingDto> create(BookingRequestDto bookingRequestDto);
//    List<BookingDto> read(int roomNumber);
    List<Room> readAll();
    Room read(long id);
//    List<RoomDto> update(BookingRequestDto bookingRequestDto);
//    void delete(BookingRequestDto bookingRequestDto);
    Room readByNumber(int number);
    Room mergeRoom(Room room);
    void detachRoom(Room objects);

    Client readClientById(int i);

    void detachClient(Client client);
}
