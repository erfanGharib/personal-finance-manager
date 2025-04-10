package ir.erfangharib.personal_finance_manager.Transactions.exceptions;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(Long transactionId) {
        super("Transaction with ID " + transactionId + " not found.");
    }

    public TransactionNotFoundException(Long transactionId, Throwable cause) {
        super("Transaction with ID " + transactionId + " not found.", cause);
    }

}
