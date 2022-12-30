package com.crypto.binance_integrator.job;


import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.TickerPrice;
import com.crypto.binance_integrator.entity.Code;
import com.crypto.binance_integrator.provider.SettingsProvider;
import com.crypto.binance_integrator.service.CodeService;
import com.crypto.binance_integrator.service.PriceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
@EnableScheduling
public class BinanceFetcherJob {

    private final CodeService codeService;
    private final PriceService priceService;
    private final BinanceApiRestClient binanceApiRestClient;
    private final SettingsProvider settingsProvider;

    @Scheduled(fixedRate = 60000)
    private void call() {
        List<TickerPrice> tickerPrices = binanceApiRestClient.getAllPrices();
        BigDecimal multiply = settingsProvider.getMultiply();

        tickerPrices.forEach(tickerPrice -> {
            String codeName = null;
            BigDecimal price = null;
            try {
                codeName = tickerPrice.getSymbol();
                Code code = codeService.get(codeName);
                price = new BigDecimal(tickerPrice.getPrice());

                priceService.save(code, price.multiply(multiply).toBigInteger(), LocalDateTime.now());
            } catch (Exception e) {
                log.error("code {}, price {}, exc {}", codeName, price, e );
            }
        });
    }
}
