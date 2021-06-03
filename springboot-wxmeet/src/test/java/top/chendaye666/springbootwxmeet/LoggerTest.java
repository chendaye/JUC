package top.chendaye666.springbootwxmeet;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LoggerTest {
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test01(){
        logger.debug("debug.......");
        logger.info("info.....");
        logger.error("error....");
        // 输出变量
        String name = "chendaye666";
        String passwd = "lengo";
        logger.info("name="+name+" passwd="+passwd);
        logger.info("name = {} passwd = {}", name, passwd); // 占位符
    }

    @Test
    public void test02(){
        // lombok 的 注解 @Slf4j，直接注入 一个 log
//        log.debug("debug.......");
//        log.info("info.....");
//        log.error("error....");
    }
}
