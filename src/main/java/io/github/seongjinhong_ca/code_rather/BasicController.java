package io.github.seongjinhong_ca.code_rather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BasicController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        var result = this.jdbcTemplate.queryForMap("select * from code_snippet");
      return ResponseEntity.ok(result.toString());
    }
}
