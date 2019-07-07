package com.lxy.demo.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author liuxinyun
 * @date 2019/7/7 19:23
 */
public class ResultData implements Serializable {

    private static final long serialVersionUID = -801269823505813519L;

    private static final Logger logger = LoggerFactory.getLogger(ResultData.class);

    // 业务状态：正常
    public static final int STATUS_NORMAL = 1;

    // 业务状态：异常
    public static final int STATUS_ERROR = 0;

    // 业务状态：默认正常
    private int status = STATUS_NORMAL;

    // 异常编码
    private int errorCode;

    // 异常信息
    private String errorMessage = "";

    // 消息体内容
    private Object body;

    public ResultData() {
        super();
    }

    /**
     * 带参构造函数
     *
     * @param status       状态
     * @param errorMessage 信息
     * @param errorCode    错误码
     */
    public ResultData(final int status, final String errorMessage, final int errorCode) {
        super();
        this.status = status;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * 带参构造函数(默认错误)
     *
     * @param errorMessage 信息
     * @param errorCode    错误码
     */
    public ResultData(final String errorMessage, final int errorCode) {
        super();
        this.status = ResultData.STATUS_ERROR;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * 带参构造函数(默认正确)
     *
     * @param body 数据
     */
    public ResultData(final Object body) {
        super();
        this.body = body;
        if (this.body == null) {
            logger.error("ResultData.body is null.");
        }
    }

    public Object getBody() {
        if (this.body == null) {
            return new HashMap<String, Object>();
        } else {
            return body;
        }
    }

    public ResultData setBody(Object body) {
        this.body = body;
        if (this.body == null) {
            logger.error("ResultData.body is null.");
        }
        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "status=" + status +
                ", errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", body=" + JSON.toJSONString(getBody()) +
                '}';
    }

    public String toJsonString() {

        return JSON.toJSONString(this);
    }

    public static ResultData successed() {
        return new ResultData();
    }

    public static ResultData successed(Object data) {
        ResultData resultData = new ResultData();
        resultData.setBody(data);
        return resultData;
    }

    public static ResultData successed(String mesg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setErrorMessage(mesg);
        resultData.setBody(data);
        return resultData;
    }

    public static ResultData failed(String mesg) {
        ResultData resultData = new ResultData();
        resultData.setErrorMessage(mesg);
        resultData.setStatus(STATUS_ERROR);
        return resultData;
    }

}
