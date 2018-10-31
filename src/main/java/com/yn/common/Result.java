package com.yn.common;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Result extends JSONObject {

    private static final Logger log = LoggerFactory.getLogger(Result.class);

    public Result() {
        try {
            this.put("msg", "");
            this.put("code", "");
            this.put("count", "");
            this.put("data", "");
        } catch (JSONException e) {
            log.error("Result constructor error:{}", e.getMessage());
        }
    }

    public Result(Integer code, String msg, Integer count, Object data) {
        try {
            this.put("status", code);
            this.put("msg", msg);
            this.put("count", count);
            this.put("data", data);
        } catch (JSONException e) {
            log.error("Result constructor error:{}", e.getMessage());
        }
    }

    public void addCode(Integer code) {
        try {
            this.put("code", code);
        } catch (JSONException e) {
            log.error("Result.addCode error:{}", e.getMessage());
        }
    }

    public void addMsg(String msg) {
        try {
            this.put("msg", msg);
        } catch (JSONException e) {
            log.error("Result.addMsg error:{}", e.getMessage());
        }
    }

    public void addCount(Integer count) {
        try {
            this.put("count", count);
        } catch (JSONException e) {
            log.error("Result.addCount error:{}", e.getMessage());
        }
    }

    public void addData(Object data) {
        if (data == null) return;
        try {
            this.put("data", data);
        } catch (JSONException e) {
            log.error("Result.addData error:{}", e.getMessage());
        }
    }


}
