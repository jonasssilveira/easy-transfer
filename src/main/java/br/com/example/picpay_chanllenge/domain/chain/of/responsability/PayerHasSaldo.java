package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public class PayerHasSaldo extends Rules {

    @Override
    public boolean check(Transferencia checker) {
        if (checker.getTransfer().payee().shopkeeper()){
            return false;
        }
        return true;
    }
}
