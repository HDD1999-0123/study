package demo;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
class Person {
    @MyAnnotation(value = "123")
    String name;

    public void print(String name){
        System.out.println(this.name);
    }
    public Person(String name){
        this.name = name;
    }
}
