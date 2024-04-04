package io.github.seongjinhong_ca.code_rather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class BasicController {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BasicController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        record Result(UUID id, String code) {}
        var result = this.jdbcTemplate.query(
                "select id, code from code_snippet",
                new DataClassRowMapper<>(Result.class)
        );
        return ResponseEntity.ok(result.toString());
    }
}
