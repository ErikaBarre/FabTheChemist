/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fab.chemist.spring.db.framework;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fab.chemist.spring.db.repository.impl.Customer;
import fab.chemist.spring.db.repository.impl.EmailAddress;
import fab.chemist.spring.db.repository.interf.CustomerRepository;

/**
 * Plain JPA based implementation of {@link CustomerRepository}.
 * 
 * @author Oliver Gierke
 */
@Repository
class JpaCustomerRepository implements CustomerRepository {

	@PersistenceContext
	private EntityManager emEntityManager;

	/* 
	 * (non-Javadoc)
	 * @see com.oreilly.springdata.jpa.core.CustomerRepository#findOne(java.lang.Long)
	 */
	@Override
	public Customer findOne(Long id) {
		return emEntityManager.find(Customer.class, id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.oreilly.springdata.jpa.core.CustomerRepository#save(com.oreilly.springdata.jpa.core.Customer)
	 */
	public Customer save(Customer customer) {
		if (customer.getId() == null) {
			emEntityManager.persist(customer);
			return customer;
		} else {
			return emEntityManager.merge(customer);
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see com.oreilly.springdata.jpa.core.CustomerRepository#findByEmailAddress(com.oreilly.springdata.jpa.core.EmailAddress)
	 */
	@Override
	public Customer findByEmailAddress(EmailAddress emailAddress) {

		TypedQuery<Customer> query = emEntityManager.createQuery("select c from Customer c where c.emailAddress = :email",
				Customer.class);
		query.setParameter("email", emailAddress);

		return query.getSingleResult();
	}
	
	public Customer findByName(String name) {
		
		return null;
		
	}
}
