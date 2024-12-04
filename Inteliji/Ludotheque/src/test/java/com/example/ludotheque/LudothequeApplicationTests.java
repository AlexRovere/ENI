package com.example.ludotheque;

import com.example.ludotheque.bo.Client;
import com.example.ludotheque.dal.ClientRepositoryJdbcImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class LudothequeApplicationTests {

    @Autowired
    private ClientRepositoryJdbcImpl clientImpl;

    @Test
    void contextLoads() {
    }

    @Test
    void testClientRepoFindAll() {
        List<Client> clients = clientImpl.getAll();
    }
}
