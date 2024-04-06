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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
public class BasicController {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BasicController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Result> getTwoItems(List<Result> resultsFromQuery) throws Exception {

        List<Result> twoCodes = null;

        if (resultsFromQuery.size() < 2) {
            throw new Exception("require more sinppet codes items (< 2 items)");
        };

        // create code1 and code2
        Result code1 = resultsFromQuery.get(0);
        Result code2 = resultsFromQuery.get(1);

        // get only two(for now first two) items from resultsFromQuery
        // pick only 2
        twoCodes.add(code1);
        twoCodes.add(code2);

        // put them in the model
        return twoCodes;
    }
    List<Result> getTwoRandomItems(List<Result> results) {
        if (results.size() <= 2) {
            return results;
        } else {
            Random rand = new Random();
            int firstIndex = rand.nextInt(results.size());
            int secondIndex = firstIndex;
            while (firstIndex == secondIndex) {
                secondIndex = rand.nextInt(results.size());
            }
            return List.of(results.get(firstIndex), results.get(secondIndex));
        }
    }


    @GetMapping("/hello")
    @ResponseBody
    public ModelAndView hello() throws Exception {

        String templatePath = ".../.../resources/templates/hello.mustache";

        // all rows
        var result = this.jdbcTemplate.query(
                "select id, code from code_snippet",
                new DataClassRowMapper<>(Result.class)
        );

        List<Result> twoCodes = getTwoRandomItems(result);

        Map<String, Result> model = new HashMap<>();
//        model.put("results", result);
        model.put("code1", twoCodes.get(0));
        model.put("code2", twoCodes.get(1));
        ModelAndView mav = new ModelAndView("hello", model);

        return mav;
    }

    @PostMapping("/process-code")
    @ResponseBody
    public String processCode(@RequestBody String code) {
        // 서버에서 받은 코드를 처리하고 결과를 반환 (여기서는 간단히 그대로 반환)
        // query db to find the code with the same id from code snippet table
        // compare the status of the code from db with the code came from frontend
        // if content is selected -> insert

        return "Received code: " + code;
    }





}
