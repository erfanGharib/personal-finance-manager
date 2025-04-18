package ir.erfangharib.personal_finance_manager.Transactions.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.Instant;

import ir.erfangharib.personal_finance_manager.Transactions.enums.*;

public class TransactionResponseDto {
    public Long id;
    public Integer amount;
    public String description;

    @Enumerated(EnumType.STRING)
    public Type type;

    @Enumerated(EnumType.STRING)
    public Category category;

    public Instant createdDate;
}