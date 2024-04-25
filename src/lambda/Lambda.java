package lambda;

interface Operationable {
    int calculate(int x, int y);
}
public class Lambda {
    public static void main(String[] args) {
        System.out.println(new Operationable() {
            @Override
            public int calculate(int x, int y) {
                return x+y;
            }
        }.calculate(3,5));
    }
}