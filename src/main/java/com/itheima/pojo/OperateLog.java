package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {
    private Integer id;
    private Integer operateEmpId;      // int unsigned
    private LocalDateTime operateTime; // datetime
    private String className;          // varchar(100)
    private String methodName;         // varchar(100)
    private String methodParams;       // varchar(1000)  ← 注意:不是 Integer
    private String returnValue;        // varchar(2000)  ← 注意:不是 Integer
    private Long costTime;             // bigint         ← 注意:不是 Integer,且别写成 cost_Time
}
