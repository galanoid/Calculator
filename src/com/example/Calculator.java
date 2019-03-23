package com.example;

import com.example.converters.RomanToArabic;
import com.example.operations.Divide;
import com.example.operations.Minus;
import com.example.operations.Multiply;
import com.example.operations.Plus;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        int choose = 1;
        Scanner sc = new Scanner(System.in);
        while (choose == 1) {
            System.out.print(
                            "1.Calculate\n" +
                            "0.Exit\n" +
                            "Select an action: ");
            choose = sc.nextInt();
            if (choose == 1 || choose == 0) {
                if (choose == 0) {
                    System.exit(0);
                } else {
                    System.out.print("Enter expression: ");
                    String s = sc.next();

                    char[] chars = s.toCharArray();

                    RomanToArabic convertFirstNum = new RomanToArabic(getFirstNum(chars).toString());
                    RomanToArabic convertSecondNum = new RomanToArabic(getSecondNum(chars).toString());

                    int firstNum = convertFirstNum.getNum();
                    int secondNum = convertSecondNum.getNum();

                    calculating(chars, firstNum, secondNum);
                }
            } else {
                System.err.println("Try again!");
                choose = 1;
            }
        }
    }

    private static StringBuilder getFirstNum(char[] chars) {
        StringBuilder firstStringNum = new StringBuilder();
        int firstIndex = 0;
        while (chars[firstIndex] != '+' || chars[firstIndex] != '-' ||
                chars[firstIndex] != '*' || chars[firstIndex] != '/') {
            firstStringNum.append(chars[firstIndex]);
            firstIndex++;
        }
        return firstStringNum;
    }

    private static StringBuilder getSecondNum(char[] chars) {
        StringBuilder secondStringNum = new StringBuilder();
        int lastIndex = chars.length - 1;
        while (chars[lastIndex] != '+'|| chars[lastIndex] != '-' ||
                chars[lastIndex] != '*' || chars[lastIndex] != '/') {
            secondStringNum.insert(0, chars[lastIndex]);
            lastIndex--;
        }
        return secondStringNum;
    }

    private static void calculating(char[] chars, int firstNum, int secondNum) {
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                Plus plus = new Plus();
                result = plus.operation(firstNum, secondNum);
                break;
            }
            if (chars[i] == '-') {
                Minus minus = new Minus();
                result = minus.operation(firstNum, secondNum);
                break;
            }
            if (chars[i] == '*') {
                Multiply multiply = new Multiply();
                result = multiply.operation(firstNum, secondNum);
                break;
            }
            if (chars[i] == '/') {
                Divide divide = new Divide();
                result = divide.operation(firstNum, secondNum);
            }
        }
        System.out.println("Your result: " + result);
    }
}





