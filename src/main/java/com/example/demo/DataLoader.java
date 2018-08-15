package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Dataloder running ...");
      roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
//        Role test1 = new Role();
//        test1.setId(1);
//        test1.setRole("USER");
//        roleRepository.save(test1);
//
//        Role admin = new Role();
//        admin.setId(2);
//        admin.setRole("ADMIN");
//        roleRepository.save(admin);

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user = new User("bob@bob.com","bob","Bob","Bobberson",true,"bob");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        user  = new User("jim@jim.com","jim","Jim","Jimmerson",true,"jim");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        user = new User("admin@adm.com","pass","Admin","User",true,"admin");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);

        user = new User("nasim@gmail.com","nas","Nasm","Parikhah",true,"nasim");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);
    }
}
