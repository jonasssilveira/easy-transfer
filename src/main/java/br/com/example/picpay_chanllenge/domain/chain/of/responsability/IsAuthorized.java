package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.exception.OperationNotPerformedException;
import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public class IsAuthorized extends Rules {
    Rules rule;

    public IsAuthorized(Rules rule) {
        this.rule = rule;
    }

    @Override
    public boolean check(Transferencia checker) {
        try{
            if (!checker.getTransactionAuthorizer().authorize().data().get("authorization")) {
                throw new OperationNotPerformedException("Não foi possivel, pois valor não foi autorizado");
            }
        }
        catch (Exception e) {
            throw new OperationNotPerformedException("Não foi possivel, pois valor não foi autorizado");
        }
        return this.checkNext(checker, this.rule);
    }
}
