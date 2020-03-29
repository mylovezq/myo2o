 package com.imooc.myo2o.dto;

 import com.imooc.myo2o.entity.LocalAuth;
 import com.imooc.myo2o.enums.LocalAuthStateEnum;
 import java.util.List;








 public class LocalAuthExecution
 {
   private int state;
   private String stateInfo;
   private int count;
   private LocalAuth localAuth;
   private List<LocalAuth> localAuthList;

   public LocalAuthExecution() {}

   public LocalAuthExecution(LocalAuthStateEnum stateEnum)
   {
     this.state = stateEnum.getState();
     this.stateInfo = stateEnum.getStateInfo();
   }

   public LocalAuthExecution(LocalAuthStateEnum stateEnum, LocalAuth localAuth)
   {
     this.state = stateEnum.getState();
     this.stateInfo = stateEnum.getStateInfo();
     this.localAuth = localAuth;
   }


   public LocalAuthExecution(LocalAuthStateEnum stateEnum, List<LocalAuth> localAuthList)
   {
     this.state = stateEnum.getState();
     this.stateInfo = stateEnum.getStateInfo();
     this.localAuthList = localAuthList;
   }

   public int getState() {
     return this.state;
   }

   public void setState(int state) {
     this.state = state;
   }

   public String getStateInfo() {
     return this.stateInfo;
   }

   public void setStateInfo(String stateInfo) {
     this.stateInfo = stateInfo;
   }

   public int getCount() {
     return this.count;
   }

   public void setCount(int count) {
     this.count = count;
   }

   public LocalAuth getLocalAuth() {
     return this.localAuth;
   }

   public void setLocalAuth(LocalAuth localAuth) {
     this.localAuth = localAuth;
   }

   public List<LocalAuth> getLocalAuthList() {
     return this.localAuthList;
   }

   public void setLocalAuthList(List<LocalAuth> localAuthList) {
     this.localAuthList = localAuthList;
   }
 }


