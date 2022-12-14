package com.skilldistillery.rewardforpay.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRoleTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private UserRole userRole;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPARewardForPay");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		userRole = em.find(UserRole.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		userRole=null;
		
	}
	
	@Test
	void test_UserRole_Entity_mapping() {
		assertNotNull(userRole);
		assertEquals("Admin",userRole.getName());
		


	}

}
