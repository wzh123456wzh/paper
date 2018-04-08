package com.wzh.paper.interceptor;

import com.wzh.paper.entity.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ResultAspect {

    @Pointcut("execution (* com.wzh.paper.service.impl.*.*(..))")
    private void anyMethod() {
    }

    @Pointcut("execution (* com.wzh.paper.service.impl.*.save*(..))")
    private void saveMethod() {
    }

    @Pointcut("execution (* com.wzh.paper.service.impl.*.remove*(..))")
    private void removeMethod() {
    }

    @Pointcut("execution (* com.wzh.paper.service.impl.*.*Select(..))")
    private void selectMethod() {
    }

    @Pointcut("execution (* com.wzh.paper.service.impl.*.update*(..))")
    private void updateMethod() {
    }

//    @Before("anyMethod()")
//    public void doAccessCheck() {
//        System.out.println("all");
//    }

    @AfterReturning(returning="result", pointcut = "saveMethod()")
    public void doAccessSave(JoinPoint joinPoint, Result result) {
        if(result != null && result.getCode() != Result.ResultCode.SAVE_FAIL_CODE){
            result.setCode(Result.ResultCode.SAVE_SUCCESS_CODE);
            result.setMsg("添加成功");
        }
    }

    @Around("saveMethod()")
    public Result doAccessSaveRound(ProceedingJoinPoint pjp) {
        Result result;
        try{
            result = (Result) pjp.proceed();
        } catch (Throwable e){
            result = new Result(Result.ResultCode.SAVE_FAIL_CODE, "添加失败");
            e.printStackTrace();
        }
        return result;
    }

    @AfterReturning(returning="result", pointcut = "selectMethod()")
    public void doAccessSelect(JoinPoint joinPoint, Result result) {
        if(result.getData() != null && result.getCode() != Result.ResultCode.SELECT_FAIL_CODE){
            result.setCode(Result.ResultCode.SELECT_SUCCESS_CODE);
            result.setMsg("查询成功");
        } else if(result.getCode() != Result.ResultCode.SELECT_FAIL_CODE){
            result.setCode(Result.ResultCode.EMPTY_CODE);
            result.setMsg("没有数据");
        }
    }

    @Around("selectMethod()")
    public Result doAccessSelectRound(ProceedingJoinPoint pjp) {
        Result result;
        try{
            result = (Result) pjp.proceed();
        } catch (Throwable e){
            result = new Result(Result.ResultCode.SELECT_FAIL_CODE, "查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @AfterReturning(returning="result", pointcut = "updateMethod()")
    public void doAccessUpdate(JoinPoint joinPoint, Result result) {
        if(result != null && result.getCode() != Result.ResultCode.UPDATE_FAIL_CODE){
            result.setCode(Result.ResultCode.UPDATE_SUCCESS_CODE);
            result.setMsg("更新成功");
        }
    }

    @Around("updateMethod()")
    public Result doAccessUpdateRound(ProceedingJoinPoint pjp) {
        Result result;
        try{
            result = (Result) pjp.proceed();
        } catch (Throwable e){
            result = new Result(Result.ResultCode.UPDATE_FAIL_CODE, "更新失败");
            e.printStackTrace();
        }
        return result;
    }

    @AfterReturning(returning="result", pointcut = "removeMethod()")
    public void doAccessRemove(JoinPoint joinPoint, Result result) {
        if(result != null && result.getCode() != Result.ResultCode.REMOVEAIL_CODE){
            result.setCode(Result.ResultCode.REMOVE_SUCCESS_CODE);
            result.setMsg("删除成功");
        }
    }

    @Around("removeMethod()")
    public Result doAccessRemoveRound(ProceedingJoinPoint pjp) {
        Result result;
        try{
            result = (Result) pjp.proceed();
        } catch (Throwable e){
            result = new Result(Result.ResultCode.REMOVEAIL_CODE, "删除失败");
            e.printStackTrace();
        }
        return result;
    }
}
