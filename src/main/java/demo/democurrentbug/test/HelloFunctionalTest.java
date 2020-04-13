package demo.democurrentbug.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Slf4j
public class HelloFunctionalTest {

    public static int i = 0;

    public static void main(String[] args) {

        HelloFunctional hello = e -> "Hello!" + e;

        log.info(hello.msg("Peter"));

        log.info(hello.hi("Tom"));


        NormalInterface n = e -> "Hello! Normal: " + e;

        log.info(n.hello("yes!"));

        AtomicInteger ai = new AtomicInteger();

        IntStream.rangeClosed(1,1000000).parallel().forEach(
                e-> {
                    log.info("process: " + e);
                    i = i + 1;
                    ai.incrementAndGet();
                }
        );

        log.info("Atomic:" + ai.toString());
        log.info("normal i:" + i);
    }
}
