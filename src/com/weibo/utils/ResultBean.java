package com.weibo.utils;


import com.weibo.eenum.ErrorCodeEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResultBean implements Serializable {
    //成功并且无需传参数时
    public static final ResultBean OK = new ResultBean(new HashMap<>());
    private static final long serialVersionUID = 1L;
    private static final int SUCCESS = 0;
    private static final String SUCCESS_MSG = "";
    //如果这些属性不用public修饰的话，就没有办法返回给前端
    //返回码
    public int error = 0;

    //消息提示
    public String errmsg = "";
    //数据
    public Map<String, Object> data = new HashMap<>();

    public ResultBean(Map<String, Object> data) {
        super();
        this.error = ResultBean.SUCCESS;
        this.errmsg = ResultBean.SUCCESS_MSG;
        this.data = data;
    }

    public ResultBean(ErrorCodeEnum errorCodeEnum) {
        this.error = errorCodeEnum.getError();
        this.errmsg = errorCodeEnum.getErrmsg();
    }

    public ResultBean(int error, String errmsg, Map<String, Object> data) {
        this.error = error;
        this.errmsg = errmsg;
        this.data = data;
    }
}