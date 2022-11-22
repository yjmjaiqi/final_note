package com.xxzx.final_note.aop;

import com.xxzx.final_note.entity.Page;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 分页拦截器
 */
@Component
@Aspect
public class PageHelperAop {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    /**
     * 拦截所有请求
     */
    @Pointcut("execution(* com.xxzx.final_note.dao.PageRepository.getNotePage(..))")
    private void pt(){}

    /**
     * 判断是否有pageHelper参数提交，有进行拦截
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //类路径
        String namespace = method.getDeclaringClass().getName();
        //方法名
        String methodName = method.getName();
        Configuration configuration = sqlSessionFactory.getConfiguration();



        MappedStatement mappedStatement = configuration.getMappedStatement(
                namespace + "." + methodName);
        //操作类型
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        System.out.println("type==>" + sqlCommandType);

        BoundSql boundSql = mappedStatement.getBoundSql(null);
        //sql
        String sql = boundSql.getSql();
        System.out.println("sql==>" + sql);
        //修改sql
        String mSql = sql;
        //入参
//        Map<String, Object> parameterMap = new HashMap<>();
//        Object[] args = joinPoint.getArgs();
//        for (Object o : args) {
//            System.out.println("params==>" + o);
//            mSql = sql + " limit "+((Page)o).getStartRow()+","+((Page)o).getCountSize() ;//limit #{startRow},#{pageSize}
//        }


        //通过反射修改sql语句
        Field field = boundSql.getClass().getDeclaredField("sql");
        field.setAccessible(true);
        field.set(boundSql, mSql);





        Object object = joinPoint.proceed();
        return  object;
    }


}
