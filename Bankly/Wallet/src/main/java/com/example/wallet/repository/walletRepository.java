package com.example.wallet.repository;

import com.example.wallet.entity.wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface walletRepository extends JpaRepository<wallet, Long> {
    wallet findByRef(String ref);
}
