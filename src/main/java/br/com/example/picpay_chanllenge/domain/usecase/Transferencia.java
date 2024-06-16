package br.com.example.picpay_chanllenge.domain.usecase;

import br.com.example.picpay_chanllenge.domain.adapter.ThirdPartyAuthorizer;
import br.com.example.picpay_chanllenge.domain.adapter.ThirdPartyNotify;
import br.com.example.picpay_chanllenge.domain.adapter.TransferenciaRepository;
import br.com.example.picpay_chanllenge.domain.adapter.UserRepository;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.HasAmount;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.IsAuthorized;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.IsShopkeeper;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.PayerHasSaldo;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.Rules;
import br.com.example.picpay_chanllenge.domain.entity.Transfer;

public class Transferencia {
    private final ThirdPartyAuthorizer transactionAuthorizer;
    private final TransferenciaRepository transferenciaRepository;
    private final ThirdPartyNotify thirdPartyNotify;
    private final Transfer transfer;
    private final UserRepository userRepository;

    public Transferencia(ThirdPartyAuthorizer transactionAuthorizer, TransferenciaRepository transferenciaRepository, ThirdPartyNotify thirdPartyNotify, Transfer transfer, UserRepository userRepository) {
        this.transactionAuthorizer = transactionAuthorizer;
        this.transferenciaRepository = transferenciaRepository;
        this.thirdPartyNotify = thirdPartyNotify;
        this.transfer = transfer;
        this.userRepository = userRepository;
    }

    public Boolean transfere() {

        var rules = new HasAmount(new IsAuthorized(new IsShopkeeper(new PayerHasSaldo(null))));

        if (!rules.check(this)) {
            return false;
        }
        this.transferenciaRepository.merge(this.transfer);
        this.userRepository.deposit(this.transfer.payee().Id(), this.transfer.value());
        this.userRepository.withdraw(this.transfer.payer().Id(), this.transfer.value());
        this.thirdPartyNotify.pushNotify();
        return true;
    }

    public ThirdPartyAuthorizer getTransactionAuthorizer() {
        return transactionAuthorizer;
    }

    public TransferenciaRepository getTransferenciaRepository() {
        return transferenciaRepository;
    }

    public ThirdPartyNotify getThirdPartyNotify() {
        return thirdPartyNotify;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
