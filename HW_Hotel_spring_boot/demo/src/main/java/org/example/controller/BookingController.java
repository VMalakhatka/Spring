package org.example.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.Entity.hotel.Room;
import org.example.dto.RequestCount;
import org.example.dto.RoomRequestDto;
import org.example.dto.RoomResponseDto;
import org.example.service.ServiceBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookingController {
    private ServiceBooking service;

    @Autowired
    public BookingController(ServiceBooking service) {
        this.service = service;
    }
//    @PostMapping()
//    public DishResponseDto create(@RequestBody DishCreateRequestDto candidate){
//        return service.create(candidate);
//    }

    @PostMapping()
    @Transactional
    public Room bookingRoom(@RequestBody RoomRequestDto dto){
        return service.bookingRoom(dto);
    }
    @GetMapping("/{id}")
    public Room read(@PathVariable("id") long id){
        return service.read(id);
    }
    @GetMapping()
    public List<RoomResponseDto> readAll(){
        return service.readAll();
    }

    @GetMapping("/count")
    public RequestCount getCounter(HttpSession session, HttpServletResponse response){
        Integer count=(Integer) session.getAttribute("requestCount");
        count=count==null? 1: count+1;
        session.setAttribute("requestCount",count);
        Cookie cookie=new Cookie("cook","my_new_cook");
        cookie.setPath("/");
        response.addCookie(cookie);
        return new RequestCount(count, session.getId());

    }

}
