package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.Entity.hotel.Booking;
import org.example.Entity.hotel.Client;
import org.example.Entity.hotel.Room;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class BookingDaoImpl implements BookingDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Room read(long id) {
        return entityManager.find(Room.class, id);
    }

    @Override
    public Room readByNumber(int number) {
        return entityManager.createQuery("SELECT r FROM Room r JOIN r.bookings b JOIN b.client c WHERE r.number = :roomNumber", Room.class)
                .setParameter("roomNumber", number).getSingleResult();
    }

    @Transactional
    @Override
    public Room mergeRoom(Room room) {
        return entityManager.merge(room);
    }

    @Override
    public void detachRoom(Room objects) {
        entityManager.detach(objects);
    }

    @Override
    public Client readClientById(int id) {
        return entityManager.find(Client.class,id);
    }

    @Override
    public void detachClient(Client client) {
        entityManager.detach(client);
    }

    @Override
    @Transactional
    public List<Room> readAll() {
        return entityManager.createQuery("SELECT r FROM Room r JOIN r.bookings b JOIN b.client c", Room.class).getResultList();
    }

}
