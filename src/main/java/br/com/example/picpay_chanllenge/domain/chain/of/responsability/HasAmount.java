package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.exception.OperationNotPerformedException;
import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public class HasAmount extends Rules {

    Rules rule;

    public HasAmount(Rules rule) {
        this.rule = rule;
    }

    @Override
    public boolean check(Transferencia checker) {
        if (checker.getTransfer().getValue() <= 0L){
            throw new OperationNotPerformedException("Não foi possivel, pois valor não pode ser menor que 1");
        }
        return this.checkNext(checker, this.rule);
    }
}
