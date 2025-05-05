package com.example.hoteltransito.repository;

import com.example.hoteltransito.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de la entidad RoomType.
 */
@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
}
