package com.wt.springcloud.entity;

import java.io.Serializable;

/**
 * @author Administrator
 * @date 2020-05-17 下午 10:35
 * description
 */

public class Payment implements Serializable {

    private String id;

    private String serial;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_SERIAL = "serial";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}