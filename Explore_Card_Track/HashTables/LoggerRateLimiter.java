// LOgger Rate Limiter

// Design a logger system that receives a stream of messages along with their timestamps.
// Each unique message should be printed at most once every 10 seconds.

// That is, if a message arrives within 10 seconds of its previous log, you should not print it (return false).
// Otherwise, print it (return true).

// 🧠 Requirements:

// |Timestamp|Message|Action|Output||---------|-------|-----------------------------------------|-------||1|"foo"|
// First time seen→print|✅true||2|"bar"|
// First time seen→print|✅true||3|"foo"|
// Seen at t=1→
// less than 10 sec→skip|❌false||8|"bar"|
// Seen at t=2→
// less than 10 sec→skip|❌false||10|"foo"|
// Seen at t=1→
// less than 10 sec→skip|❌false||11|"foo"|
// Seen at t=1→10
// sec passed→
// print again|✅true|

import java.util.Map;

class Logger {
    private Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }

        int lastTime = map.get(message);
        if (timestamp - lastTime >= 10) {
            map.put(message, timestamp);
            return true;
        }

        return false;
    }
}

// Implement the Logger class:
// class Logger {
// public Logger() {}
// public boolean shouldPrintMessage(int timestamp, String message) {}
// }

// Logger logger = new Logger();

// logger.shouldPrintMessage(1, "foo"); // returns true
// logger.shouldPrintMessage(2, "bar"); // returns true
// logger.shouldPrintMessage(3, "foo"); // returns false
// logger.shouldPrintMessage(8, "bar"); // returns false
// logger.shouldPrintMessage(10, "foo"); // returns false
// logger.shouldPrintMessage(11, "foo"); // returns true
