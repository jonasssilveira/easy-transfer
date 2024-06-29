package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public class IsShopkeeper extends Rules {

    Rules rule;

    public IsShopkeeper(Rules rule) {
        this.rule = rule;
    }

    @Override
    public boolean check(Transferencia checker) {
        if (checker.getTransfer().getPayer().getShopkeeper()) {
            return false;
        }
        return this.checkNext(checker, this.rule);
    }
}
