package com.wt.springcloud.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author Administrator
 * @date 2020-05-17 下午 10:35
 * description
 */

@TableName(value = "payment")
public class Payment implements Serializable {
    @TableField(value = "id")
    private String id;

    @TableField(value = "serial")
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