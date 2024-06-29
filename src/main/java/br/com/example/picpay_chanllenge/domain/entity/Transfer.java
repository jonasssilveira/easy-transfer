package br.com.example.picpay_chanllenge.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "transfer")
public class Transfer{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long Id;
        Long value;
        @OneToOne(fetch = FetchType.LAZY)
        User payer;
        @OneToOne(optional = false, fetch = FetchType.LAZY)
        User payee;
        LocalDate date;

        public Transfer(Long id, Long value, User payer, User payee) {
                Id = id;
                this.value = value;
                this.payer = payer;
                this.payee = payee;
                this.date = LocalDate.now();
        }

        public Transfer() {
        }

        public Long getId() {
                return Id;
        }

        public Long getValue() {
                return value;
        }

        public User getPayer() {
                return payer;
        }

        public User getPayee() {
                return payee;
        }

        public LocalDate getDate() {
                return date;
        }

        public void setId(Long id) {
                Id = id;
        }

        public void setValue(Long value) {
                this.value = value;
        }

        public void setPayer(User payer) {
                this.payer = payer;
        }

        public void setPayee(User payee) {
                this.payee = payee;
        }

        public void setDate(LocalDate date) {
                this.date = date;
        }
}
