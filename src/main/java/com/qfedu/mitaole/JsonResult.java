package com.qfedu.mitaole;

public class JsonResult {

    /**
     * 状态码：0代表成功，1代表失败
     */
    private int code;

    private Object obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}