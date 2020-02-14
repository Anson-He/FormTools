package com.formtools.mapper;

import com.formtools.model.BuiltForm;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * 增删查改用户创建的表单
 * @author myl
 * @create 2020-02-05  14:24
 */
@Mapper
public interface BuiltFormMapper {

    int addBuiltForm(BuiltForm builtForm);

    BuiltForm getBuiltForm(String id);

    List<BuiltForm> findAllBuiltForm();

    @Update("update all_built_form set formInfo=#{formInfo} where id=#{id} ")
    int updateBuiltForm(BuiltForm builtForm);

    @Delete(" delete from all_built_form where id= #{id} ")
    int deleteBuiltForm(String id);
}
