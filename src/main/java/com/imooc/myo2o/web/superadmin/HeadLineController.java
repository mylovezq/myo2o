package com.imooc.myo2o.web.superadmin;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.imooc.myo2o.dto.HeadLineExecution;
import com.imooc.myo2o.entity.HeadLine;
import com.imooc.myo2o.enums.HeadLineStateEnum;
import com.imooc.myo2o.service.HeadLineService;
import com.imooc.myo2o.util.HttpServletRequestUtil;

import java.io.DataInput;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Controller
@RequestMapping({"/superadmin"})
@ResponseBody
public class HeadLineController {
    @Autowired
    private HeadLineService headLineService;

    @RequestMapping(value = {"/listheadlines"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    private Map<String, Object> listHeadLines(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        List<HeadLine> list = new ArrayList();
        try {
            Integer enableStatus = Integer.valueOf(HttpServletRequestUtil.getInt(request, "enableStatus"));

            HeadLine headLine = new HeadLine();
            if (enableStatus.intValue() > -1) {
                headLine.setEnableStatus(enableStatus);
            }
            list = this.headLineService.getHeadLineList(headLine);
            modelMap.put("rows", list);
            modelMap.put("total", Integer.valueOf(list.size()));
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }

    @PostMapping({"/addheadline"})
    private Map<String, Object> addHeadLine(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        ObjectMapper mapper = new ObjectMapper();

        String headLineStr = HttpServletRequestUtil.getString(request, "headLineStr");
        if (headLineStr == null){
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "headLineStr为空");
            return modelMap;
        }
        System.out.println(headLineStr);

        HeadLine headLine = null;
        MultipartFile headLineImg = null;

        try {
            headLine = (HeadLine) mapper.readValue(headLineStr, HeadLine.class);

        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }


        try {

            MultipartHttpServletRequest multipartRequest = null;
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                multipartRequest = (MultipartHttpServletRequest) request;
                headLineImg = multipartRequest.getFile("headTitleManagementAdd_lineImg");
            } else {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", "未能收到图片上传流！");
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        if ((headLine != null) && (headLineImg != null)) {
            try {
                headLine.setLineName(headLine.getLineName() == null ? null : URLDecoder.decode(headLine.getLineName(), "UTF-8"));
                HeadLineExecution ae = this.headLineService.addHeadLine(headLine, headLineImg);

                if (ae.getState() == HeadLineStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", Boolean.valueOf(true));
                } else {
                    modelMap.put("success", Boolean.valueOf(false));
                    modelMap.put("errMsg", ae.getStateInfo());
                }
            } catch (Exception e) {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "请输入头条信息");
        }
        return modelMap;
    }

    @RequestMapping(value = {"/modifyheadline"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    private Map<String, Object> modifyHeadLine(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        HeadLine headLine = null;
        String headLineStr = HttpServletRequestUtil.getString(request, "headLineStr");


        try {
            headLine = (HeadLine) mapper.readValue(headLineStr, HeadLine.class);
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        MultipartFile headLineImg = null;
        MultipartHttpServletRequest multipartRequest = null;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            multipartRequest = (MultipartHttpServletRequest) request;
            headLineImg = multipartRequest.getFile("headTitleManagementEdit_lineImg");
        }

        if ((headLine != null) && (headLine.getLineId() != null)) {
            try {
                headLine.setLineName(headLine.getLineName() == null ? null :
                        URLDecoder.decode(headLine.getLineName(), "UTF-8"));
                HeadLineExecution ae = this.headLineService.modifyHeadLine(headLine, headLineImg);

                if (ae.getState() == HeadLineStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", Boolean.valueOf(true));
                } else {
                    modelMap.put("success", Boolean.valueOf(false));
                    modelMap.put("errMsg", ae.getStateInfo());
                }
            } catch (Exception e) {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "请输入头条信息");
        }
        return modelMap;
    }

    @RequestMapping(value = {"/removeheadline"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    private Map<String, Object> removeHeadLine(Long headLineId) {
        Map<String, Object> modelMap = new HashMap();
        if ((headLineId != null) && (headLineId.longValue() > 0L)) {
            try {
                HeadLineExecution ae = this.headLineService.removeHeadLine(headLineId.longValue());
                if (ae.getState() == HeadLineStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", Boolean.valueOf(true));
                } else {
                    modelMap.put("success", Boolean.valueOf(false));
                    modelMap.put("errMsg", ae.getStateInfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "请输入头条信息");
        }
        return modelMap;
    }

    @RequestMapping(value = {"/removeheadlines"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    private Map<String, Object> removeHeadLines(String headLineIdListStr) {
        Map<String, Object> modelMap = new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, new Class[]{Long.class});

        List<Long> headLineIdList = null;
        try {
            headLineIdList = (List) mapper.readValue(headLineIdListStr, javaType);
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
        }
        if ((headLineIdList != null) && (headLineIdList.size() > 0)) {
            try {
                HeadLineExecution ae = this.headLineService.removeHeadLineList(headLineIdList);
                if (ae.getState() == HeadLineStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", Boolean.valueOf(true));
                } else {
                    modelMap.put("success", Boolean.valueOf(false));
                    modelMap.put("errMsg", ae.getStateInfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "请输入区域信息");
        }
        return modelMap;
    }
}


