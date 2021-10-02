package oop;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Solution #1: Queue+ Set (sliding window)
 */
/*
public class Logger {
    private class Pair<U, V> {
        U first;
        V second;
        Pair(U first, V second) { this.first = first; this.second = second; }
    }
    private Set<String> set;
    private List<Pair<String, Integer>> list;
    public Logger() {
        set = new HashSet<>();
        list = new LinkedList<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        // remove expired messages
        while (!list.isEmpty() && list.get(0).second + 10 <= timestamp) {
            String msg = list.get(0).first;
            list.remove(0);
            set.remove(msg);
        }
        // update list and set
        if (set.contains(message)) return false;
        set.add(message);
        list.add(new Pair<String, Integer>(message, timestamp));
        return true;
    }

}
*/

/**
 * Solution #2: HashMap
 */
class Logger {
    private HashMap<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            int lastPrintedTime = map.get(message);
            if (lastPrintedTime + 10 <= timestamp) {
                map.put(message, timestamp);
                return true;
            }
            return false;
        }
        map.put(message, timestamp);
        return true;
    }
}

