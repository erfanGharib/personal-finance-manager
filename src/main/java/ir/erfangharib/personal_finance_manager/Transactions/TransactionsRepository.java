package ir.erfangharib.personal_finance_manager.Transactions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    @Override
    public Optional<Transactions> findById(Long id);

}
