package demo.democurrentbug.test;

import lombok.extern.slf4j.Slf4j;
import sun.net.www.http.HttpClient;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Slf4j
public class StreamTest {

    public static void main(String[] args) {

        List<String> a = Arrays.asList("a","b","c");

        for(String s : a) {
            log.info("item {}", s);
        }

        a.forEach(s -> log.info("item {}", s));

        a.stream().forEach(s -> log.info("item {}", s));

        Supplier<String> xxx = () -> {
            System.out.println("xxxx");
            return "xxxx";
        };

        log.info(xxx.get());



        Consumer println = System.out::println;
        Consumer consumerLog = e -> {
            log.info(e.toString());
        };

        println.andThen(consumerLog).accept("abcdefg");



    }
}
