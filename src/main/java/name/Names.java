package name;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Marek");
        names.add("Aleksandra");
        names.add("Marta");
        names.add("Jakub");
        names.add("Bartosz");

    }

    private static String getName (String marta, List<String> names){
//        for (String name : names) {
//            if (name.equals(marta))
//                return name;
//        }

        List<String> s = names.stream().
                filter(name -> name.contains("s")).
                collect(Collectors.toList());
        System.out.println(s);
        return null;
    }

}
