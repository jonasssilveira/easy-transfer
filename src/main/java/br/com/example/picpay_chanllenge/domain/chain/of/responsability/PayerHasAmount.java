package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public class PayerHasAmount extends Rules {

    Rules rule;

    public PayerHasAmount(Rules rule) {
        this.rule = rule;
    }

    @Override
    public boolean check(Transferencia checker) {
        if (checker.getTransfer().getPayer().getSaldo() - checker.getTransfer().getValue() <= 0L){
            return false;
        }
        return this.checkNext(checker, this.rule);
    }
}
