package calculation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FireCalculatorController.class)
public class FireCalculatorControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldReturnCorrectResult() throws Exception {
        this.mockMvc.perform(get("/calcfin?ySPending=48000&swr=4")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("12000")));
    }

    @Test
    public void shouldReturnBadCallStatusCode() throws Exception {
        this.mockMvc.perform(get("/calcfin")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test (expected = NestedServletException.class)
    public void shouldReturnInvalidArgumentExceptionWhenSWRequalsZero() throws Exception {
        this.mockMvc.perform(get("/calcfin?ySPending=48000&swr=0")).andDo(print()).andExpect(status().is5xxServerError());
    }

}


