package br.com.example.picpay_chanllenge.domain.usecase;

import br.com.example.picpay_chanllenge.domain.adapter.ThirdPartyAuthorizer;
import br.com.example.picpay_chanllenge.domain.adapter.TransferenciaRepository;
import br.com.example.picpay_chanllenge.domain.entity.User;

public class Transfer {

    private final User payer;
    private final User payee;
    private final Long amount;

    private final ThirdPartyAuthorizer transactionAuthorizer;
    private final TransferenciaRepository transferenciaRepository;

    public Transfer(User payer, User payee, Long amount, ThirdPartyAuthorizer transactionAuthorizer, TransferenciaRepository transferenciaRepository) {
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
        this.transactionAuthorizer = transactionAuthorizer;
        this.transferenciaRepository = transferenciaRepository;
    }

    private Boolean transfer(){
        if (amount <= 0) {
            return false;
        }
        if (this.payee.shopkeeper()){
            return false;
        }
        if (this.payer.saldo() >= this.amount){
            return false;
        }
        if (this.transactionAuthorizer.authorize().data().get("authorization")){
            return false;
        }




    }

}
