package com.quizendpoint.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.quizendpoint.dao.imp.OptionHibernate;
import com.quizendpoint.domain.Option;
import com.quizendpoint.exception.IdNotFoundException;

@ExtendWith(MockitoExtension.class)
public class OptionServiceTest {
	
	@InjectMocks
	OptionService optionService;
	
	@Mock
	OptionHibernate optionHibernate;
	
	Option opt1;
	Option opt2;
	List<Option> optList;
	
	@BeforeEach
	void setup() {
		opt1 = new Option(1, "opt1", 1, false);
		opt2 = new Option(2, "right", 1, true);
		optList = new ArrayList<>();
		optList.add(opt1); optList.add(opt2);
	}
	
	@Test
	void testGetRightOption() {
		when(optionHibernate.getRightOption(1)).thenReturn(opt2);
		
		assertEquals(optionService.getRightoption(1), opt2);
	}
	
	@Test
	void testOptionbyquestion() throws IdNotFoundException {
		when(optionHibernate.getOption(1)).thenReturn(optList);
		
		assertEquals(optionService.getoptionbyquestion(1), optList);
	}
	
//	@Test
//	void testOptionbyquestion_fail() throws IdNotFoundException {
//		when(optionHibernate.getOption(3)).then(new IdNotFoundException("Id not found"));
//		
//		assertEquals(optionService.getoptionbyquestion(1), optList);
//	}
	
}
