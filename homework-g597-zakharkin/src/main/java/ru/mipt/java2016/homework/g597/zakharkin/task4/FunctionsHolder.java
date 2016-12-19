package ru.mipt.java2016.homework.g597.zakharkin.task4;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilya on 19.12.16.
 */
public class FunctionsHolder {
    private static final Map<String, Integer> BASIC_FUNCTIONS;
    static {
        Map<String, Integer> aMap = new HashMap<>();
        aMap.put("sin", 1);
        aMap.put("cos", 1);
        aMap.put("tg", 1);
        aMap.put("sqrt", 1);
        aMap.put("pow", 2);
        aMap.put("abs", 1);
        aMap.put("sign", 1);
        aMap.put("log", 2);
        aMap.put("log2", 1);
        aMap.put("max", 1);
        aMap.put("min", 1);
        BASIC_FUNCTIONS = Collections.unmodifiableMap(aMap);
    }
    @Autowired
    private BillingDao dbms;

    public Pair<String, Integer> getFunctionBodyAndValence(Authentication account, String funcName) {

        return dbms.getValenceAndBody(account.getName(), funcName);
    }
}
