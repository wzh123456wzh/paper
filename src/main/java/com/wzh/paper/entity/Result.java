package com.wzh.paper.entity;

public class Result<T> {

    private int code;

    private String msg;

    private T data;

    public static class ResultCode{
        public static final int SUCCESS_CODE = 100;
        public static final int SAVE_SUCCESS_CODE = 101;
        public static final int REMOVE_SUCCESS_CODE = 102;
        public static final int SELECT_SUCCESS_CODE = 103;
        public static final int UPDATE_SUCCESS_CODE = 104;
        public static final int FAIL_CODE = 200;
        public static final int SAVE_FAIL_CODE = 201;
        public static final int REMOVEAIL_CODE = 202;
        public static final int SELECT_FAIL_CODE = 203;
        public static final int UPDATE_FAIL_CODE = 204;
        public static final int EMPTY_CODE = 300;
    }

    public Result(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result(T data){
        this.data = data;
    }

    public Result() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result createSuccessResult(T data){
        return new Result(ResultCode.SUCCESS_CODE, "数据返回成功", data);
    }

    public Result createFailResult(T data){
        return new Result(ResultCode.FAIL_CODE, "数据返回失败", data);
    }

    public Result createEmptyResult(){
        return new Result(ResultCode.EMPTY_CODE, "没有数据");
    }





}
