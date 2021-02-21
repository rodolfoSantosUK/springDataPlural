package com.rasmoo.cliente.escola.gradecurricular.repository;

import com.rasmoo.cliente.escola.gradecurricular.entity.Address;
import com.rasmoo.cliente.escola.gradecurricular.entity.Bank;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
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
        bank.getContacts().put("Manager","Joe");
        bank.getContacts().put("Saller","Joe");
        em.persist(bank);
        System.out.println("Salvou dados");
    }


}
