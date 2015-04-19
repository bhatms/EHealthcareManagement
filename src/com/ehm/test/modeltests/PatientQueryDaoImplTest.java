package com.ehm.test.modeltests;

import java.sql.SQLException;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ehm.db.impl.PatientQueryDao;
import com.ehm.db.impl.PatientQueryDaoImpl;
import com.ehm.db.model.PatientQuery;

public class PatientQueryDaoImplTest implements BaseTest {

	final static Logger logger = Logger.getLogger(PatientQueryDaoImplTest.class);
	private PatientQueryDao patqueObj;

	@Before
	public void beforeSetting() {
		patqueObj = new PatientQueryDaoImpl();

	}

	@After
	public void afterSetting() {

	}

	@Test
	public void testpatientQueryInvalidId() {
		try {
			List<PatientQuery> testPatientQueryList = patqueObj.patientQuery(Integer.valueOf("-9999"));
			if (testPatientQueryList == null) {
				Assert.assertNull(testPatientQueryList);
			} else{
				Assert.assertTrue("No result found for invalid patient id ", testPatientQueryList.isEmpty());
			}

		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testPatientQuery() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testPatientQuery() failed due to" + e);
		}
	}

	@Test
	public void testpatientQueryValidId() {
		try {
			List<PatientQuery> testPatientQueryList = patqueObj.patientQuery(Integer.valueOf("5"));
			if (testPatientQueryList != null && testPatientQueryList.isEmpty()) {
				Assert.assertNull("No datafound",testPatientQueryList);
			} else {
				Assert.assertNotNull("Query found for this patient", testPatientQueryList.get(0).getQueryDescription());
			}

		} catch (ClassNotFoundException e) {
			Assert.fail(logger.getClass()
					+ ":method testPatientQuery() failed due to" + e);
		} catch (SQLException e) {
			Assert.fail(logger.getClass()
					+ ":method testPatientQuery() failed due to" + e);
		}
	}
}