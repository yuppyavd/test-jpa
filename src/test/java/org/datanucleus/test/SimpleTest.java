package org.datanucleus.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.datanucleus.util.NucleusLogger;
import org.junit.Assert;
import org.junit.Test;

import pl.avd.model.Person;

public class SimpleTest
{
    @Test
    public void testSimple()
    {
        NucleusLogger.GENERAL.info(">> test START");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyTest");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try
        {
            tx.begin();

            Person person = new Person(1, "test", new Date());
            em.persist(person);

            CriteriaBuilder cb = em.getCriteriaBuilder();
            
            CriteriaQuery<PersonDTO> cq = cb.createQuery(PersonDTO.class);
            Root<Person> r = cq.from(Person.class);
            
            cq.multiselect(r.get("id"), r.get("name"), cb.lessThan(r.<Date> get("created"), cb.currentDate()));
            
            TypedQuery<PersonDTO> tq = em.createQuery(cq);
            List<PersonDTO> result = tq.getResultList();
            
            Assert.assertNotNull(result);
            Assert.assertEquals(1, result.size());
            
            tx.commit();
        }
        catch (Throwable thr)
        {
            NucleusLogger.GENERAL.error(">> Exception thrown persisting data", thr);
            fail("Failed to persist data : " + thr.getMessage());
        }
        finally 
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            em.close();
        }

        emf.close();
        NucleusLogger.GENERAL.info(">> test END");
    }
}