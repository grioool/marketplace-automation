package by.sam_solutions.grigorieva.olga.backend.exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorCode;
    private String errorMsg;

    public BusinessException(String businessException) {
        super(businessException);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public BusinessException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
