package com.blob.demo.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@RunWith(SpringRunner.class)
public class HomeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void requestHomeViewSuccessfully() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(header().doesNotExist("hello"))
				.andExpect(view().name("home")).andExpect(content().string(containsString("Welcome to ...")))
				.andDo(log());
	}

	@Test
	public void requestHomeViewHeaderValidationSuccessfully() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(header().string("taco", "funny")).andDo(log());
	}

}
