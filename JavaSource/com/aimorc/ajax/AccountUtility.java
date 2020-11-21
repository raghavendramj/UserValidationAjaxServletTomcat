package com.aimorc.ajax;

import java.util.List;
import java.util.Optional;

public class AccountUtility {

	public static Account findByUsername(String username){
		PostgressDBOperations operations = new PostgressDBOperations();

		List<Account> accounts = operations.fetchAccounts();

		for(Account account : accounts) {
			String currUsername  = account.getUsername();
			if(currUsername.equals(username)) {
				return account;
			}
		}
		return null;

		// Optional<Account> matchingObject  = accounts.stream().filter(account -> account.getUsername().equals(username)).findFirst();
		// return matchingObject.orElse(null);

	}
}
