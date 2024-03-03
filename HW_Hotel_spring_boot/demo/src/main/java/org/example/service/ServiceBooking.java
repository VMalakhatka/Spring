package org.example.service;



import org.example.Entity.hotel.Client;
import org.example.Entity.hotel.Room;
import org.example.dao.BookingDao;
import org.example.dto.RoomRequestDto;
import org.example.dto.RoomResponseDto;
import org.example.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceBooking {
    private final BookingDao bookingDao;
    private final Mapper mapper;

    @Autowired
    public ServiceBooking(Mapper mapper, BookingDao bookingDao) {
        this.bookingDao = bookingDao;
        this.mapper = mapper;
    }
    public Room read(long id) {
        return bookingDao.read(id);
    }

    @Transactional
    public Room bookingRoom(RoomRequestDto dto){
        Room room=bookingDao.readByNumber(dto.number());
        bookingDao.detachRoom(room);
        Client client=bookingDao.readClientById(dto.client_id());
        bookingDao.detachClient(client);
        mapper.toRoom(dto,room,client);

        bookingDao.mergeRoom(room);
        // TODO blocking room - verify free this room if free - booking else written - "room is not free"
        return room;
    }

    public List<RoomResponseDto> readAll() {
        List<Room> rooms=bookingDao.readAll();
        return rooms.stream().map(mapper::roomResponseDto).toList();

    }

}
