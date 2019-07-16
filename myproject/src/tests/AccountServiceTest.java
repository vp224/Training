package tests;

import static org.junit.jupiter.api.Assertions.*;
import src.com.bank.service.*;
import org.junit.jupiter.api.Test;
class AccountServiceTest {

	@Test
	void createAccount_returns_valid_when_balance_gt_minbal() {
		AccountService a = new AccountService();
		int id = a.createNewAccount("SA", 100000);
		assertTrue(id >  0);
		
	}

}
