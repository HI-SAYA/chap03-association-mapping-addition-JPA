package com.ohgiraffers.section04.onetoone.subsection01;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OneToOneAssociationTests {

    private static EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @BeforeAll // 모든 테스트 수행하기 전에 딱 한번
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach //  테스트가 수행 되기 전마다 한번씩
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll // 모든 테스트 수행하기 전에 딱 한번
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach //  테스트가 수행 되기 전마다 한번씩
    public void closeManager() {
        entityManager.close();
    }


    @Test
    public void 외래키가_user에_있는_경우_단방향_연관관계_테스트() {
        //given
        Long userCode = 1L;
        //when
        User user = entityManager.find(User.class, userCode);
        //then
        assertNotNull(user);
        System.out.println(user);

    }
}
