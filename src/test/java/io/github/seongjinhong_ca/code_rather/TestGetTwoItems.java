package io.github.seongjinhong_ca.code_rather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestGetTwoItems {

//    @Autowired
//    private MockMvc mockMvc;

    private BasicController basicController;
    public TestGetTwoItems(BasicController basicController){
        this.basicController = basicController;
    }


    @Test
    public void testGetTwoItems() throws Exception {

        UUID mockUuid1 = UUID.randomUUID();
        UUID mockUuid2 = UUID.randomUUID();

        // Mock model created and setting
        Result code1 = new Result(mockUuid1,"hello");
        Result code2 = new Result(mockUuid2, "hi");

        List<Result> codes = new ArrayList<>();

        codes.add(code1);
        codes.add(code2);

        List<Result> twoCodesResult = basicController.getTwoItems(codes);
        /*
        // using MockMvc, call hello endpoint and send Mock model
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                        .flashAttr("model", model))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
        */
        /*
        // using MockMvc, call hello endpoint and send Mock model
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andReturn();
        * */

        /*
        // get model using MockMvc and check the mock model
        ModelMap returnedModel = (ModelMap) result.getModelAndView().getModel();
        String value1Result = (String) returnedModel.get("cod1");
        String value2Result = (String) returnedModel.get("code2");
        */

        // compare the result and expected
        assert (twoCodesResult.get(0).code()).equals(codes.get(0).code());
        assert (twoCodesResult.get(1).code()).equals(codes.get(1).code());
    }
}
