package ir.erfangharib.personal_finance_manager.Transactions.dto;

import ir.erfangharib.personal_finance_manager.Transactions.enums.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.validation.constraints.*;

public class TransactionRequestDto {
    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    public Integer amount;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    public String description;

    @NotNull(message = "Transaction type is required")
    @Enumerated(EnumType.STRING)
    public Type type;

    @NotNull(message = "Transaction category is required")
    @Enumerated(EnumType.STRING)
    public Category category;
}
