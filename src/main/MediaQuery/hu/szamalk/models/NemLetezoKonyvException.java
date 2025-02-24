package hu.szamalk.models;

public class NemLetezoKonyvException extends Exception{
    public NemLetezoKonyvException() {
    }

    public NemLetezoKonyvException(String message) {
        super(message);
    }

    public NemLetezoKonyvException(String message, Throwable cause) {
        super(message, cause);
    }

    public NemLetezoKonyvException(Throwable cause) {
        super(cause);
    }

    public NemLetezoKonyvException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
