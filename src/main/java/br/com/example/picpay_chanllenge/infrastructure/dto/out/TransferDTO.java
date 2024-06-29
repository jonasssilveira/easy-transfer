package br.com.example.picpay_chanllenge.infrastructure.dto.out;

import br.com.example.picpay_chanllenge.domain.entity.Transfer;
import br.com.example.picpay_chanllenge.domain.entity.User;

public record TransferDTO(Long value,
                          Long idPayer,
                          Long idPayee) {

    public Transfer TransferDTOToTransfer(User payer, User payee){
        return new Transfer(this.idPayee, this.value, payer, payee);
    }

}
