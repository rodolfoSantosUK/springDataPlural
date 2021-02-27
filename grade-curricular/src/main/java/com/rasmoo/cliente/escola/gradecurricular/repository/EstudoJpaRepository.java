package com.rasmoo.cliente.escola.gradecurricular.repository;

import com.rasmoo.cliente.escola.gradecurricular.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Repository
public class EstudoJpaRepository {

    private final EntityManager em;

    public EstudoJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void salvarEmbeddedUser() {

        Address address = new Address();

        address.setAddressLine1("33 Wall Street");
        address.setAddressLine2("Suite 233");
        address.setCity("FIladelfia");
        address.setState("PA");
        address.setZipCode("321321");

        Bank bank = new Bank();
        bank.setAddress(address);
        bank.setName("Federal Trust");
        bank.setCity("New York");
        bank.setState("NY");
        bank.setZipCode("12345");
        bank.setInternational(false);
        bank.setCreatedBy("Kevin");
        bank.setCreatedDate(new Date());
        bank.setLastUpdatedBy("Kevin");
        bank.setLastUpdatedDate(new Date());
        bank.getContacts().put("Manager", "Joe");
        bank.getContacts().put("Saller", "Joe");
        em.persist(bank);
        System.out.println("Salvou dados");
    }

    @Transactional
    public void salvarOneToOneUnidirecionalCredencial() {

        User user = new User();
        user.setFirstName("Kevin");
        user.setLastName("Bowersox");
        user.setAge(20);
        user.setBirthDate(new Date());
        user.setCreatedBy("Kevin Bowersox");
        user.setCreatedDate(new Date());
        user.setEmailAddress("kevin.bowersox@navy.mil");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Kevin Bowersox");

        Credential credential = new Credential();
        credential.setPassword("kevinspassword");
        credential.setUsername("kmb385");
        credential.setUser(user);

        em.persist(credential);
        System.out.println("Salvou no banco o  valor");

    }

    @Transactional
    public void salvarJoinTable() {
        Account account = createNewAccount();

        Budget budget = new Budget();
        budget.setGoalAmount(new BigDecimal("10000.00"));
        budget.setName("Emergency Fund");
        budget.setPeriod("Yearly");

        //  budget.getTransactions().add(createNewBeltPurchase(account));
        //  budget.getTransactions().add(createShoePurchase(account));
        em.merge(budget);

        System.out.println("salvarJoinTable");

    }


    @Transactional
    public void salvarOneToManyBidirecionalCredencial() {
        Account account = createNewAccount();
        account.getTransactions().add(createNewBeltPurchase(account));
        account.getTransactions().add(createShoePurchase(account));
        em.persist(account);
        System.out.println("salvarOneToManyBidirecionalCredencial");
    }

    @Transactional
    public void salvarOneToManyUnidirecionalCredencial() {
        Account account = createNewAccount();
        account.getTransactions().add(createNewBeltPurchase());
        account.getTransactions().add(createShoePurchase());

        em.persist(account);
        System.out.println("Salvou no banco o  valor");
    }

    @Transactional
    public void salvarManyToManyUnidirecionalCredencial() {

        Account account = createNewAccount();
        Account account2 = createNewAccount();
        User user = createUser();
        User user2 = createUser();

        Credential credential = createCredential(user);
        user.setCredential(credential);
        user2.setCredential(credential);
        em.persist(user);
        em.persist(user2);

        em.flush();
        account.getUsers().add(user);
        account.getUsers().add(user2);
        account2.getUsers().add(user);
        account2.getUsers().add(user2);

       // em.persist(account);
        //em.persist(account2);

    }



