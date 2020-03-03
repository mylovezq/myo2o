/*     */ package com.imooc.myo2o.web.superadmin;
/*     */ 
/*     */ import com.fasterxml.jackson.databind.JavaType;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import com.fasterxml.jackson.databind.type.TypeFactory;
/*     */ import com.imooc.myo2o.dto.AreaExecution;
/*     */ import com.imooc.myo2o.entity.Area;
/*     */ import com.imooc.myo2o.enums.AreaStateEnum;
/*     */ import com.imooc.myo2o.service.AreaService;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/superadmin"})
/*     */ public class AreaController
/*     */ {
/*  32 */   Logger logger = LoggerFactory.getLogger(AreaController.class);
/*     */   @Autowired
/*     */   private AreaService areaService;
/*     */   
/*     */   @GetMapping({"/listarea"})
/*     */   @ResponseBody
/*     */   private Map<String, Object> listAreas() {
/*  39 */     this.logger.info("=====star======");
/*  40 */     long startTime = System.currentTimeMillis();
/*  41 */     Map<String, Object> modelMap = new HashMap();
/*  42 */     List<Area> list = new ArrayList();
/*     */     try {
/*  44 */       list = this.areaService.getAreaList();
/*  45 */       modelMap.put("rows", list);
/*  46 */       modelMap.put("total", Integer.valueOf(list.size()));
/*     */     } catch (Exception e) {
/*  48 */       e.printStackTrace();
/*  49 */       modelMap.put("success", Boolean.valueOf(false));
/*  50 */       modelMap.put("errMsg", e.toString());
/*     */     }
/*  52 */     this.logger.error("test error!");
/*  53 */     long endTime = System.currentTimeMillis();
/*  54 */     this.logger.debug("costTime:[{}ms]", Long.valueOf(endTime - startTime));
/*  55 */     this.logger.info("==========end==========");
/*  56 */     return modelMap;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/addarea"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   private Map<String, Object> addArea(String areaStr, HttpServletRequest request)
/*     */   {
/*  63 */     Map<String, Object> modelMap = new HashMap();
/*  64 */     ObjectMapper mapper = new ObjectMapper();
/*  65 */     Area area = null;
/*     */     try {
/*  67 */       area = (Area)mapper.readValue(areaStr, Area.class);
/*     */       
/*  69 */       area.setAreaName(area.getAreaName() == null ? null : 
/*  70 */         URLDecoder.decode(area.getAreaName(), "UTF-8"));
/*  71 */       area.setAreaDesc(area.getAreaDesc() == null ? null : 
/*  72 */         URLDecoder.decode(area.getAreaDesc(), "UTF-8"));
/*     */     } catch (Exception e) {
/*  74 */       modelMap.put("success", Boolean.valueOf(false));
/*  75 */       modelMap.put("errMsg", e.toString());
/*  76 */       return modelMap;
/*     */     }
/*  78 */     if ((area != null) && (area.getAreaName() != null)) {
/*     */       try {
/*  80 */         AreaExecution ae = this.areaService.addArea(area);
/*  81 */         if (ae.getState() == AreaStateEnum.SUCCESS.getState()) {
/*  82 */           modelMap.put("success", Boolean.valueOf(true));
/*     */         } else {
/*  84 */           modelMap.put("success", Boolean.valueOf(false));
/*  85 */           modelMap.put("errMsg", ae.getStateInfo());
/*     */         }
/*     */       } catch (RuntimeException e) {
/*  88 */         modelMap.put("success", Boolean.valueOf(false));
/*  89 */         modelMap.put("errMsg", e.toString());
/*  90 */         return modelMap;
/*     */       }
/*     */     }
/*     */     else {
/*  94 */       modelMap.put("success", Boolean.valueOf(false));
/*  95 */       modelMap.put("errMsg", "请输入区域信息");
/*     */     }
/*  97 */     return modelMap;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/modifyarea"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   private Map<String, Object> modifyArea(String areaStr, HttpServletRequest request)
/*     */   {
/* 104 */     Map<String, Object> modelMap = new HashMap();
/* 105 */     ObjectMapper mapper = new ObjectMapper();
/* 106 */     Area area = null;
/*     */     try {
/* 108 */       area = (Area)mapper.readValue(areaStr, Area.class);
/* 109 */       area.setAreaName(area.getAreaName() == null ? null : 
/* 110 */         URLDecoder.decode(area.getAreaName(), "UTF-8"));
/* 111 */       area.setAreaDesc(area.getAreaDesc() == null ? null : 
/* 112 */         URLDecoder.decode(area.getAreaDesc(), "UTF-8"));
/*     */     } catch (Exception e) {
/* 114 */       modelMap.put("success", Boolean.valueOf(false));
/* 115 */       modelMap.put("errMsg", e.toString());
/* 116 */       return modelMap;
/*     */     }
/* 118 */     if ((area != null) && (area.getAreaId() != null)) {
/*     */       try {
/* 120 */         AreaExecution ae = this.areaService.modifyArea(area);
/* 121 */         if (ae.getState() == AreaStateEnum.SUCCESS.getState()) {
/* 122 */           modelMap.put("success", Boolean.valueOf(true));
/*     */         } else {
/* 124 */           modelMap.put("success", Boolean.valueOf(false));
/* 125 */           modelMap.put("errMsg", ae.getStateInfo());
/*     */         }
/*     */       } catch (RuntimeException e) {
/* 128 */         modelMap.put("success", Boolean.valueOf(false));
/* 129 */         modelMap.put("errMsg", e.toString());
/* 130 */         return modelMap;
/*     */       }
/*     */     }
/*     */     else {
/* 134 */       modelMap.put("success", Boolean.valueOf(false));
/* 135 */       modelMap.put("errMsg", "请输入区域信息");
/*     */     }
/* 137 */     return modelMap;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/removearea"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   private Map<String, Object> removeArea(Long areaId) {
/* 143 */     Map<String, Object> modelMap = new HashMap();
/* 144 */     if ((areaId != null) && (areaId.longValue() > 0L)) {
/*     */       try {
/* 146 */         AreaExecution ae = this.areaService.removeArea(areaId.longValue());
/* 147 */         if (ae.getState() == AreaStateEnum.SUCCESS.getState()) {
/* 148 */           modelMap.put("success", Boolean.valueOf(true));
/*     */         } else {
/* 150 */           modelMap.put("success", Boolean.valueOf(false));
/* 151 */           modelMap.put("errMsg", ae.getStateInfo());
/*     */         }
/*     */       } catch (RuntimeException e) {
/* 154 */         modelMap.put("success", Boolean.valueOf(false));
/* 155 */         modelMap.put("errMsg", e.toString());
/* 156 */         return modelMap;
/*     */       }
/*     */     }
/*     */     else {
/* 160 */       modelMap.put("success", Boolean.valueOf(false));
/* 161 */       modelMap.put("errMsg", "请输入区域信息");
/*     */     }
/* 163 */     return modelMap;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/removeareas"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   private Map<String, Object> removeAreas(String areaIdListStr) {
/* 169 */     Map<String, Object> modelMap = new HashMap();
/* 170 */     ObjectMapper mapper = new ObjectMapper();
/* 171 */     JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, new Class[] { Long.class });
/*     */     
/* 173 */     List<Long> areaIdList = null;
/*     */     try {
/* 175 */       areaIdList = (List)mapper.readValue(areaIdListStr, javaType);
/*     */     } catch (Exception e) {
/* 177 */       modelMap.put("success", Boolean.valueOf(false));
/* 178 */       modelMap.put("errMsg", e.toString());
/*     */     }
/* 180 */     if ((areaIdList != null) && (areaIdList.size() > 0)) {
/*     */       try {
/* 182 */         AreaExecution ae = this.areaService.removeAreaList(areaIdList);
/* 183 */         if (ae.getState() == AreaStateEnum.SUCCESS.getState()) {
/* 184 */           modelMap.put("success", Boolean.valueOf(true));
/*     */         } else {
/* 186 */           modelMap.put("success", Boolean.valueOf(false));
/* 187 */           modelMap.put("errMsg", ae.getStateInfo());
/*     */         }
/*     */       } catch (RuntimeException e) {
/* 190 */         modelMap.put("success", Boolean.valueOf(false));
/* 191 */         modelMap.put("errMsg", e.toString());
/* 192 */         return modelMap;
/*     */       }
/*     */     }
/*     */     else {
/* 196 */       modelMap.put("success", Boolean.valueOf(false));
/* 197 */       modelMap.put("errMsg", "请输入区域信息");
/*     */     }
/* 199 */     return modelMap;
/*     */   }
/*     */ }

