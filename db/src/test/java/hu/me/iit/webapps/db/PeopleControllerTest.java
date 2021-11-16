package hu.me.iit.webapps.db;


import org.junit.jupiter.api.Test;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import hu.me.iit.webapps.db.Repository.People;
import hu.me.iit.webapps.db.Repository.PeopleRepository;

import javax.transaction.Transactional;


@SpringBootTest
@AutoConfigureMockMvc
class PeopleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void shouldNoMainPage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //ez ez tudja-e
    //@Test
    public void shouldReturnPeoples() throws Exception {
        //GIVEN
        People peopleModel = new People(1L, "Pista", 12);
        peopleRepository.save(peopleModel);

        //WHEN THEN

        this.mockMvc.perform(get("/people"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name", is("Pista")));

    }

    @Test
    public void shouldReturnPeoples2() throws Exception {
        //GIVEN
    	People peopleModel = new People(2L, "Bela", 19);
        peopleRepository.save(peopleModel);

        //WHEN THEN

        this.mockMvc.perform(get("/people"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"Bela\",\"age\":19}]"));
    }

}