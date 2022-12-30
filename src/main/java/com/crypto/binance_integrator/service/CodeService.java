package com.crypto.binance_integrator.service;

import com.crypto.binance_integrator.entity.Code;
import com.crypto.binance_integrator.repository.CodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CodeService {
    private final CodeRepository codeRepository;

    public Code save(String codeName) {
        Code code = new Code();
        code.setName(codeName);
        return codeRepository.save(code);
    }

    public Code get(String codeName) {
        return codeRepository.getByName(codeName).orElseGet(() -> save(codeName));
    }
}
