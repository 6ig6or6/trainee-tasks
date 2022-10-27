package org.example.multithreading;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CommonStorage {
    private static final Logger logger = LoggerFactory.getLogger(CommonStorage.class);
    private static Map<String, String> threadInfoByThreadName = new HashMap<>();
    private static final Lock LOCK = new ReentrantLock();

    public static void saveThreadInfo() {
        LOCK.lock();
        try {
            Thread thread = Thread.currentThread();
            ThreadInfo threadInfo = new ThreadInfo();
            threadInfo.setTimeBefore(LocalTime.now());
            ThreadInfo.incrementCount();
            try {
                //to see difference between timeBefore and timeAfter
                Thread.sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                logger.error("An exception occurred ", e);
                throw new RuntimeException(e);
            }
            threadInfo.setTimeAfter(LocalTime.now());
            threadInfoByThreadName.put(thread.getName(), threadInfo.toString());
        } finally {
            LOCK.unlock();
        }
    }

    public static void printMapData() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error("An exception occurred ", e);
            throw new RuntimeException(e);
        }
        threadInfoByThreadName.forEach((key, value) -> logger.info(key + " " + value));
    }

    public static void refreshData() {
        threadInfoByThreadName = new HashMap<>();
        ThreadInfo.resetCount();
    }

    @Setter
    @Getter
    @ToString
    private static class ThreadInfo {
        @ToString.Include
        private static int count;
        private LocalTime timeBefore;
        private LocalTime timeAfter;

        public static void incrementCount() {
            count++;
        }

        public static void resetCount() {
            count = 0;
        }
    }
}
