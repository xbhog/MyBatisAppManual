package com.xbhog.mapper;

import com.xbhog.pojo.Dept;
import com.xbhog.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xbhog
 * @date 2022/5/30
 */
public interface EmpMapper {

    /**
     * 获取所有的客户信息
     */
    List<Emp> getAllEmp();
    /**
     * 通过id进行连结查询员工和部门的信息,多对一
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);
    /**
     * 分步查询 stepOne
     */
    Emp getEmpAndDeptStepOne(@Param("eid") Integer eid);

    /**
     * 通过id查询部门中的员工信息，一对多
     * @param did
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);

    /**
     * 连表查询多对一
     */
    Emp getEmpAllDate(@Param("eid") Integer eid);
}
