package br.com.example.picpay_chanllenge.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.Set;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "full_user_name")
    private String fullUserName;
    @Column(unique = true, nullable = false)
    private Long cpf;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private Boolean shopkeeper;
    private Long saldo;

    public User(Long id, String fullUserName, Long cpf, String email, String password, Boolean shopkeeper, Long saldo) {
        Id = id;
        this.fullUserName = fullUserName;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.shopkeeper = shopkeeper;
        this.saldo = saldo;
    }

    public User() {
    }

    public Long getId() {
        return Id;
    }

    public String getFullUserName() {
        return fullUserName;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getShopkeeper() {
        return shopkeeper;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setFullUserName(String fullUserName) {
        this.fullUserName = fullUserName;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setShopkeeper(Boolean shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }
}
