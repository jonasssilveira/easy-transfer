package br.com.example.picpay_chanllenge.infrastructure.service;

import br.com.example.picpay_chanllenge.domain.adapter.TransferenciaRepository;
import br.com.example.picpay_chanllenge.domain.entity.Transfer;
import br.com.example.picpay_chanllenge.domain.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    public TransferenciaService(@Autowired TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public void merge(Transfer transferencia) {
        this.transferenciaRepository.save(transferencia);
    }

    public List<Transfer> getTransferByDate(User user, String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, format);
        return this.transferenciaRepository.findByDate(user,localDate);
    }

    public Optional<Transfer> getTransferByPayer(User user) {
        return this.transferenciaRepository.findByPayer(user.getId());
    }

    public Optional<Transfer> getTransferByPayee(User user) {
        return this.transferenciaRepository.findByPayee(user.getId());
    }

}
