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

    @Pointcut("execution (* com.wzh.paper.service.impl.*.delete*(..))")
    private void deleteMethod() {
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
        if(result != null && result.getCode() != Result.SAVE_FAIL_CODE){
            result.setCode(Result.SAVE_SUCCESS_CODE);
            result.setMsg("添加成功");
        }
    }

    @Around("saveMethod()")
    public Result doAccessSaveRound(ProceedingJoinPoint pjp) {
        Result result;
        try{
            result = (Result) pjp.proceed();
        } catch (Throwable e){
            result = new Result(Result.SAVE_FAIL_CODE, "添加失败");
            e.printStackTrace();
        }
        return result;
    }

    @AfterReturning(returning="result", pointcut = "selectMethod()")
    public void doAccessSelect(JoinPoint joinPoint, Result result) {
        if(result.getData() != null && result.getCode() != Result.SELECT_FAIL_CODE){
            result.setCode(Result.SELECT_SUCCESS_CODE);
            result.setMsg("查询成功");
        } else if(result.getCode() != Result.SELECT_FAIL_CODE){
            result.setCode(Result.EMPTY_CODE);
            result.setMsg("没有数据");
        }
    }

    @Around("selectMethod()")
    public Result doAccessSelectRound(ProceedingJoinPoint pjp) {
        Result result;
        try{
            result = (Result) pjp.proceed();
        } catch (Throwable e){
            result = new Result(Result.SELECT_FAIL_CODE, "查询失败");
            e.printStackTrace();
        }
        return result;
    }

//    @AfterReturning(returning="result", pointcut = "saveMethod()")
//    public void doAccessUpdate(JoinPoint joinPoint, Result result) {
//        if(result != null){
////            result = new Result(Result.SAVE_SUCCESS_CODE, "添加成功");
//            result.setCode(Result.SAVE_SUCCESS_CODE);
//            result.setMsg("添加成功");
//        } else{
//            result.setCode(Result.SAVE_FAIL_CODE);
//            result.setMsg("添加失败");
//        }
//    }
}
