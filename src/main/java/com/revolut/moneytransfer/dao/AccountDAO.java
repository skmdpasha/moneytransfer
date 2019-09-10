package com.revolut.moneytransfer.dao;

import com.revolut.moneytransfer.exception.CustomException;
import com.revolut.moneytransfer.model.Account;
import com.revolut.moneytransfer.model.UserTransaction;

import java.math.BigDecimal;
import java.util.List;


public interface AccountDAO {
	
	/**
    *
    * @return list of all accounts
    */
    List<Account> getAllAccounts() throws CustomException;
    
    /**
    *
    * @param accountId user accountId
    * @return the account pertaining to the specified accountId
    */
    
    Account getAccountById(long accountId) throws CustomException;
    
    /**
    *
    * @param account details which has to be created
    * @return accountId of the created account
    */
    long createAccount(Account account) throws CustomException;
    
    /**
    *
    * @param accountId user accountId
    * @return integer to determine if the account is deleted. 1 - SUCCESS
    */
    int deleteAccountById(long accountId) throws CustomException;

    /**
     *
     * @param accountId user accountId
     * @return no. of rows updated
     */
    int updateAccountBalance(long accountId, BigDecimal deltaAmount) throws CustomException;
    
    /**
    *
    * @param userTransaction 
    * @return integer to determine if the money is transferred from one account to another another. 2 - SUCCESS
    */
    int transferAccountBalance(UserTransaction userTransaction) throws CustomException;
}
