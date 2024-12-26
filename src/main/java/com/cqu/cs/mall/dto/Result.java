package com.cqu.cs.mall.dto;
import lombok.Data;
@Data
public class Result<T> {
    private Integer errno;
    private String msg;
    private T data;

    public static <T> Result<T> success() {
        return new Result<T>(0, "success", null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(0, "success", data);
    }

    public static <T> Result<T> success(T data, String msg) {
        return new Result<T>(0, msg, data);
    }

    public static <T> Result<T> fail() {
        return new Result<T>(1003, "fail", null);
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<T>(1003, msg, null);
    }

    public static <T> Result<T> fail(T data, String msg) {
        return new Result<T>(1003, msg, data);
    }

    public Result(Integer errno, String msg, T data) {
        this.errno = errno;
        this.msg = msg;
        this.data = data;
    }
}
