package homework.expressDemo.test;


import homework.expressDemo.view.Views;

public class Test {
    public static void main(String[] args) throws Exception {
        Views views = new Views();
        views.welcome();
        while (true){
            if (views.menu() == 0){
                break;
            }
        }
    }
}
