package demo.democurrentbug.test;

@FunctionalInterface
public interface HelloFunctional {
    String msg(String hello);

    default String hi(String hi) {
        return "hi!" + hi;
    }
}
