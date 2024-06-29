package br.com.example.picpay_chanllenge.infrastructure.feign;

import br.com.example.picpay_chanllenge.domain.adapter.ThirdPartyAuthorizer;
import br.com.example.picpay_chanllenge.domain.dto.out.AuthorizerOutDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "transactionAuthorizer", url="https://util.devi.tools/api/v2")
@Component
public interface TransactionAuthorizer extends ThirdPartyAuthorizer {
    @GetMapping("/authorize")
    AuthorizerOutDTO authorize();
}
