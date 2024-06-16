package br.com.example.picpay_chanllenge.infrastructure.service;

import br.com.example.picpay_chanllenge.domain.adapter.TransferenciaRepository;
import br.com.example.picpay_chanllenge.domain.entity.Transfer;
import br.com.example.picpay_chanllenge.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    public TransferenciaService(@Autowired TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public void merge(Transfer transferencia) {
        this.transferenciaRepository.merge(transferencia);
    }

    public List<Transfer> getTransferByDate(User user, String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        LocalDate localDate = LocalDate.parse(date, format);
        return this.transferenciaRepository.ListByDate(user,localDate);
    }

    public Optional<Transfer> getTransferByPayer(User user) {
        return this.transferenciaRepository.findByPayer(user.Id());
    }

    public Optional<Transfer> getTransferByPayee(User user) {
        return this.transferenciaRepository.findByPayee(user.Id());
    }

}
