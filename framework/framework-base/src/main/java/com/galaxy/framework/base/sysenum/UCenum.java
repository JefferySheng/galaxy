package com.galaxy.framework.base.sysenum;

public class UCenum {
    //性别
    public enum Sex{
        //男
        Male,
        //女
        Female
    }

    //学历
    public enum Record{
        //小学
        PrimarySchool,
        //初中
        JuniorMiddleSchool,
        //高中
        HighSchool,
        //本科
        Undergraduate,
        //研究生
        Graduate,
        //博士
        Doctor
    }

    //是否发送邮件
    public enum EmailStatus{
        //-1不发送
        Nosend,
        //0 待发送
        Waitsend,
        //1已发送
        Tosend
    }

    //是否发送短信
    public enum SmsStatus{
        //-1不发送
        Nosend,
        //0 待发送
        Waitsend,
        //1已发送
        Tosend
    }

    //信息读标志
    public enum ReadFlag{
        //N 未读
        Unread,
        //Y 已读
        Read
    }


    //组织架构状态
    public enum Status{
        //10：停用
        Inactive,
        //20：启用
        Active
    }

    //资源表状态
    public enum ResourceStatus{
        //N 不可用
        Unavailable,
        //Y 可用
        Available
    }

    //角色表状态
    public enum RoleStatus{
        //N 锁定状态
        Locked,
        //Y 激活状态
        Activated
    }

    //租户表状态
    public enum TenantStatus{
        //1-启用
        Active,
        //0-禁用
        Inactive
    }

    //用户信息表状态
    public enum UseStatus{
        //1-可用
        Active,
        //0-禁用
        Inactive,
        //-1-锁定
        Lock
    }
}
