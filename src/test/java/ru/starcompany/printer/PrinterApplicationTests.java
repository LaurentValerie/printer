package ru.starcompany.printer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(
        scripts = {"classpath:sql/cleanDB.sql"},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
)
public class PrinterApplicationTests {

    @Test
    void contextLoads() {
    }

}
