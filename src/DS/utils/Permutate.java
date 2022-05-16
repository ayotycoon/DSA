package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutate {

    public static List<String> getAll(String[] words) {
        List<String> ans = new ArrayList<>();
        if (words.length == 0) {
            ans.add("");
            return ans;
        }

        for (int i = 0; i < words.length; i++) {
            var curr = words[i];
            String[] wordsMod = new String[words.length - 1];

            int v = 0;

            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                wordsMod[v] = words[j];
                v++;
            }


            var temp = getAll(wordsMod).stream().map(x -> curr + x).collect(Collectors.toList());
            ans.addAll(temp);

        }
        return ans;
    }

}
