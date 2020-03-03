/*    */ package com.imooc.myo2o.cache;
/*    */ 
/*    */ import redis.clients.jedis.JedisPool;
/*    */ import redis.clients.jedis.JedisPoolConfig;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JedisPoolWriper
/*    */ {
/*    */   private JedisPool jedisPool;
/*    */   
/*    */   public JedisPoolWriper(JedisPoolConfig poolConfig, String host, int port)
/*    */   {
/*    */     try
/*    */     {
/* 18 */       this.jedisPool = new JedisPool(poolConfig, host, port);
/*    */     } catch (Exception e) {
/* 20 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   public JedisPool getJedisPool() {
/* 25 */     return this.jedisPool;
/*    */   }
/*    */   
/*    */   public void setJedisPool(JedisPool jedisPool) {
/* 29 */     this.jedisPool = jedisPool;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\cache\JedisPoolWriper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */