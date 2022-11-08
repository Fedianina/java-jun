package olga.fedianina.hw17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AdditionalTask {
    public static void main(String[] args) {

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout the point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        // TODO: Используя Stream API: создать Map<String, Long>, где
        //      String - слово
        //      Long - частота встречаемости
        //  В мапу должны войти только первые 10 по частоте встречаемости слов.

        String [] textArray = text.split(" ");
        Map<String, Long> map = Arrays.stream(textArray).collect(Collectors.toMap(
                elem ->elem,
                elemValue ->1L,
                (elem1, elem2) -> elem1+elem2));
        System.out.println(map);
        Map<String, Long> map1 = map.entrySet().stream()
                .sorted((elem1, elem2) -> (int)(elem2.getValue() - elem1.getValue()))
                .limit(10)
                .collect(Collectors.toMap(
                        elem ->elem.getKey(),
                        elemValue -> elemValue.getValue()));

        System.out.println(map1);

    }
}

