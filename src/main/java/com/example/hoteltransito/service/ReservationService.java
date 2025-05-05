package com.example.hoteltransito.service;
import com.example.hoteltransito.model.Reservation;
import com.example.hoteltransito.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Transactional
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Transactional
    public Optional<Reservation> update(Long id, Reservation reservation) {
        return reservationRepository.findById(id)
                .map(existing -> {
                    existing.setUser(reservation.getUser());
                    existing.setRoom(reservation.getRoom());
                    existing.setCheckInDate(reservation.getCheckInDate());
                    existing.setCheckOutDate(reservation.getCheckOutDate());
                    existing.setStatus(reservation.getStatus());
                    existing.setTotalPrice(reservation.getTotalPrice());
                    existing.setUpdatedAt(reservation.getUpdatedAt());
                    return reservationRepository.save(existing);
                });
    }

    @Transactional
    public boolean delete(Long id) {
        return reservationRepository.findById(id)
                .map(existing -> {
                    reservationRepository.delete(existing);
                    return true;
                }).orElse(false);
    }
}
