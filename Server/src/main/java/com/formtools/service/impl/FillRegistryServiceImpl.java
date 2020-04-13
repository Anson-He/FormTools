package com.formtools.service.impl;

import com.formtools.mapper.BuiltFormMapper;
import com.formtools.model.BuiltForm;
import com.formtools.service.FillRegistryService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FillRegistryServiceImpl implements FillRegistryService {

    @Resource
    private BuiltFormMapper builtFormMapper;

    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * 获取表单基本信息、题目...
     * @param formId 表单id
     * @return 表单基本信息（标题，题目，建表人...
     */
    @Override
    public BuiltForm getFormInfo(Long formId) {

        String FormInfoKey = "FormInfo"+formId;

        //从缓存获取表单 题目信息
        BuiltForm builtForm = (BuiltForm) redisTemplate.opsForValue().get(FormInfoKey);
        //若缓存中不存在该表单 题目信息
        if (builtForm == null){
            synchronized (this){
                builtForm = builtFormMapper.getBuiltForm(formId);
                //若数据库查无此表 返回空
                if (builtForm == null) return null;
                redisTemplate.opsForValue().set(FormInfoKey,builtForm);
            }
        }
        return builtForm;
    }
}