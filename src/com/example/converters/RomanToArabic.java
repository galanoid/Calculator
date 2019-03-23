package com.example.converters;

public class RomanToArabic {

    private int num;

    public RomanToArabic(String roman) {
        try {
            num = Integer.parseInt(roman);
        } catch (NumberFormatException e) {
            if (roman.length() == 0)
                throw new NumberFormatException("Empty string");

            roman = roman.toUpperCase();

            int i = 0;
            int arabic = 0;

            while (i < roman.length()) {
                char letter = roman.charAt(i);
                int number = letterToNumber(letter);

                if (number < 0)
                    throw new NumberFormatException("Is not roman number!");
                i++;

                if (i == roman.length())
                    arabic += number;
                else {
                    int nextNumber = letterToNumber(roman.charAt(i));

                    if (nextNumber > number) {
                        arabic += (nextNumber - number);
                        i++;
                    } else {
                        arabic += number;
                    }
                }
            }
            num = arabic;
        }
    }

    private int letterToNumber(char letter) {
        switch (letter) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }

    public int getNum() {
        return num;
    }
}
