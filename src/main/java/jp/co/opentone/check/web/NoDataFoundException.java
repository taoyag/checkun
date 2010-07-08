package jp.co.opentone.check.web;

public class NoDataFoundException extends RuntimeException {

    /**
     * SerialVersionUID.
     */
    private static final long serialVersionUID = 5862825301675579377L;

    public NoDataFoundException() {}
    
    public NoDataFoundException(String message) {
        super(message);
    }
    
    public NoDataFoundException(Throwable cause) {
        super(cause);
    }
    
    public NoDataFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
