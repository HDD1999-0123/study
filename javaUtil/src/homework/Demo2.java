package homework;

import com.sun.scenario.effect.impl.sw.java.JSWPhongLighting_DISTANTPeer;

/**
 * 2. String s="name=王五 age=18 classNum=1101”;
 * 将上面的字符串中包含的信息存放到 Student（里面有 name，age，
 * classNum 三个属性）的对象中:
 */
public class Demo2 {
    public static void main(String[] args) {
        String s="name=王五 age=18 classNum=1101";
        Student student = new Student();
        //以空格进行分割，得到各个等式
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            //以等号进行分割，相当于获取key，value
            String[] s3 = s2.split("=");
            //进行比对，然后分别赋值
            if("name".equals(s3[0])){
                student.setName(s3[1]);
            }
            if("age".equals(s3[0])){
                student.setAge(Integer.parseInt(s3[1]));
            }
            if("classNum".equals(s3[0])){
                student.setClassNum(Integer.parseInt(s3[1]));
            }
        }
        System.out.println(student);
    }
}

/**
 * 创建Student类
 */
class Student{
    private String name;
    private Integer age;
    private  Integer classNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classNum=" + classNum +
                '}';
    }
}