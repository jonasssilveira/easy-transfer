package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public class HasAmount extends Rules {

    Rules rule;

    public HasAmount(Rules rule) {
        this.rule = rule;
    }

    @Override
    public boolean check(Transferencia checker) {
        if (checker.getTransfer().value() <= 0L){
            return false;
        }
        return this.checkNext(checker, this.rule);
    }
}
