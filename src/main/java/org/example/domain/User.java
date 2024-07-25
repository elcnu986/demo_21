package org.example.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author elcnu
 * @since 2024-07-25
 */
@Getter
@Setter
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("dept_id")
    private Long deptId;

    @TableField("user_name")
    private String userName;

    @TableField("nick_name")
    private String nickName;

    @TableField("user_type")
    private String userType;

    @TableField("email")
    private String email;

    @TableField("phonenumber")
    private String phonenumber;

    @TableField("sex")
    private String sex;

    @TableField("avatar")
    private String avatar;

    @TableField("password")
    private String password;

    @TableField("status")
    private String status;

    @TableField("del_flag")
    private String delFlag;

    @TableField("login_ip")
    private String loginIp;

    @TableField("login_date")
    private Date loginDate;

    @TableField("create_by")
    private String createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField("update_by")
    private String updateBy;

    @TableField("update_time")
    private Date updateTime;

    @TableField("remark")
    private String remark;
}
