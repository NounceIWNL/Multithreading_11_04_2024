package lambda;

public class DefaultDemo implements Example {
    public static void main(String[] args) {
        Example example = new Example() {
            @Override
            public int process(int a) {
                return 0;
            }
        };
        example.show();
    }

    @Override
    public int process(int a) {
        return 0;
    }

    @Override
    public void show() {
        Example.super.show();
    }
}

interface Example {
    int process(int a);

    default void show() {
        System.out.println("default show()");
    }
}