package com.xingchi.common.unique;

import lombok.Data;

/**
 * 结果返回对象工厂
 *
 * @author xingchi
 * @date 2022/8/30 19:56
 * @modified xingchi
 */
@Data
public class Result<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String message;

    /**
     * 操作状态
     */
    private Boolean success;

    private T data;

    public Result(Integer code, String message, Boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public Result(BaseCode baseCode, T data) {
        this(baseCode.code(), baseCode.message(), baseCode.success(), data);
    }

    public Result(BaseCode baseCode) {
        this(baseCode, null);
    }

    public Result(T data) {
        this(CommonCode.SUCCESS, data);
    }

    public Result() {
        this((T) null);
    }


    /**
     * 请求成功
     *
     * @param <T>       返回值参数
     * @return          成功状态
     */
    public static <T> Result<T> ok() {
       return new Result<>(CommonCode.SUCCESS);
    }

    /**
     * 请求成功，返回数据
     *
     * @param data      数据载荷
     * @param <T>       返回载荷类型
     * @return          响应数据
     */
    public static <T> Result<T> ok(T data) {
       return new Result<>(data);
    }

    /**
     * 程序运行失败
     *
     * @param code      状态码
     * @param <T>       数据类型
     * @return          失败错误码
     */
    public static <T> Result<T> fail(BaseCode code) {
       return new Result<>(code);
    }

    /**
     * 程序运行失败
     *
     * @param code      状态码
     * @param <T>       数据类型
     * @param data      失败响应数据
     * @return          失败错误码
     */
    public static <T> Result<T> fail(BaseCode code, T data) {
        return new Result<>(code, data);
    }


}
