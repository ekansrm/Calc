package main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Context {
    private static Context ourInstance = new Context();
    private Map<String, Double> map = new HashMap<>();
    private Deque<Double> stack = new ArrayDeque<>();

    private Context() {
    }

    public static Context getInstance() {
        return ourInstance;
    }

    public Double getValue(String key) {
        Double d = map.get(key);
        return d == null ? Double.NaN : d;
    }

    public void setContext(String key, Double value) {
        map.put(key, value);
    }

    public void setContext(String key, String value) {
        setContext(key, Double.valueOf(value));
    }

    public void pushStack(Double d) {
        stack.push(d);
    }

    public Double popStack() {
        return stack.pop();
    }
}
