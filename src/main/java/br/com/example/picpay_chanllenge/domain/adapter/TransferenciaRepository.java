package br.com.example.picpay_chanllenge.domain.adapter;

import br.com.example.picpay_chanllenge.domain.entity.Transfer;
import br.com.example.picpay_chanllenge.domain.entity.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransferenciaRepository {
    void merge(Transfer transfer);

    Optional<Transfer> get(Long id);

    List<Transfer> ListByUser(User user);

    List<Transfer> ListByDate(Date date);
}
