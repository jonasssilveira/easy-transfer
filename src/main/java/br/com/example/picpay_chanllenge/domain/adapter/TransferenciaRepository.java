package br.com.example.picpay_chanllenge.domain.adapter;

import br.com.example.picpay_chanllenge.domain.entity.Transfer;
import br.com.example.picpay_chanllenge.domain.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransferenciaRepository {
    void merge(Transfer transfer);

    Optional<Transfer> get(Long id);

    Optional<Transfer> findByPayer(Long user);

    Optional<Transfer> findByPayee(Long user);

    List<Transfer> ListByDate(User user, LocalDate date);
}
