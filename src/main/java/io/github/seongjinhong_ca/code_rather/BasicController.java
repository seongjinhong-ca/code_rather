package io.github.seongjinhong_ca.code_rather;

import com.samskivert.mustache.Mustache;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

@Controller
public class BasicController {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BasicController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(Model model){

        String templatePath = ".../.../resources/templates/hello.mustache";

        record Result(UUID id, String code) {}
        // all rows
        List<Result> results = this.jdbcTemplate.query(
                "select id, code from code_snippet",
                new DataClassRowMapper<>(Result.class)
        );

        public List<Result> getTwoItems(List<Result> resultsFromQuery){
            List<Result> twoCodes;
            // if (resultsFromQuery.length < 2) {error}
            // get only two(for now first two) items from resultsFromQuery
            // create code1 and code2
            // put them in the model
            return twoCodes;
        }

        // model that will be sent to frontend
        Map<String, Object> code1 = new HashMap<>();
        Map<String, Object> code2 = new HashMap<>();
        // pick only 2
        code1.put("code1", results.get(0));

        code2.put("code2", results.get(1));

        // putting into model
        model.addAllAttributes(code1);
        model.addAllAttributes(code2);

        return "hello";
    }


}
