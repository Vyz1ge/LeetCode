package LeetCode;
/* #easy
Даны две строки s и t. Верните true, если s является подпоследовательностью t, иначе верните false.
Подпоследовательность строки — это новая строка, которая формируется из исходной строки путем удаления некоторых (возможно, ни одного) символов без нарушения относительных позиций оставшихся символов. (например, "ace" является подпоследовательностью "abcde", тогда как "aec" не является).
*/

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(go("q", "aaqqbqqqwewewecc"));
    }

    public static boolean go(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        boolean is = false;
        String[] arrayS = s.split(""); //символы, которые нужны
        String[] arrayT = t.split(""); //есть ли тут эти символы?
        List<String> arrayListT = new ArrayList<>();
        for (int i = 0; i < arrayT.length; i++) {
            arrayListT.add(arrayT[i]);
        }
        int counter = 0;
        while (true) {
            if (arrayListT.isEmpty()) {
                if (counter == arrayS.length) {
                    is = true;
                    break;
                } else {
                    is = false;
                    break;
                }
            }
            for (int i = 0; i < arrayListT.size(); i++) {
                if (arrayS[counter].equals(arrayListT.get(i))) {
                    if (counter + 1 == arrayS.length) {
                        return true;
                    } else {
                        counter++;
                    }
                    arrayListT.remove(i);
                    break;
                } else {
                    arrayListT.remove(i);
                    break;
                }
            }
        }
        return is;
    }
}
