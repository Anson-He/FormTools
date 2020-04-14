package com.formtools.utils;

import com.alibaba.fastjson.JSONObject;
import com.formtools.model.FillRegistry;
import com.formtools.vo.FillRegistryReq;

public class FillRegisteryUtil {
    /**
     * 普通表
     * @param fillRegistryReq 内容Req
     * @return 内容
     */
    public static FillRegistry toFillRegisteryCommen(FillRegistryReq fillRegistryReq) {
        return new FillRegistry(
                fillRegistryReq.getUserId(),
                fillRegistryReq.getFormId(),
                fillRegistryReq.getFillContent().toJSONString(),
                null,
                null,
                fillRegistryReq.getFileList(),
                fillRegistryReq.getCheckState()
                );
    }

    /**
     * 审核表
     * @param fillRegistryReq 内容Req
     * @return 内容
     */
    public static FillRegistry toFillRegisteryCheck(FillRegistryReq fillRegistryReq) {
        return new FillRegistry(
                fillRegistryReq.getUserId(),
                fillRegistryReq.getFormId(),
                fillRegistryReq.getFillContent().toJSONString(),
                null,
                null,
                fillRegistryReq.getFileList(),
                "S"
        );
    }

    public static FillRegistryReq toFillRegistryReq(FillRegistry fillRegistry){
        return new FillRegistryReq(
                fillRegistry.getUserId(),
                fillRegistry.getFormId(),
                JSONObject.parseObject(fillRegistry.getFillContent()),
                fillRegistry.getFillTime(),
                fillRegistry.getAlterTime(),
                fillRegistry.getFileList(),
                fillRegistry.getCheckState()
        );
    }
}
