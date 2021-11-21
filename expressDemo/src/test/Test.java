package test;

import view.Views;

public class Test {
    public static void main(String[] args) {
        Views views = new Views();
        views.welcome();
        while (true){
            if (views.menu() == 0){
                break;
            }
        }
    }
}
