package com.eduardo.library;

import com.eduardo.library.enums.RoleUser;
import com.eduardo.library.models.RoleModel;
import com.eduardo.library.models.UserModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LibraryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApiApplication.class, args);

		UserModel user = new UserModel();
		List<UserModel> list = new ArrayList<>();
		user.setId(1);
		user.setUserCpf("123456789");
		user.setUserName("admin");
		user.setUserPassword("admin");
		user.setUserRole(RoleUser.ADMIN);
		user.setUserEmail("admin@eduardo.com");
		user.setInsertDateTime(LocalDateTime.now(ZoneId.of("UTC")));
		user.setUpdateDateTime(LocalDateTime.now(ZoneId.of("UTC")));
		list.add(user);
		System.out.println("Estou aqui" + list.toString());
	}

}
