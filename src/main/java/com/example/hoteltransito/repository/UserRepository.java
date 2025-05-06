package com.example.hoteltransito.repository;
import com.example.hoteltransito.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de la entidad User.
 * Proporciona métodos como findAll, findById, save y delete.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
