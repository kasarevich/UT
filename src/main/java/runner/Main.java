package runner;

import triangle.Triangle;

public class Main {


    public static void main(String[] args) {

        Triangle tr = new Triangle((	Double.POSITIVE_INFINITY - 1), (	Double.POSITIVE_INFINITY -1), (	Double.POSITIVE_INFINITY -1));
        System.out.println(tr.checkTriangle());
        System.out.println(tr.getMessage());
        System.out.println(tr.detectTriangle());
    }
}
