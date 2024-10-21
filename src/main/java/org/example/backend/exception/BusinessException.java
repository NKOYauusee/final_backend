package org.example.backend.exception;


import lombok.Getter;
import org.example.backend.entity.enums.ResponseCodeEnum;

@Getter
public class BusinessException extends Exception {
    private final Integer code;
    private final String status;

    public BusinessException(ResponseCodeEnum responseCodeEnum) {
        this.code = responseCodeEnum.getCode();
        this.status = responseCodeEnum.getStatus();
    }

    public BusinessException(String msg) {
        this.code = ResponseCodeEnum.CODE_600.getCode();
        this.status = msg;
    }
}
