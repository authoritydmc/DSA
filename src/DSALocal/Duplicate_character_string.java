package DSA;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Duplicate_character_string {
    public static void main(String[] args) {
        String s="Alpha-Beta-GAmma Boys";

        Map< Character, Long > result = s
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));


        result.forEach((k, v) -> {
            if (v > 1) {
                System.out.println(k + " : " + v);
            }
        });
//
        Integer [] nums =new Integer[]{1,2,3,1,3,3};
        Map<Integer,Long> res= Arrays.stream(nums).collect(Collectors.groupingBy(num->num,Collectors.counting()));

        res.forEach((k,v)->
        {
            System.out.println("K-> "+k+" counting -> "+v);
        });

        System.out.println("Now printing only duplicate");
//        Set<Map.Entry<Integer, Long>> entries = res.entrySet();
//
//        Stream<Map.Entry<Integer,Long>> entryStream=entries.stream();

        res.entrySet().stream().map(Map.Entry::getKey).filter(key->res.get(key)>1).forEach(key->System.out.println(key+" is repeated: "+res.get(key)));

        boolean ans=res.entrySet().stream().map(Map.Entry::getKey).anyMatch(key->res.get(key)>1);
        System.out.println(ans);
    }
}
