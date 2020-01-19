package com.galaxy.framework.security.utils;

import com.galaxy.framework.security.userdetail.User;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * @author aaron.pan
 * @date 2018/5/24
 */
public class SecurityUtils {

    public static Long getTenantId() {
        User user = getPrincipal();
        if (user != null) {
            return user.getTenantId();
        }
        return null;
    }

    public static String getUsername() {
        User user = getPrincipal();
        if (user != null) {
            return user.getUsername();
        }
        return null;
    }

    public static User getPrincipal() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            if (principal instanceof User) {
                return (User) principal;
            } else {
                throw new IllegalStateException("获取用户数据失败");
            }
        }
        return null;
    }

    public static boolean hasRole(String role) {
        User user = getPrincipal();
        if (user != null) {
            if (user.getRoles().contains(role)) {
                return true;
            }

        }
        return false;
    }

    public static Long getUserId() {
        User user = getPrincipal();
        if (user != null) {
            return user.getId();
        }
        return null;
    }

    public static boolean hasAuthority(String authority) {
        User user = getPrincipal();
        if (user != null) {
            if (user.getAuthorities().contains(authority)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasResource(String resource) {
        User user = getPrincipal();
        if (user != null) {
            if (user.getResources().contains(resource)) {
                return true;
            }
        }
        return false;
    }

}
