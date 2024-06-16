package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public abstract class Rules {
    public abstract boolean check(Transferencia checker);

    protected Boolean checkNext(Transferencia checker, Rules next) {
        if (next == null) {
            return true;
        }
        return next.check(checker);
    }
}
