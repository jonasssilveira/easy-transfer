package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.exception.OperationNotPerformedException;
import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public class PayeeHasAmount extends Rules {

    Rules rule;

    public PayeeHasAmount(Rules rule) {
        this.rule = rule;
    }

    @Override
    public boolean check(Transferencia checker) {
        if (checker.getTransfer().getPayee().getSaldo() - checker.getTransfer().getValue() <= 0L){
            throw new OperationNotPerformedException("Não foi possivel, saldo insuficiente");
        }
        return this.checkNext(checker, this.rule);
    }
}
