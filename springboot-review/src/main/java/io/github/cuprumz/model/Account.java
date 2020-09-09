package io.github.cuprumz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    // @GeneratedValue
    private long id;
    private float balance;

    public Account() {
    }

    public Account(float balance) {
        this.balance = balance;
    }

    public Account(long id, float balance) {
        this.id = id;
        this.balance = balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

}
