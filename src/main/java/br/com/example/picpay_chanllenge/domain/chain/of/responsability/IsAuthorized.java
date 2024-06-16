package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public class IsAuthorized extends Rules {
    Rules rule;

    public IsAuthorized(Rules rule) {
        this.rule = rule;
    }

    @Override
    public boolean check(Transferencia checker) {
        if (!checker.getTransactionAuthorizer().authorize().data().get("authorization")) {
            return false;
        }
        return this.checkNext(checker, this.rule);
    }
}