    private static User createUser() {
        User user = new User();
        Address address = createAddress();
        user.setAddresses(Arrays.asList(new Address[]{createAddress()}));
        user.setBirthDate(new Date());
        user.setCreatedBy("Kevin Bowersox");
        user.setCreatedDate(new Date());
        user.setCredential(createCredential(user));
        user.setEmailAddress("test@test.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setLastUpdatedBy("system");
        user.setLastUpdatedDate(new Date());
        return user;
    }

    private static Credential createCredential(User user) {
        Credential credential = new Credential();
        credential.setUser(user);
        credential.setUsername("test_username");
        credential.setPassword("test_password");
        return credential;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setAddressLine1("101 Address Line");
        address.setAddressLine2("102 Address Line");
        address.setCity("New York");
        address.setState("PA");
        address.setZipCode("10000");
        return address;
    }



    private static Transaction createNewBeltPurchase() {
        Transaction beltPurchase = new Transaction();
        beltPurchase.setTitle("Dress Belt");
        beltPurchase.setAmount(new BigDecimal("50.00"));
        beltPurchase.setClosingBalance(new BigDecimal("0.00"));
        beltPurchase.setCreatedBy("Kevin Bowersox");
        beltPurchase.setCreatedDate(new Date());
        beltPurchase.setInitialBalance(new BigDecimal("0.00"));
        beltPurchase.setLastUpdatedBy("Kevin Bowersox");
        beltPurchase.setLastUpdatedDate(new Date());
        beltPurchase.setNotes("New Dress Belt");
        beltPurchase.setTransactionType("Debit");
        return beltPurchase;
    }


    private static Transaction createShoePurchase() {
        Transaction shoePurchase = new Transaction();
        shoePurchase.setTitle("Work Shoes");
        shoePurchase.setAmount(new BigDecimal("100.00"));
        shoePurchase.setClosingBalance(new BigDecimal("0.00"));
        shoePurchase.setCreatedBy("Kevin Bowersox");
        shoePurchase.setCreatedDate(new Date());
        shoePurchase.setInitialBalance(new BigDecimal("0.00"));
        shoePurchase.setLastUpdatedBy("Kevin Bowersox");
        shoePurchase.setLastUpdatedDate(new Date());
        shoePurchase.setNotes("Nice Pair of Shoes");
        shoePurchase.setTransactionType("Debit");
        return shoePurchase;
    }

    private static Account createNewAccount() {
        Account account = new Account();
        account.setCloseDate(new Date());
        account.setOpenDate(new Date());
        account.setCreatedBy("Kevin Bowersox");
        account.setInitialBalance(new BigDecimal("50.00"));
        account.setName("Savings Account");
        account.setCurrentBalance(new BigDecimal("100.00"));
        account.setLastUpdatedBy("Kevin Bowersox");
        account.setLastUpdatedDate(new Date());
        account.setCreatedDate(new Date());
        return account;
    }


    private static Transaction createNewBeltPurchase(Account account) {
        Transaction beltPurchase = new Transaction();
        beltPurchase.setAccount(account);
        beltPurchase.setTitle("Dress Belt");
        beltPurchase.setAmount(new BigDecimal("50.00"));
        beltPurchase.setClosingBalance(new BigDecimal("0.00"));
        beltPurchase.setCreatedBy("Kevin Bowersox");
        beltPurchase.setCreatedDate(new Date());
        beltPurchase.setInitialBalance(new BigDecimal("0.00"));
        beltPurchase.setLastUpdatedBy("Kevin Bowersox");
        beltPurchase.setLastUpdatedDate(new Date());
        beltPurchase.setNotes("New Dress Belt");
        beltPurchase.setTransactionType("Debit");
        return beltPurchase;
    }

    private static Transaction createShoePurchase(Account account) {
        Transaction shoePurchase = new Transaction();
        shoePurchase.setAccount(account);
        shoePurchase.setTitle("Work Shoes");
        shoePurchase.setAmount(new BigDecimal("100.00"));
        shoePurchase.setClosingBalance(new BigDecimal("0.00"));
        shoePurchase.setCreatedBy("Kevin Bowersox");
        shoePurchase.setCreatedDate(new Date());
        shoePurchase.setInitialBalance(new BigDecimal("0.00"));
        shoePurchase.setLastUpdatedBy("Kevin Bowersox");
        shoePurchase.setLastUpdatedDate(new Date());
        shoePurchase.setNotes("Nice Pair of Shoes");
        shoePurchase.setTransactionType("Debit");
        return shoePurchase;
    }


}
