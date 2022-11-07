package br.com.woz.wozlog.wozlog.exceptions;

public class RuleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RuleException(String message) {
        super(message);
    }
}
