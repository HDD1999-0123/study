package demo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName:
 * @Descripton:内省
 * @author: hedd
 */
public class IntrospectionTest {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clazz = Student.class;
        Student s = (Student) clazz.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        System.out.println(propertyDescriptors.length);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            if (propertyDescriptor.getWriteMethod()!=null){
                /*获取set方法*/
                Method writeMethod = propertyDescriptor.getWriteMethod();
                /*执行set方法*/
                writeMethod.invoke(s,"123");
            }
        }
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            //获取一个get方法
            Method readMethod = propertyDescriptor.getReadMethod();
            //执行get方法
            System.out.println(readMethod.invoke(s));
        }
    }
}
