package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工实体类 - 对应 emp 表(13个字段)
 * 规则:字段名用 Java 驼峰(deptId),数据库列名是蛇形(dept_id),
 *       两者由 application.yml 的 map-underscore-to-camel-case 自动翻译
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;        // 用户名(你写成 usernaem,拼写)
    private String password;        // 密码是 varchar,用 String!(你写成 Integer passwerd)
    private String name;
    private Integer gender;         // 性别 tinyint → Integer, 1男 2女
    private String phone;           // 手机号是 char(11) → 必须 String!
                                    // "不做数学运算的数字"(手机号/身份证)一律用字符串
    private Integer job;            // 职位 tinyint → Integer(你写成 String,反了)
    private Integer salary;
    private String image;
    private LocalDate entryDate;    // date 列 → LocalDate(你漏了这个字段)
    private Integer deptId;         // dept_id → deptId 驼峰(你写成 dept_id)
    private LocalDateTime createTime;  // datetime 列 → LocalDateTime
    private LocalDateTime updateTime;
    private List<EmpExpr> exprList;
}
