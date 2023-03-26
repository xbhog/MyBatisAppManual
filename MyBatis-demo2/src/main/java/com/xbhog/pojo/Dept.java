package com.xbhog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xbhog
 * @date 2022/5/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer did;
    private String deptName;
    private List<Emp> emps;
}
