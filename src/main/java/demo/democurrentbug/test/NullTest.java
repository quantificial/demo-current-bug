package demo.democurrentbug.test;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Slf4j
public class NullTest {

    public static void main(String[] args) {

        NullTest t = new NullTest();

        Integer i = 10;
        Integer j = null;

         Optional.ofNullable(i)
                .map(t::add)
                .map(e -> t.add2(e,10))
                .ifPresent(e->log.info(e.toString()));
                ;




        log.info(i.toString());
    }

    int add (int i) {
        return i+1;
    }

    int add2(int i, int j) {
        return i+j;
    }
}
