package com.hello;

public enum Days {

   MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

   private final int id;

   Days(int id) {
      this.id = id;
   }

   private static final Days[] cachedList = Days.values();

   public static Days valueOf(int i){
      if(i < 1 ||  7 < i ){
         throw new IllegalArgumentException("Day cannot be outside the range of 1 - 7 inclusively");
      }
      return cachedList[i-1];
   }
}
