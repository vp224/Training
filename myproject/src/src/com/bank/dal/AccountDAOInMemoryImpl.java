package src.com.bank.dal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import src.com.bank.domain.Account;
import src.com.bank.dal.AccountDAO;
public class AccountDAOInMemoryImpl implements AccountDAO {
	
	AtomicInteger counter=new AtomicInteger(0);
	ConcurrentHashMap<Integer, Account> db=new ConcurrentHashMap<Integer, Account>();

	@Override 
	public Account getById(int id) {
		
		return db.get(id);
	}

	@Override
	public int create(Account account) {
		Integer id=counter.incrementAndGet();
		db.put(id,account);
		return id;
	}

	@Override
	public void update(Account account) {
		db.put(account.getId(), account);

	}

	@Override
	public void delete(int id) {
		db.remove(id);

	}

}
