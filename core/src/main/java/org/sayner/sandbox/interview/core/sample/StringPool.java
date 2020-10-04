package org.sayner.sandbox.interview.core.sample;

import org.sayner.sandbox.interview.library.SampleI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * String — иммутабельный байтовый массив
 * StringBuilder — helper-класс для построения строк, не предоставляет гарантий синхронизации
 * StringBuffer — то же, что и StringBuilder, с synchronized методами
 */
public class StringPool implements SampleI {
    private final Logger LOGGER = LoggerFactory.getLogger(StringPool.class);

    public StringPool() {
    }

    @Override
    public void runExample() {
        stringPool();
        passwordStorage();
    }

    private void stringPool() {
        LOGGER.info("String pool is the pool in the memory only with strings");
        LOGGER.info("Let's compare wo strings with each other\n" +
                        "new String(\"hello\").intern() == new String(\"hello\").intern() equals {}\n" +
                        "but new String(\"hello\") == new String(\"hello\") equals {}",
                new String("hello").intern() == new String("hello").intern(),
                new String("hello") == new String("hello"));
    }

    private void passwordStorage() {
        LOGGER.info("It is better to storage password in char[] or byte[] rather String, " +
                "because String is always saved in string-pool and discloses password, " +
                "but array we can always delete\n{}",
                Arrays.toString("secret".toCharArray()));
    }
}
