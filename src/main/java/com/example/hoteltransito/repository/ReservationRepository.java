package com.example.hoteltransito.repository;
import com.example.hoteltransito.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de la entidad Reservation.
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

