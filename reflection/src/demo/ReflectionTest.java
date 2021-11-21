package demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName:
 * @Descripton:反射
 * @author: hedd
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("demo.Person");
        //获取构造方法数组
        Constructor[] constructors = clazz.getConstructors();
        System.out.println(constructors.length);
        //获取指定构造方法
        Constructor constructor = clazz.getConstructor(String.class);
        //获取属性所有权限的构造方法数组
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(fields.length);
        System.out.println(clazz.getDeclaredField("name").getName());
        /*获取指定属性*/
        Field name = clazz.getDeclaredField("name");
        /*根据类型获取属性上的注解*/
        MyAnnotation annotation = name.getAnnotation(MyAnnotation.class);
        System.out.println(annotation);
        /*拿到注解的参数*/
        String value = annotation.value();
        System.out.println(value);
        /*参数为true，表示忽略访问权限检查（可以访问任何权限的方法）*/
        name.setAccessible(true);
        //通过获取的类创建对象
//        Person p = (Person) clazz.newInstance();
        /*使用有参构造方法来创建对象*/
        String[] arr = new String[]{"name"};
        Person p = (Person) constructor.newInstance(arr);
        System.out.println(p.name);
        /*利用反射给属性赋值，参数1对象，参数2为值*/
        name.set(p,value);
        System.out.println(p.name);
        /*获取方法数组*/
        Method[] methods = clazz.getMethods();
        System.out.println(methods.length);
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        /*获取任意权限的方法数组*/
        Method[] declaredMethods = clazz.getDeclaredMethods();
        /*获取指定方法*/
        Method print = clazz.getDeclaredMethod("print",String.class);
        /*执行方法，参数1要调用方法的对象，参数2传递的参数列表*/
        print.invoke(p,"123");
    }
}
