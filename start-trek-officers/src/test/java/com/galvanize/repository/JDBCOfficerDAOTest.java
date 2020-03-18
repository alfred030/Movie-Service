package com.galvanize.repository;

import com.galvanize.entities.Officer;
import com.galvanize.repositories.JDBCOfficerDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JDBCOfficerDAOTest {

    @Autowired
    JDBCOfficerDAO jdbcOfficerDAO;

    @Test
    void count() {
        long count = jdbcOfficerDAO.count();
        assertEquals(5L, count);


    }

    @Test
    void existById_exists() {
        boolean exists = jdbcOfficerDAO.exists( 3L);
        assertTrue(exists);
    }

    @Test
    void existById_doesntExists() {
        boolean exists = jdbcOfficerDAO.exists(99L);
        assertFalse(exists);
    }

    @Test
    void findAllOfficers() {
        List<Officer> officers = jdbcOfficerDAO.findAll();
        assertFalse(officers.isEmpty());
    }

    @Test
    void findOfficerById() {
        Optional<Officer> oOfficer = jdbcOfficerDAO.findById(3L);
        assertTrue(oOfficer.isPresent());
        assertNotNull(oOfficer.get().getId());
    }
}

