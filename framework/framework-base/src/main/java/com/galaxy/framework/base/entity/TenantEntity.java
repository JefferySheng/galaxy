package com.galaxy.framework.base.entity;

import java.io.Serializable;

/**
 * @author chensj
 */
public interface TenantEntity extends Serializable {
    /**
     * 获取ID
     *
     * @return
     */
    Long getId();

    /**
     * 获取管理员ID
     *
     * @return
     */
    Long getAdministrator();
}
