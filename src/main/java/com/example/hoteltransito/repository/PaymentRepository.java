package com.example.hoteltransito.repository;

import com.example.hoteltransito.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de la entidad Payment.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
