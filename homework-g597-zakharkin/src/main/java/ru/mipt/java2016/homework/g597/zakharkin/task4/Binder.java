package ru.mipt.java2016.homework.g597.zakharkin.task4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ilya on 19.12.16.
 */
public class Binder {
    public static String setParameterPositions(List<String> args, String expression) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder varNameBuilder = new StringBuilder();
        Set<String> argSet = new HashSet(args);
        int paramCount = 0;
        for (int i = 0; i < expression.length(); ++i) {
            if (Character.isAlphabetic(expression.charAt(i))) {
                while (i < expression.length() && (Character.isAlphabetic(expression.charAt(i)) || Character.isDigit(expression.charAt(i)))){
                    varNameBuilder.append(expression.charAt(i));
                    i += 1;
                }
                stringBuilder.append('$' + Integer.toString(paramCount++));
            } else {
                stringBuilder.append(expression.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static String setParamaeterPositions(List<String> args, String expression) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder varNameBuilder = new StringBuilder();
        int paramCount = 0;
        for (int i = 0; i < expression.length(); ++i) {
            if (Character.isAlphabetic(expression.charAt(i))) {
                int j = i;
                while (Character.isAlphabetic(expression.charAt(i))) {
                    varNameBuilder.append(expression.charAt(i));
                    j += 1;
                }
                stringBuilder.append('$' + Integer.toString(paramCount));
            }
        }
    }

}
