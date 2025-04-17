package ir.erfangharib.personal_finance_manager.Transactions;

import ir.erfangharib.personal_finance_manager.Transactions.dto.TransactionRequestDto;
import ir.erfangharib.personal_finance_manager.Transactions.dto.TransactionResponseDto;
import ir.erfangharib.personal_finance_manager.exception.NotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

    private final TransactionsRepository repository;
    private final TransactionMapper mapper;

    @Autowired
    public TransactionsService(TransactionsRepository repository, TransactionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TransactionResponseDto create(@Valid TransactionRequestDto dto) {
        Transactions transaction = mapper.toEntity(dto);
        Transactions saved = repository.save(transaction);

        return mapper.toDto(saved);
    }

    public List<TransactionResponseDto> getAll() {
        List<Transactions> transactions = repository.findAll();
        return mapToDtoList(transactions);
    }

    public TransactionResponseDto getById(Long id) {
        Transactions transaction = findTransactionById(id);
        return mapper.toDto(transaction);
    }

    @Transactional
    public TransactionResponseDto updateTransaction(Long id, @Valid TransactionRequestDto requestDto) {
        Transactions transaction = findTransactionById(id);

        transaction.setAmount(requestDto.amount);
        transaction.setDescription(requestDto.description);
        transaction.setType(requestDto.type);
        transaction.setCategory(requestDto.category);

        Transactions updated = repository.save(transaction);

        return mapper.toDto(updated);
    }

    public void delete(Long id) {
        Transactions transaction = findTransactionById(id);
        repository.delete(transaction);
    }

    private Transactions findTransactionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    private List<TransactionResponseDto> mapToDtoList(List<Transactions> transactions) {
        return transactions.stream()
                .map(mapper::toDto)
                .toList();
    }

}
