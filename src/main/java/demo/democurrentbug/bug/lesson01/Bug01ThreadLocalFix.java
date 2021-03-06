package demo.democurrentbug.bug.lesson01;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Component
@RestController
@RequestMapping("/threadlocal")
public class Bug01ThreadLocalFix {

    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);

    @GetMapping("right")
    public Map wrong(@RequestParam("userId") Integer userId) {
        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        String before  = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息到ThreadLocal
        currentUser.set(userId);
        //设置用户信息之后再查询一次ThreadLocal中的用户信息
        String after  = Thread.currentThread().getName() + ":" + currentUser.get();
        //汇总输出两次查询结果
        Map result = new HashMap();
        result.put("before", before);
        result.put("after", after);

        //fix need to remove the value from ThreadLocal once the logic has been completed,
        // such that the thread which will be re-used will not get the incorrect value
        currentUser.remove();
        return result;
    }

}
