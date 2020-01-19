package com.galaxy.framework.base.entity;

import com.baomidou.mybatisplus.annotations.TableField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chensj
 */
public class PublicTenancyEntity {
    @TableField("tenant_ids")
    private String tenantIds;

    public String getTenantIds() {
        return tenantIds;
    }

    public void setTenantIds(String tenantIds) {
        this.tenantIds = tenantIds;
    }

    public List<String> getTenantIdList() {
        if (tenantIds != null && !"".equals(tenantIds)) {
            return Arrays.asList(tenantIds.split(","));
        }
        return new ArrayList<>();
    }
}
