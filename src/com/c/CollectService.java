package com.c;

import java.util.Hashtable;

public class CollectService {
	
   private static Hashtable<String, ServiceBank> serviceMap  = new Hashtable<String, ServiceBank>();

   public static ServiceBank getService(String service) throws CloneNotSupportedException {
      ServiceBank cachedShape = serviceMap.get(service);
      return (ServiceBank) cachedShape.clone();
   }

   public static void loadCache() {
      Deposit dp = new Deposit();
      dp.setId("deposite");
      serviceMap.put(dp.getId(),dp);

      Withdraw wd = new Withdraw();
      wd.setId("withdraw");
      serviceMap.put(wd.getId(),wd);
      
      Interest in = new Interest();
      in.setId("interest");
      serviceMap.put(in.getId(),in);
   }
}