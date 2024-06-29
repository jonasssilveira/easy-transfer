package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public class PayerHasSaldo extends Rules {
    Rules rule;

    public PayerHasSaldo(Rules rule) {
        this.rule = rule;
    }
    @Override
    public boolean check(Transferencia checker) {
        if (checker.getTransfer().getPayer().getSaldo() < checker.getTransfer().getValue()){
            return false;
        }
        return this.checkNext(checker, this.rule);
    }
}
