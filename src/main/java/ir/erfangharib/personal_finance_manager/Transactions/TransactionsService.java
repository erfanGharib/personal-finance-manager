package ir.erfangharib.personal_finance_manager.Transactions;

import ir.erfangharib.personal_finance_manager.Transactions.dto.TransactionRequestDto;
import ir.erfangharib.personal_finance_manager.Transactions.dto.TransactionResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

    private final TransactionsRepository repository;
    private final TransactionMapper mapper;

    public TransactionsService(TransactionsRepository repository, TransactionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TransactionResponseDto create(TransactionRequestDto dto) {
        Transactions transaction = mapper.toEntity(dto);
        Transactions saved = repository.save(transaction);

        return mapper.toDto(saved);
    }

    public List<TransactionResponseDto> getAll() {
        List<Transactions> transactions = repository.findAll();
        return transactions.stream()
                .map(mapper::toDto)
                .toList();
    }

    public TransactionResponseDto getById(Long id) {
        Transactions transaction = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        return mapper.toDto(transaction);
    }

    @Transactional
    public TransactionResponseDto updateTransaction(Long id, TransactionRequestDto requestDto) {
        Transactions transaction = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));

        transaction.setAmount(requestDto.amount);
        transaction.setDescription(requestDto.description);
        transaction.setType(requestDto.type);
        transaction.setCategory(requestDto.category);

        Transactions updated = repository.save(transaction);

        return mapper.toDto(updated);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
