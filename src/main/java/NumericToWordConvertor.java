/**
 * Created by avis on 30/04/17.
 */
public class NumericToWordConvertor {
    private static final String[] specialNames = {
            "",
            " thousand",
            " million",
            " billion"
    };

    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    //Convert 999 to 0
    private String convertLessThanOneThousand(int number) {
        String current;

        if (number % 100 < 20) {
            current = numNames[number % 100];
            number /= 100;
        } else {
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames[number] + " hundred" + current;
    }

    public String convert(int number) {

        if (number == 0) {
            return "zero";
        }

        String prefix = "";

        //negative numbers
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }

        String word = "";
        int place = 0;

        do {
            int n = number % 1000;
            if (n != 0) {
                String token = convertLessThanOneThousand(n);
                word = token + specialNames[place] + word;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + word).trim();
    }
}

