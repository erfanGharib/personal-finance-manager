package ir.erfangharib.personal_finance_manager.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Not Found.");
    }
}
