package com.lugan.jvm;

import java.util.Random;

//收集虚拟机的最大和初始堆内存
//-Xms1024m -Xmx1024m -XX:+PrintGCDetails --->设置vm参数
//java.lang.OutOfMemoryError: Java heap space
public class JVMInfo {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().maxMemory()/(1024*1024));//JAVA虚拟机试图使用的内存总量默认为物理内存的1/4
//        System.out.println(Runtime.getRuntime().totalMemory()/(1024*1024));//返回java虚拟机最大内存总量
        String str = "www.lugan.com" ;
        //[GC (Allocation Failure) [PSYoungGen: 2371K->312K(2560K)] 7452K->6389K(9728K), 0.0021406 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //[Full GC (Allocation Failure) Exception in thread "main" [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 3559K->3539K(7168K)] 3559K->3539K(9216K), [Metaspace: 3185K->3185K(1056768K)], 0.0099768 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
       while (true)
           str +=str+new Random().nextInt(800000000)+new Random().nextInt(800000000);
//        for (int i = 0; i <30 ; i++) {
//            str +=str+"aaa";
//        }
//        System.out.println(str);
    }
}
