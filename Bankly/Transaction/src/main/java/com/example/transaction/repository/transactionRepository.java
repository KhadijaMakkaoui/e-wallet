package com.example.transaction.repository;

import com.example.transaction.entity.transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface transactionRepository extends JpaRepository<transaction, Long> {
}
