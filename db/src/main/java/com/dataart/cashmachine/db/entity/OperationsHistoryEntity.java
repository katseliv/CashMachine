package com.dataart.cashmachine.db.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(schema = "cashmachine", name = "operations_history")
@Entity(name = "operations_history")
public class OperationsHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "datetime")
    private Instant datetime;

    @ManyToOne
    @JoinColumn(
            name = "card_id",
            referencedColumnName = "id",
            updatable = false)
    private CardEntity card;

    @ManyToOne
    @JoinColumn(
            name = "operation_id",
            referencedColumnName = "id",
            updatable = false)
    private OperationEntity operation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getDatetime() {
        return datetime;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }

    public CardEntity getCard() {
        return card;
    }

    public void setCard(CardEntity card) {
        this.card = card;
    }

    public OperationEntity getOperation() {
        return operation;
    }

    public void setOperation(OperationEntity operation) {
        this.operation = operation;
    }

}
