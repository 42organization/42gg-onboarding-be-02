package com.gg.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DBConnectionTest implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DBConnectionTest.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 데이터베이스에서 값을 조회하여 출력하는 예시
        String sql = "SELECT * FROM your_table_name"; // your_table_name을 실제 테이블 이름으로 변경
        System.out.println("column1: ");
        jdbcTemplate.query(sql, (rs, rowNum) -> {
            String column1 = rs.getString("column1"); // column1을 실제 컬럼명으로 변경
            String column2 = rs.getString("column2"); // column2을 실제 컬럼명으로 변경
            System.out.println("column1: " + column1 + ", column2: " + column2);
            return null;
        });
    }
}
