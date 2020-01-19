package com.galaxy.framework.tenancy;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.galaxy.framework.base.entity.TenancyEntity;
import com.galaxy.framework.base.service.impl.BaseServiceImpl;
import com.galaxy.framework.security.utils.SecurityUtils;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author chensj
 */
public class TenancyServiceImpl<T extends TenancyEntity> extends BaseServiceImpl<T> {

    @Override
    public boolean insert(T entity) {
        if (entity.getTenantId() == null) {
            Long tenantId = SecurityUtils.getTenantId();
            entity.setTenantId(tenantId);
        }
        return super.insert(entity);
    }

    @Override
    public boolean deleteById(Serializable id) {

        Long tenantId = SecurityUtils.getTenantId();
        if (tenantId != null && tenantId != 0) {
            T t = this.selectById(id);
            Assert.isTrue(t.getTenantId().longValue() == tenantId.longValue(), "操作失败，所属租户错误");
        }
        return super.deleteById(id);
    }

    @Override
    public boolean updateById(T entity) {

        Long tenantId = SecurityUtils.getTenantId();
        if (tenantId != null && entity.getTenantId() != null && tenantId != 0) {
            Assert.isTrue(entity.getTenantId().longValue() == tenantId.longValue(), "操作失败，所属租户错误");
        }
        return super.updateById(entity);
    }

    /**
     * 自动添加租户ID字段参数
     *
     * @param wrapper
     */
    protected EntityWrapper addTenantCondition(EntityWrapper wrapper) {
        if (wrapper == null) {
            return null;
        }
        Long tenantId = SecurityUtils.getTenantId();
        if (tenantId != null && tenantId != 0) {
            wrapper.eq("tenant_id", tenantId);
        }
        return wrapper;
    }
}
