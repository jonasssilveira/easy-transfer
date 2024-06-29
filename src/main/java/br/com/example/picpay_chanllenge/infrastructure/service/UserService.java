package br.com.example.picpay_chanllenge.infrastructure.service;

import br.com.example.picpay_chanllenge.domain.usecase.Transferencia;
import br.com.example.picpay_chanllenge.infrastructure.dto.out.TransferDTO;
import br.com.example.picpay_chanllenge.infrastructure.dto.out.UserDTO;
import br.com.example.picpay_chanllenge.infrastructure.feign.TransactionAuthorizer;
import br.com.example.picpay_chanllenge.infrastructure.feign.TransactionNotify;
import br.com.example.picpay_chanllenge.infrastructure.repository.TransferRepositoryJPA;
import br.com.example.picpay_chanllenge.infrastructure.repository.UserRepositoryJPA;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepositoryJPA userRepository;
    private final TransferRepositoryJPA transferenciaRepository;
    private final TransactionAuthorizer transactionAuthorizer;
    private final TransactionNotify transactionNotify;
    private Transferencia transferencia;


    public UserService(@Autowired UserRepositoryJPA userRepository,
                       @Autowired TransferRepositoryJPA transferenciaRepository,
                       @Autowired TransactionAuthorizer transactionAuthorizer,
                       @Autowired TransactionNotify transactionNotify) {
        this.userRepository = userRepository;
        this.transferenciaRepository = transferenciaRepository;
        this.transactionAuthorizer = transactionAuthorizer;
        this.transactionNotify = transactionNotify;
    }

    @PostConstruct
    private void init() {
        this.transferencia = new Transferencia(transactionAuthorizer, transferenciaRepository, transactionNotify, userRepository);
    }

    public void merge(UserDTO user) {
        this.userRepository.save(user.userDTOTOUser());
    }

    public List<UserDTO> getAll() {
        return this.userRepository.findAll().stream().map(UserDTO::userTODTO).collect(Collectors.toList());
    }

    public UserDTO findByEmail(String email) {
        return this.userRepository.findByEmail(email).map(user -> {
            return new UserDTO(user.getId(),
                    user.getFullUserName(),
                    user.getCpf(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getShopkeeper(),
                    user.getSaldo());
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO findById(String id) {
        return this.userRepository.findByEmail(id).map(user -> {
            return new UserDTO(user.getId(),
                    user.getFullUserName(),
                    user.getCpf(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getShopkeeper(),
                    user.getSaldo());
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO findByCPF(String cpf) {
        return this.userRepository.findByEmail(cpf).map(user -> {
            return new UserDTO(user.getId(),
                    user.getFullUserName(),
                    user.getCpf(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getShopkeeper(),
                    user.getSaldo());
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deposit(TransferDTO transfer) {
        var payee = this.userRepository.findById(transfer.idPayee()).orElseThrow(() -> new RuntimeException("Payee not found"));
        this.transferencia.setTransfer(transfer.TransferDTOToTransfer(null, payee));
        this.transferencia.deposit();
    }

    public void transfer(TransferDTO transfer) {
        var payer = this.userRepository.findById(transfer.idPayer()).orElseThrow(() -> new RuntimeException("Payer not found"));
        var payee = this.userRepository.findById(transfer.idPayee()).orElseThrow(() -> new RuntimeException("Payee not found"));
        this.transferencia.setTransfer(transfer.TransferDTOToTransfer(payer, payee));
        this.transferencia.transfere();
    }

    public void withdraw(TransferDTO transfer) {
        var payee = this.userRepository.findById(transfer.idPayee()).orElseThrow(() -> new RuntimeException("Payee not found"));
        this.transferencia.setTransfer(transfer.TransferDTOToTransfer(null, payee));
        this.transferencia.withdraw();
    }

}
