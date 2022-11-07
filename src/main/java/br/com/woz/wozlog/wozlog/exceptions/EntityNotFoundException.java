package br.com.woz.wozlog.wozlog.exceptions;

public class EntityNotFoundException extends RuleException {
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
