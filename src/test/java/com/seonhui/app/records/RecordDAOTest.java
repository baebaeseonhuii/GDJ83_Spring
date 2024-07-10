package com.seonhui.app.records;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.seonhui.app.DefaultTest;

public class RecordDAOTest extends DefaultTest {

	@Autowired
	private RecordDAO recordDAO;

	private RecordDTO recordDTO;

	@BeforeClass
	public static void beforeClass() throws Exception {

	}

	@Before
	public void before() throws Exception {
		this.recordDTO = new RecordDTO();
		recordDTO.setAc_num("1720419680702");
		recordDTO.setMoney(-5000);
		recordDTO.setType_of_transaction("출금");
		recordDTO.setAccount_u("1720399341967");

	}

	@Test
	public void addTest() throws Exception {
		int result = recordDAO.add(recordDTO);
		assertEquals(1, result);
	}

	@Test
	public void updateTest() throws Exception {
		int result = recordDAO.update(recordDTO);
		assertNotEquals(0, result);
	}
}
