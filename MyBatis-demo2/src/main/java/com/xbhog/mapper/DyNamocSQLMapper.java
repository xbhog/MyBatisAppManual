package com.xbhog.mapper;

import com.xbhog.pojo.Emp;

/**
 * @author xbhog
 * @date 2022/6/1
 */
public interface DyNamocSQLMapper {

    /**
     * if以及where标签
     * @param emp
     * @return
     */
    Emp getEmpByCondition(Emp emp);
}
