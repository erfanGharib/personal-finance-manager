package ir.erfangharib.personal_finance_manager.Transactions;

import org.mapstruct.Mapper;

import ir.erfangharib.personal_finance_manager.Transactions.dto.TransactionRequestDto;
import ir.erfangharib.personal_finance_manager.Transactions.dto.TransactionResponseDto;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionResponseDto toDto(Transactions transaction);

    Transactions toEntity(TransactionRequestDto dto);

}
