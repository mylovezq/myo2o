package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.WechatAuth;

public abstract interface WechatAuthDao
{
  public abstract WechatAuth queryWechatInfoByOpenId(String paramString);
  
  public abstract int insertWechatAuth(WechatAuth paramWechatAuth);
  
  public abstract int deleteWechatAuth(Long paramLong);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\WechatAuthDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */