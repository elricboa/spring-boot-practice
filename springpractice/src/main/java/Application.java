import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;


/**
 * @author shentongzhou on 16/6/6
 */
@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        jdbcTemplate.execute("DROP TABLE IF USER EXISTS ");
        jdbcTemplate.execute("CREATE TABLE USER ("+"id SERIAL, name VARCHAR (255))");
        List<String> names = Arrays.asList("lynn condition","007 condition");
        jdbcTemplate.batchUpdate("INSERT INTO user(name) VALUES (?)", (BatchPreparedStatementSetter) names);
    }
}
