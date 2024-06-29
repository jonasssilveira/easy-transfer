package br.com.example.picpay_chanllenge.infrastructure.repository;

import br.com.example.picpay_chanllenge.domain.adapter.UserRepository;
import br.com.example.picpay_chanllenge.domain.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJPA extends UserRepository, JpaRepository<User, Long> {
    User save(User user);

    @Query("SELECT u FROM user u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM user u WHERE u.Id = ?1")
    Optional<User> findById(Long id);

    @Query("SELECT u FROM user u WHERE u.cpf = ?1")
    Optional<User> findByCPF(String cpf);

    @Modifying
    @Query("UPDATE user u SET u.saldo = u.saldo + ?2 WHERE u.Id = ?1")
    @Transactional
    void deposit(Long id, Long amount);

    @Modifying
    @Query("UPDATE user u SET u.saldo = u.saldo - ?2 WHERE u.Id = ?1")
    @Transactional
    void withdraw(Long id, Long amount);
}
