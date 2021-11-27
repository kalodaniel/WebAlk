package hu.me.iit.Computer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import hu.me.iit.Computer.Repository.Computer;
import hu.me.iit.Computer.Repository.ComputerRepository;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ComputerRepository computerRepository;
	
	@Test
	public void shouldNoMainPage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is4xxClientError());
	}

	@Test
	public void shouldReturnComputer() throws Exception {
		//Given
		Computer computer = new Computer(1L,"Asus",2);
		computerRepository.save(computer);
		//When, Then
		this.mockMvc.perform(get("/computers/getAllComputers")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string("[{\"id\":1,\"manufacturer\":\"Asus\",\"age\":2}]"));
	}
}
