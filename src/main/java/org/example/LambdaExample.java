package org.example;


@FunctionalInterface
interface MathOperation {
    int operation(int i, int j);
}

public class LambdaExample {
    public static void main(String[] args) {
        MathOperation m = (i, j) -> i + j;
        int x = m.operation(5, 5);
        System.out.println(x);
    }

}
