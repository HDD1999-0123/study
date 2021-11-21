package homework;


import java.util.*;

/**
 * 3、分别用Comparable和Comparator两个接口对下列四位同学的成绩做降
 * 序排序，如果成绩一样，在成绩排序的基础上按照年龄由小到大排序。
 * 姓名       年龄      分数
 * 贾宝玉      14      88.5
 * 林黛玉      13      90.5
 * 史湘玉      13      85
 * 薛宝钗      15      91
 */
public class demo3  {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        List<Student2> student2s = new ArrayList<>();
        /*
        使用comparable
         */
        students.add(new Student("贾宝玉",14,88.5));
        students.add(new Student("林黛玉",13,90.5));
        students.add(new Student("史湘玉",13,80.5));
        students.add(new Student("薛宝钗",15,91));
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println("--------------------------");
        /*
        使用comparator
         */
        student2s.add(new Student2("贾宝玉",14,88.5));
        student2s.add(new Student2("林黛玉",13,90.5));
        student2s.add(new Student2("史湘玉",13,80.5));
        student2s.add(new Student2("薛宝钗",15,91));
        Collections.sort(student2s, new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                if (o1.getScore() < o2.getScore()){
                    return 1;
                }else if(o1.getScore() == o2.getScore()){
                    if (o1.getAge() > o2.getAge()){
                        return 1;
                    }else if(o1.getAge() == o2.getAge()){
                        return 0;
                    }
                }
                return -1;
            }
        });
        for (Student2 student2 : student2s) {
            System.out.println(student2.toString());
        }
    }
}
class Student2{
    private String name;
    private Integer age;
    private double score;

    public Student2(String name, Integer age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
class Student implements Comparable<Student>{
    private String name;
    private Integer age;
    private double score;

    public Student(String name, Integer age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student s) {
        if (this.score < s.score){
            return 1;
        }else if(this.score == s.score){
            if (this.age>s.age){
                return 1;
            }else if (this.age == s.age){
                return 0;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}