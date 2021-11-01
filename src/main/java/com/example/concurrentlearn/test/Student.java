package com.example.concurrentlearn.test;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: wangyu
 * @Date: Created 2020-09-14 13:49
 * @Description:
 * @Modified By:
 */
@Data
@Builder
public class Student {

    private String name;

    private Integer age;

    private Integer height;
}
