package io.github.seongjinhong_ca.code_rather;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class TestHello {


    @Mock
    private JdbcTemplate jdbcTemplate;
    private MockMvc mockMvc;

//    @InjectMocks
    BasicController basicController;
    public TestHello(BasicController basicController){
        this.basicController = basicController;
    }

    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(basicController).build();
    }

    @Test
    public void testHello(){

        UUID mockUuid1 = UUID.randomUUID();
        UUID mockUuid2 = UUID.randomUUID();

        // Mock model created and setting
        Result code1 = new Result(mockUuid1,"hello");
        Result code2 = new Result(mockUuid2, "hi");

        setUp();
        List<Result> dummyResults = new ArrayList<>();
        dummyResults.add(code1);
        dummyResults.add(code2);

//        // Mock jdbcTemplate의 동작 설정
//        when(jdbcTemplate.query(anyString(), Result.class)).thenReturn(dummyResults);

//        // create Mock model
//        ModelMap model = new ModelMap();
//        model.addAttribute("name", "John Doe");
//        model.addAttribute("age", 30);

//        basicController.hello();
    }

}
