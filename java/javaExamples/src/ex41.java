import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ex41 {
    public static void main(String[] args) throws ClassNotFoundException {
        // Class 클래스 : 클래스의 정보를 담고 있는 클래스
        //             : 멤버변수, 멤버함수, 어노테이션 정보 등등...
        // 클래스 정보를 가져오는 방법 1
        Class cl = String.class;
        // 방법 2
        String str = new String();
        Class c2 = str.getClass();
        // 방법 3
        Class c3 = Class.forName("java.lang.String");

        Constructor[] cons = c3.getConstructors();
        for(Constructor con : cons) {
            System.out.println(con);
        }
        System.out.println("-----------");

        Method[] methods = c3.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("-----------");

        Annotation[] annotations = c3.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
    }
}
