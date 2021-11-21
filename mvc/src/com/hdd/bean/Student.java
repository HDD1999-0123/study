package com.hdd.bean;


//实体类包-主要存放和数据库对应的实体类
// 类名=表名
//列名=属性名
//实体类需要包含:属性，构造(无参，全参构造)，setter/getter
//属于Model(M)
public class Student {

    private Integer stuid;
    private String stuname;
    private Integer age;
    private Integer sex;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Student(Integer stuid, String stuname, Integer age, Integer sex) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.age = age;
        this.sex = sex;
    }

    public Student() {
    }
}
