package br.com.example.picpay_chanllenge.domain.chain.of.responsability;

import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;

public class IsShopkeeper extends Rules {

    @Override
    public boolean check(Transferencia checker) {
        if (checker.getTransfer().value() <= 0){
            return false;
        }
        return true;
    }
}
