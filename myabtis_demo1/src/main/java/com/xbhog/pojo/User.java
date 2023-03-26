package com.xbhog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xbhog
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private  Integer id;
    private  String name;
    private Integer age;
    private String pwd;
}
