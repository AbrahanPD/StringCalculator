package org.example;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String numbers) {
        Matcher matcher = Pattern.compile("^//(.+)\n(.+)$", Pattern.DOTALL).matcher(numbers);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            numbers = matcher.group(2);
            numbers = numbers.replaceAll(Pattern.quote(delimiter), ",");
        }
        String [] numbersArray = numbers.split("[,;\n]");
        int result = 0;
        if (numbers.isEmpty()) return 0;
        for (String s : numbersArray) {
            int number = Integer.parseInt(s);
            if (number < 0) {
                throw new IllegalArgumentException("No se permiten números negativos");
            } else {
                result += number;
            }
        }
        return result;
    }
}
