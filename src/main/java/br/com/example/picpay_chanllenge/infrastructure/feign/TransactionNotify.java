package br.com.example.picpay_chanllenge.infrastructure.feign;

import br.com.example.picpay_chanllenge.domain.adapter.ThirdPartyNotify;
import br.com.example.picpay_chanllenge.domain.dto.out.NotifyOutDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "transactionNotify", url="https://util.devi.tools/api/v1")
@Component
public interface TransactionNotify extends ThirdPartyNotify {
    @GetMapping("/notify")
    NotifyOutDTO pushNotify();
}
