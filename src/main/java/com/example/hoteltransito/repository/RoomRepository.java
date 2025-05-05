package com.example.hoteltransito.repository;
import com.example.hoteltransito.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de la entidad Room.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
