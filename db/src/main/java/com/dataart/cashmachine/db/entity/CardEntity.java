package com.dataart.cashmachine.db.entity;

import javax.persistence.*;
import java.util.List;

@Table(schema = "cashmachine", name = "cards")
@Entity(name = "cards")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "pin_code")
    private String pincode;

    @OneToOne
    @JoinColumn(
            name = "owner_id",
            referencedColumnName = "id",
            updatable = false
    )
    private UserEntity owner;

    @Column(name = "attempts")
    private Integer attempts;

    @OneToMany(mappedBy = "card")
    private List<OperationsHistoryEntity> operations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public List<OperationsHistoryEntity> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationsHistoryEntity> operations) {
        this.operations = operations;
    }

}
