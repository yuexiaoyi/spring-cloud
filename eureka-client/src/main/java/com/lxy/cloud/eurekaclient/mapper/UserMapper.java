package com.lxy.cloud.eurekaclient.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxy.cloud.eurekaclient.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lxy
 * @create 2019-02-23 17:01
 **/
@Mapper
public interface UserMapper extends BaseMapper<UserVO>{

    @Select("select * from t_student")
    List<UserVO> findAll();

}
