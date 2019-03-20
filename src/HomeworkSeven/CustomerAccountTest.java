package HomeworkSeven;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;



class CustomerAccountTest {
	private CustomerAccount account;
	
	@Mock
	private CustomerAccount spyAccount;
	
	@Mock
	private CustomerAccountDAO cad;
	
	@BeforeEach
	void setUp() throws Exception {
		account = new CustomerAccount();
		spyAccount = spy(account); // real class to spy
		cad = mock(CustomerAccountDAO.class); // mocked class
	}
	
	// This is a good naming convention resource for the method names:
	// https://www.petrikainulainen.net/programming/testing/writing-clean-tests-naming-matters/
	
	@Test
	void test_createNewAccount_shouldThrowNoAccountCreatedExceptionOnAdd() throws SQLException, NoAccountCreatedException {
		// Author: Kevin
		// test data to passs into method
		String name = "John";
		String phone = "123-456-7890";
		
		when(cad.newAcctNumber(anyString(), anyString())).thenThrow(new SQLException());
		spyAccount.setCustomerAccountDAO(cad);
		
		try {
			spyAccount.createNewAccount(name, phone);
			fail("The exception wasn't thrown.");
		} catch (NoAccountCreatedException nae) {
			String expected = String.format("Account for %s at %s not created", name, phone);
			String actual = nae.getMessage();
			assertEquals(expected, actual, "The exception messages do not match");
		}	
	}
	
	@Test
	void test_createNewAccount_shouldThrowNoAccountCreatedExceptionOnSave() throws SQLException, NoAccountCreatedException {
		// Author: Ramnath
		// test data to passs into method
		String name = "John";
		String phone = "123-456-7890";
		
		// this will be very similar to the above unit test
		// all you have to do mock the exception response for cao.saveAccount rather than cao.newAcctNumber
		assertEquals(1,1, "Still needs to be implemented");
	}
	
	@Test
	void test_UpdateCustomerName_shouldThrowNoSuchCustomerAccountExceptionOnUpdate() {
		// Author: Vamsi
		assertEquals(1,1, "Still needs to be implemented");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
