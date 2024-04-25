package lambda;

import java.util.*;

public class Lambda3 {

    public static void main(String[] args) {
        //Отсортировать список строк с помощью лямбда-выражения?
        String[] stringArray = new String[5];
        stringArray[0] = "5";
        stringArray[1] = "3";
        stringArray[2] = "4";
        stringArray[3] = "1";
        stringArray[4] = "2";
        List<String> list = new ArrayList<>(List.of(stringArray));
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<String> sort(List<String> list) {
        list.sort(String::compareTo);
        return list;
    }
}
