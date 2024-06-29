package br.com.example.picpay_chanllenge.domain.usecase;

import br.com.example.picpay_chanllenge.domain.adapter.ThirdPartyAuthorizer;
import br.com.example.picpay_chanllenge.domain.adapter.ThirdPartyNotify;
import br.com.example.picpay_chanllenge.domain.adapter.TransferenciaRepository;
import br.com.example.picpay_chanllenge.domain.adapter.UserRepository;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.HasAmount;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.IsAuthorized;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.IsShopkeeper;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.PayeeHasAmount;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.PayerHasAmount;
import br.com.example.picpay_chanllenge.domain.chain.of.responsability.PayerHasSaldo;
import br.com.example.picpay_chanllenge.domain.entity.Transfer;

public class Transferencia {
    private final ThirdPartyAuthorizer transactionAuthorizer;
    private final TransferenciaRepository transferenciaRepository;
    private final ThirdPartyNotify thirdPartyNotify;
    private final UserRepository userRepository;

    private Transfer transfer;

    public Transferencia(ThirdPartyAuthorizer transactionAuthorizer, TransferenciaRepository transferenciaRepository, ThirdPartyNotify thirdPartyNotify, UserRepository userRepository) {
        this.transactionAuthorizer = transactionAuthorizer;
        this.transferenciaRepository = transferenciaRepository;
        this.thirdPartyNotify = thirdPartyNotify;
        this.userRepository = userRepository;
    }

    public Boolean transfere() {

        var rules = new PayerHasAmount(new HasAmount(new IsAuthorized(new IsShopkeeper(new PayerHasSaldo(null)))));

        if (!rules.check(this)) {
            return false;
        }
        this.transferenciaRepository.save(this.transfer);
        this.userRepository.deposit(this.transfer.getPayee().getId(), this.transfer.getValue());
        this.userRepository.withdraw(this.transfer.getPayer().getId(), this.transfer.getValue());
      //  this.thirdPartyNotify.pushNotify();
        return true;
    }

    public Boolean withdraw() {

        var rules = new PayeeHasAmount(new HasAmount(new IsAuthorized(null)));

        if (!rules.check(this)) {
            return false;
        }
        this.transferenciaRepository.save(this.transfer);
        this.userRepository.withdraw(this.transfer.getPayee().getId(), this.transfer.getValue());
   //     this.thirdPartyNotify.pushNotify();
        return true;
    }

    public Boolean deposit() {

        var rules = new IsAuthorized(null);

        if (!rules.check(this)) {
            return false;
        }
        this.transferenciaRepository.save(this.transfer);
        this.userRepository.deposit(this.transfer.getPayee().getId(), this.transfer.getValue());
        //this.thirdPartyNotify.pushNotify();
        return true;
    }

    public ThirdPartyAuthorizer getTransactionAuthorizer() {
        return transactionAuthorizer;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public Transfer setTransfer(Transfer transfer) {
        return this.transfer = transfer;
    }
}
