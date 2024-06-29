package br.com.example.picpay_chanllenge.infrastructure.repository;

import br.com.example.picpay_chanllenge.domain.adapter.TransferenciaRepository;
import br.com.example.picpay_chanllenge.domain.adapter.UserRepository;
import br.com.example.picpay_chanllenge.domain.entity.Transfer;
import br.com.example.picpay_chanllenge.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransferRepositoryJPA extends TransferenciaRepository, JpaRepository<Transfer, Long> {
    Transfer save(Transfer transfer);

    @Query("SELECT t FROM transfer t WHERE t.date = ?1")
    List<Transfer> findByDate(User user, LocalDate date);

    @Query("SELECT t FROM transfer t WHERE t.id = ?1")
    Optional<Transfer> findById(String id);

    @Query("SELECT t FROM transfer t join user u on u.id = ?1")
    Optional<Transfer> findByPayer(Long payer);

    @Query("SELECT t FROM transfer t join user u on u.id = ?1")
    Optional<Transfer> findByPayee(Long payee);

}
