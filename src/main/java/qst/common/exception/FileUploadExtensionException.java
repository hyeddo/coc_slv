package qst.common.exception;

import lombok.Getter;

@Getter
public class FileUploadExtensionException extends RuntimeException{
    private ErrorCode errorCode;

    public FileUploadExtensionException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}