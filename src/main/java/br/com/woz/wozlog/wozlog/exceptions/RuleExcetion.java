package br.com.woz.wozlog.wozlog.exceptions;

public class RuleExcetion extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RuleExcetion(String message) {
        super(message);
    }
}
