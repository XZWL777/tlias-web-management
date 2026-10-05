package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpExpr;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {   // 类名大驼峰 Impl;必须 implements 接口(你都丢了)

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageBean page(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        // ① 分页开关:PageHelper 把 (page, pageSize) 记在"便签"(ThreadLocal)上,
        //    声明"下一条 SQL 要分页"。它自己一条 SQL 都不执行。
        PageHelper.startPage(page, pageSize);

        // ② 执行查询。你写的是 select *,但因为有①的便签,
        //    PageHelper 的拦截器会自动发两条 SQL:
        //    select count(*) from emp   (先数总数)
        //    select * from emp limit ?,? (再查当前页)
        List<Emp> empList = empMapper.list(name, gender, begin, end);

        // ③ 返回类型写的是 List,但装回来的对象本来就是 Page(Page 是 ArrayList 的子类,
        //    所以能伪装成 List)。强转 = 让它亮出真实身份,才能调 getTotal()
        Page<Emp> p = (Page<Emp>) empList;

        // ④ 组装 PageBean:p.getTotal()=总数, p.getResult()=当前页数据(方法调用要有括号!)
        return new PageBean(p.getTotal(), p.getResult());
    }


    @Override
//    @Transactional(rollbackFor = Exception.class)
    public void save(Emp emp){
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);

        List<EmpExpr> exprList = emp.getExprList();
        if(exprList!=null&&!exprList.isEmpty()){
            exprList.forEach(e->e.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }
}
