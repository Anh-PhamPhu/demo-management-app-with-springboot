package com.demoUserManagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsersRepositoryTests {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testCreateUser(){
        Users user = new Users();
        user.setEmail("anhpham.96@gmail.com");
        user.setPassword("1404");
        user.setFirst_name("Anh");
        user.setLast_name("Pham");

        Users savedUser = usersRepository.save(user);

        Users existsUser = testEntityManager.find(Users.class, savedUser.getId());

        assertThat(existsUser.getEmail()).isEqualTo(user.getEmail());

    }

    @Test
    public void testFindUserById(){
        String email = "anhpham.96.a@gmail.com";
        Users user = usersRepository.findByEmail(email);

        assertThat(user).isNotNull();
    }
}
