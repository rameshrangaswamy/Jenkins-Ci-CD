
package com.jen.sau;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private HelloController helloController;

    @Mock
    private Model model;

   /* @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }*/
   @Test
   public void testPlayGameWithNull(){
       String theChoice = null;
       String pageNm = helloController.playGame(theChoice,model);
       System.out.println(pageNm);
       assertEquals("index", pageNm);
   }
    @Test
    public void testPlayGameWithRock(){
        String theChoice = "rock";
        String pageNm = helloController.playGame(theChoice,model);
        //assertEquals("win",pageNm);

    }
    @Test
    public void testPlayGameWithPaper(){
        String theChoice = "paper";
        helloController.playGame(theChoice,model);
    }
    @Test
    public void testPlayGameWithScissors(){
        String theChoice = "scissors";
        helloController.playGame(theChoice,model);
    }


}



