package com.cqu.cs.mall.dto;
import com.cqu.cs.mall.convention.errorcode.BaseErrorCode;
import com.cqu.cs.mall.convention.exception.AbstractException;
import lombok.Data;

import java.util.Optional;

@Data
public class Result<T> {
    private String errno;
    private String msg;
    private T data;

    public static <T> Result<T> success() {
        return new Result<T>("0", "success", null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>("0", "success", data);
    }

    public static <T> Result<T> success(T data, String msg) {
        return new Result<T>("0", msg, data);
    }

    public static <T> Result<T> fail() {
        return new Result<T>("1003", "fail", null);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<T>("1003", msg, null);
    }

    public static <T> Result<T> fail(String errno, String msg) {
        return new Result<T>(errno, msg, null);
    }

    public static <T> Result<T> fail(String errno, T data, String msg) {
        return new Result<T>(errno, msg, data);
    }

    public static Result<Void> fail(AbstractException abstractException) {
        String errorCode = Optional.ofNullable(abstractException.getErrorCode())
                .orElse(BaseErrorCode.SERVICE_ERROR.code());
        String errorMessage = Optional.ofNullable(abstractException.getErrorMessage())
                .orElse(BaseErrorCode.SERVICE_ERROR.message());
        return Result.fail(errorCode, null, errorMessage);
    }

    public Result(String errno, String msg, T data) {
        this.errno = errno;
        this.msg = msg;
        this.data = data;
    }
}
