package com.crypto.binance_integrator.repository;

import com.crypto.binance_integrator.entity.Code;
import com.crypto.binance_integrator.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findAllByTimeLessThan(LocalDateTime time);

    void deleteAllByTimeLessThan(LocalDateTime time);

    Optional<Price> findFirstByCodeOrderByTimeDesc(Code code);

}
