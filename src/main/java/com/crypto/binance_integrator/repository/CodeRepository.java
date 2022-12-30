package com.crypto.binance_integrator.repository;

import com.crypto.binance_integrator.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeRepository extends JpaRepository<Code, Long> {

    Optional<Code> getByName(String name);
}
