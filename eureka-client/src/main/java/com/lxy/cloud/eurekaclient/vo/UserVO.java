package com.lxy.cloud.eurekaclient.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author lxy
 * @time 2019-04-25 10:31
 **/
@Data
@TableName("t_student")
public class UserVO {

    @TableId(value = "t_id",type = IdType.AUTO)
    private long id;

    @TableField(value = "t_age")
    private int age;

    @TableField(value = "t_name")
    private String name;

    @TableField(value = "t_score")
    private double score;

}
