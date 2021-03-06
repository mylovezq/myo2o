package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.LocalAuth;
import java.util.Date;
import org.apache.ibatis.annotations.Param;

public abstract interface LocalAuthDao
{
  public abstract LocalAuth queryLocalByUserNameAndPwd(@Param("userName") String paramString1, @Param("password") String paramString2);
  
  public abstract LocalAuth queryLocalByUserId(@Param("userId") long paramLong);
  
  public abstract int insertLocalAuth(LocalAuth paramLocalAuth);
  
  public abstract int updateLocalAuth(@Param("userId") Long paramLong, @Param("userName") String paramString1, @Param("password") String paramString2, @Param("newPassword") String paramString3, @Param("lastEditTime") Date paramDate);
}

