package com.itheima.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//lombok可以完成构造方法
@Data
@AllArgsConstructor
@NoArgsConstructor
//lombok注解
public class Result {//Result实体类
    private Integer code;
    private String msg;
    private Object data;

    public static Result success() {
        return new Result(1,"success",null);
    }
    public static Result success(Object data) {
        return new Result(1,"success",data);
    }
    public static Result error(String msg) {
        return new Result(0,msg,null);
    }
}
