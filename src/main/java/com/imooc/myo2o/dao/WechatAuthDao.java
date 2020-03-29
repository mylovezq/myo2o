package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.WechatAuth;

public abstract interface WechatAuthDao
{
  public abstract WechatAuth queryWechatInfoByOpenId(String paramString);
  
  public abstract int insertWechatAuth(WechatAuth paramWechatAuth);
  
  public abstract int deleteWechatAuth(Long paramLong);
}

