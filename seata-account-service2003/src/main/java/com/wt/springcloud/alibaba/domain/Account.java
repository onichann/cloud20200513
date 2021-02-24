package com.wt.springcloud.alibaba.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
  *@author wutong
  *@date 2021/2/24 17:15
  *introduction 
 */
    
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_account")
public class Account implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 总额度
     */
    @TableField(value = "total")
    private Long total;

    /**
     * 已用余额
     */
    @TableField(value = "used")
    private BigDecimal used;

    /**
     * 剩余可用额度
     */
    @TableField(value = "residue")
    private BigDecimal residue;

    private static final long serialVersionUID = 1L;

    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_TOTAL = "total";

    public static final String COL_USED = "used";

    public static final String COL_RESIDUE = "residue";
}