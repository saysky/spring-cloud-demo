package com.liuyanzhao.cloud.web.vo;

import lombok.Data;

/**
 * @author 言曌
 * @date 2018/7/29 下午11:44
 */

@Data
public class ResultVO<T> {

    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //返回的具体内容
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
