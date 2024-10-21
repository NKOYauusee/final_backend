package org.example.backend.entity.vo;

import lombok.Data;
import org.example.backend.entity.enums.ResponseCodeEnum;
import org.example.backend.exception.BusinessException;

import java.io.Serializable;

@Data
public class ResponseVo<T> implements Serializable {
    private final int code;
    private final String status;
    private final String info;
    private T data;

    public ResponseVo(BusinessException e) {
        this.code = e.getCode();
        this.status = e.getStatus();
        this.info = null;
        this.data = null;
    }

    public ResponseVo(ResponseCodeEnum codeEnum, String info, T data) {
        this.code = codeEnum.getCode();
        this.status = codeEnum.getStatus();
        this.info = info;
        this.data = data;
    }

}
