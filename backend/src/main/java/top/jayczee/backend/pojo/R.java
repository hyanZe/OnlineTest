package top.jayczee.backend.pojo;


import org.jetbrains.annotations.Nullable;

public class R<T> {
    private final boolean success;
    private Integer code;
    private T data;
    private String message;

    public R() {
        this.success = false;
        this.code = null;
        this.data = null;
        this.message = null;
    }

    protected R(boolean success, String message, Integer code, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    protected R(boolean success, Integer code, T data) {
        this.success = success;
        this.code = code;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public R<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public @Nullable String getMessage() {
        return this.message;
    }

    public @Nullable T getData() {
        return this.data;
    }

    public R<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return this.code;
    }

    public R<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return "R{success=" + this.success + ", message='" + this.message + '\'' + ", code='" + this.code + '\'' + ", data=" + this.data + '}';
    }

    public static <T> R<T> of(boolean success) {
        return new R(success, (String) null, (Integer) null, (Object) null);
    }

    public static <T> R<T> of(boolean success, String message) {
        return new R(success, message, (Integer) null, (Object) null);
    }

    public static <T> R<T> of(boolean success, Integer code) {
        return new R(success, code, (Object) null);
    }

    public static <T> R<T> of(boolean success, String message, Integer code) {
        return new R(success, message, code, (Object) null);
    }

    public static <T> R<T> of(boolean success, String message, Integer code, T data) {
        return new R(success, message, code, data);
    }

    public static <T> R<T> of(boolean success, Integer code, T data) {
        return new R(success, code, data);
    }

    public static <T> R of(boolean success, Integer code, String message, T data) {
        return (new R(success, code, data)).setMessage(message);
    }

    public static <T> R<T> ok() {
        return new R(true, (String) null, (Integer) null, (Object) null);
    }

    public static <T> R<T> ok(String message) {
        return new R(true, message, (Integer) null, (Object) null);
    }

    public static <T> R<T> ok(Integer code) {
        return new R(true, code, (Object) null);
    }

    public static <T> R<T> ok(String message, T data) {
        return new R(true, message, (Integer) null, data);
    }

    public static <T> R<T> ok(String message, Integer code, T data) {
        return new R(true, message, code, data);
    }

    public static <T> R<T> ok(Integer code, T data) {
        return new R(true, code, data);
    }

    public static <T> R<T> okCode(Integer code) {
        return new R(true, (String) null, code, (Object) null);
    }

    public static <T> R<T> okCode(Integer code, String message) {
        return new R(true, message, code, (Object) null);
    }


    public static <T> R<T> okData(T data) {
        return new R(true, (String) null, (Integer) null, data);
    }

    public static <T> R<T> okData(T data, Integer code) {
        return new R(true, (String) null, code, data);
    }

    public static <T> R<T> ng() {
        return new R(false, (String) null, (Integer) null, (Object) null);
    }

    public static <T> R<T> ng(String message) {
        return new R(false, message, (Integer) null, (Object) null);
    }

    public static <T> R<T> ng(Integer code) {
        return new R(false, code, (Object) null);
    }

    public static <T> R<T> ng(String message, Integer code) {
        return new R(false, message, code, (Object) null);
    }

    public static <T> R<T> ng(String message, Integer code, T data) {
        return new R(false, message, code, data);
    }

    public static <T> R<T> ng(Integer code, T data) {
        return new R(false, code, data);
    }

    public static <T> R<T> ngCode(Integer code) {
        return new R(false, (String) null, code, (Object) null);
    }

    public static <T> R<T> ngCode(Integer code, String message) {
        return new R(false, message, code, (Object) null);
    }


    public static <T> R<T> ngData(T data) {
        return new R(false, (String) null, (Integer) null, data);
    }

    public static <T> R<T> ngData(T data, Integer code) {
        return new R(false, (String) null, code, data);
    }


}
