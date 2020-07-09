package java.lang;
//双亲委派，沙箱隔离机制
/*
由于java的jre中的rt.jar中已经存在String这个类，这样boostrap就会找到这个类
java为了安全，采用沙箱隔离机制隔离与rt.jar相同的类的加载，因此有同名的就会报错
 */
//public class String {
//    /*错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
//    public static void main(String[] args)
//    否则 JavaFX 应用程序类必须扩展javafx.application.Application*/
//    public static void main(String[] args) {
//        System.out.println("hello");
//    }
//}
