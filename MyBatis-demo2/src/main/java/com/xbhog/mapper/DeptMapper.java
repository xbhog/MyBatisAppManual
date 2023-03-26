package com.xbhog.mapper;

import com.xbhog.pojo.Dept;
import com.xbhog.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xbhog
 * @date 2022/5/30
 */
public interface DeptMapper {
    /**
     * 分步查询：stepTwo,
     */
    Dept getDeptSetupTwo(@Param("did") Integer did);

    /**
     * 获取员工信息，分步查询
     * @param did
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
