package ir.erfangharib.personal_finance_manager.Transactions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ir.erfangharib.personal_finance_manager.Transactions.dto.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    private final TransactionsService transactionsService;

    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDto> create(
            @Valid @RequestBody TransactionRequestDto transactionRequestDto) {
        TransactionResponseDto response = transactionsService.create(transactionRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponseDto>> getAll() {
        List<TransactionResponseDto> response = transactionsService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDto> getTransactionById(@PathVariable Long id) {
        TransactionResponseDto response = transactionsService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponseDto> update(
            @PathVariable Long id,
            @RequestBody TransactionRequestDto transactionRequestDto) {
        TransactionResponseDto response = transactionsService.updateTransaction(id, transactionRequestDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
