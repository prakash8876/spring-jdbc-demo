package io.matoshri.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.matoshri.testing.model.User;
import io.matoshri.testing.repo.UserRepository;
import io.matoshri.testing.service.UserService;

@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest
class TestingApplicationTests {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	@Test
	void injectedComponentsAreNotNull() {
		assertThat(userRepository).isNotNull();
		assertThat(userService).isNotNull();
	}

	@Test
	public void whenCalledSave_thenCorrectNumberOfUsers() {
		assertThat(userRepository).isNotNull();
		assertThat(userService).isNotNull();
		User user = mock(User.class);
		user.setName("Bob");
		user.setEmail("bob@domain.com");
		User savedUser = this.userService.saveUser(user);
		List<User> users = (List<User>) this.userService.getAllUsers();
		assertThat(savedUser).isNotNull();
		System.out.println(savedUser);
		assertThat(users.size()).isEqualTo(4);
	}

	@Test
	public void testSaveUser() {
		/*
		 * User user = User.builder() .name("Prakash") .email("prk@gmail.com") .build();
		 * 
		 * this.userRepository.save(user); Assertions.assertThat(user.getId() > 0);
		 */
		this.userRepository.save(new User("Prakash", "prk@gmail.com"));
		assertThat(this.userRepository.findByName("Prakash")).isNotNull();
	}

	@Test
	public void testGetAllUsers() {
		List<User> allUsers = this.userRepository.findAll();
		assertThat(allUsers).isNotNull();
		assertThat(allUsers).asList().size().isGreaterThan(0);
	}

	@Test
	public void testUpdateUser() {
		List<User> user = this.userRepository.findByName("Prakash");
		System.out.println(user.get(0));
		assertThat(user).isNotNull();
		assertThat(user).asList().size().isEqualTo(1);

		User updateUser = user.get(0);
		updateUser.setEmail("prakash@gmail.com");

		this.userService.updateUser(updateUser.getId(), updateUser);
		user = this.userRepository.findByName("Prakash");

		assertEquals("prakash@gmail.com", user.get(0).getEmail());
	}

	@Test
	public void testGetByName() {
		List<User> user = this.userRepository.findByName("Prakash");
		System.out.println(user.get(0));
		assertThat(user).isNotNull();
		assertThat(user).asList().size().isEqualTo(1);

		assertEquals("Prakash", user.get(0).getName());
	}
	
	@Test
	public void testDeleteUserById() {
		List<User> list = this.userRepository.findByName("Prakash");
		User user = list.get(0);
		
		Map<String, Boolean> deleteUser = this.userService.deleteUser(user.getId());
		System.out.println(deleteUser);
	}
}
