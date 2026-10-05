package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpExpr {
   private Integer id;
   private Integer empId;
   private LocalDate begin;
   private LocalDate end;
   private String company;
   private String job;
}
