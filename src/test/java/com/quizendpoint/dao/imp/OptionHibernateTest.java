package com.quizendpoint.dao.imp;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.quizendpoint.domain.Option;

@ActiveProfiles(value = "test")
@SpringBootTest
public class OptionHibernateTest {

	@Autowired
	OptionHibernate optionHibernate;
	
	Option opt1;
	Option opt2;
	List<Option> optlist;
	
	@BeforeEach
	void setup() {
		opt1 = new Option(1, "option1", 1, false);
		opt2 = new Option(2, "option2", 1, true);
		optlist = new ArrayList<>(); optlist.add(opt1);
	}
	
	
	@Test
	@Transactional
	void testGetOption() {
		optionHibernate.add(opt1);
		assertEquals(optlist, optionHibernate.getOption(1));
	}
	
	@Test
	@Transactional
	void testGetRightOption() {
		optionHibernate.add(opt2);
		assertEquals(opt2, optionHibernate.getRightOption(1));
	}
	
}
