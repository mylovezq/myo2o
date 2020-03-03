package com.imooc.myo2o.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request, String name) {
        try {
            return Integer.decode(request.getParameter(name)).intValue();
        } catch (Exception e) {
        }
        return -1;
    }

    public static long getLong(HttpServletRequest request, String name) {
        try {
            return Long.valueOf(request.getParameter(name)).longValue();
        } catch (Exception e) {
        }
        return -1L;
    }

    public static Double getDouble(HttpServletRequest request, String name) {
        try {
            return Double.valueOf(request.getParameter(name));
        } catch (Exception e) {
        }
        return Double.valueOf(-1.0D);
    }

    public static Boolean getBoolean(HttpServletRequest request, String name) {
        try {
            return Boolean.valueOf(request.getParameter(name));
        } catch (Exception e) {
        }
        return Boolean.valueOf(false);
    }

    public static String getString(HttpServletRequest request, String name) {
        try {
            String result = request.getParameter(name);
            if (result != null) {
                result = result.trim();
                return result;
            }
            if ("".equals(result)) {
                return null;
            }

        } catch (Exception e) {
        }
        return null;
    }
}

