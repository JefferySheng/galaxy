package com.galaxy.framework.core.constant;

/**
 * @author Chensj
 * @date 2018-1-12
 **/
public enum ErrorStatus {


    // 1xx Informational

    /**
     * 系统内部错误
     */
    INTERNAL_SERVER_ERROR(10000, "系统错误"),
    /**
     * 参数错误
     */
    ILLEGAL_ARGUMENT(10001, "参数错误"),
    /**
     * 业务错误
     */
    SERVICE_EXCEPTION(10002, "业务错误"),
    /**
     * 非法的数据格式，参数没有经过校验
     */
    ILLEGAL_DATA(10003, "数据错误"),

    MULTIPART_TOO_LARGE(1004, "文件太大"),
    /**
     * 非法状态
     */
    ILLEGAL_STATE(10005, "非法状态"),
    /**
     * 缺少参数
     */
    MISSING_ARGUMENT(10006, "缺少参数"),
    /**
     * 非法访问
     */
    ILLEGAL_ACCESS(10007, "非法访问,没有认证"),
    /**
     * 权限不足
     */
    UNAUTHORIZED(10008, "权限不足"),

    /**
     * 错误的请求
     */
    METHOD_NOT_ALLOWED(10009, "不支持的方法"),


    /**
     * 参数错误
     */
    ILLEGAL_ARGUMENT_TYPE(10010, "参数类型错误"),

    /**
     * 没有admin权限的必须选择租户
     */
    HAVE_NO_ADMIN(20001, "没有admin权限的必须选择租户"),

    /**
     * 执行定时任务失败
     */
    OPERATE_QUARTZ_ERROR(30001, "执行定时任务失败"),
    /**
     * 创建定时任务失败
     */
    CREATE_QUARTZ_ERROR(30003, "创建定时任务失败"),
    /**
     * 更新定时任务失败
     */
    UPDATE_QUARTZ_ERROR(30004, "更新定时任务失败"),
    /**
     * 暂停定时任务失败
     */
    SUSPEND_QUARTZ_ERROR(30005, "暂停定时任务失败"),
    /**
     * 重新执行定时任务失败
     */
    RE_OPERATE_QUARTZ_ERROR(30006, "恢复定时任务失败"),
    /**
     * 删除定时任务失败
     */
    DELETE_QUARTZ_ERROR(30007, "删除定时任务失败"),

    /**
     * getCronTrigger异常，请检查qrtz开头的表，是否有脏数据
     */
    GET_CRON_TRIGGER_ERROR(30002, "getCronTrigger异常，请检查qrtz开头的表，是否有脏数据"),

    /**
     * 上传文件失败，请核对七牛配置信息
     */
    UPLOAD_EXCEPTION(40001, "上传文件失败，请核对七牛配置信息"),
    /**
     * 七牛上传出错
     */
    QINIU_UPLOAD_EXCEPTION(40002, "七牛上传出错"),
    /**
     * 用户名或密码错误
     */
    USER_NAME_PASSWORD_ERROR(50001, "用户名或密码错误");

    private final int value;

    private final String message;


    ErrorStatus(int value, String message) {
        this.value = value;
        this.message = message;
    }


    /**
     * Return the integer value of this status code.
     */
    public int value() {
        return this.value;
    }

    /**
     * Return the reason phrase of this status code.
     */
    public String getMessage() {
        return this.message;
    }

}
