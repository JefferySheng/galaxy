package com.galaxy.framework.tenancy;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.galaxy.framework.base.entity.PublicTenancyEntity;
import com.galaxy.framework.base.service.impl.BaseServiceImpl;
import com.galaxy.framework.security.utils.SecurityUtils;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author chensj
 */
public class PublicTenancyServiceImpl<T extends PublicTenancyEntity> extends BaseServiceImpl<T> {

    @Override
    public boolean insert(T entity) {
        Long tenantId = SecurityUtils.getTenantId();
        if (entity.getTenantIds() == null && tenantId != null) {
            String tenantIds = tenantId.toString();
            entity.setTenantIds(tenantIds);
        }
        return super.insert(entity);
    }

    @Override
    public boolean deleteById(Serializable id) {
        Long tenantId = SecurityUtils.getTenantId();
        if (tenantId != null && tenantId != 0) {
            T t = this.selectById(id);
            Assert.isTrue(t.getTenantIdList().contains(tenantId.toString()), "操作失败，所属租户错误");
            Assert.isTrue(t.getTenantIdList().size() > 1, "操作失败，公共数据不能删除");
        }
        return super.deleteById(id);
    }

    @Override
    public boolean updateById(T entity) {
        Long tenantId = SecurityUtils.getTenantId();
        if (tenantId != null && entity.getTenantIds() != null && tenantId != 0) {
            Assert.isTrue(entity.getTenantIdList().contains(tenantId.toString()), "操作失败，所属租户错误");
            Assert.isTrue(entity.getTenantIdList().size() > 1, "操作失败，公共数据不能删除");
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
            wrapper.andNew("FIND_IN_SET({0},tenant_ids)", tenantId.toString());
        }
        return wrapper;
    }

}
