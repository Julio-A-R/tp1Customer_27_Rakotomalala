/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tp1customer_27_rakotomalala.ejb;

import mg.itu.tp1customer_27_rakotomalala.entities.Customer;
import jakarta.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Gère la persistance des Customers.
 */
@Stateless
public class CustomerManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }

    public Customer update(Customer customer) {
       return em.merge(customer);
    }

    public void persist(Customer customer) {
       em.persist(customer);
    }
}