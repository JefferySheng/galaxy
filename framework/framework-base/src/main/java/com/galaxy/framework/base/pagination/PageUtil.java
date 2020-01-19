package com.galaxy.framework.base.pagination;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chensj
 */
public class PageUtil {
    /**
     * 获取分页参数
     * @param <T>
     * @return
     */
    public <T> Page<T> getPagination() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return PaginationUtils.buildFromRequest(request);
    }
}
