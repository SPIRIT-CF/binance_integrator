package com.crypto.binance_integrator.config;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.impl.BinanceApiRestClientImpl;
import com.crypto.binance_integrator.provider.SettingsProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BinanceRestConfig {

    private final SettingsProvider settingsProvider;

    @Bean
    public BinanceApiRestClient binanceApiRestClient() {
        return new BinanceApiRestClientImpl(settingsProvider.getApiKey(), settingsProvider.getSecretKey());
    }
}
