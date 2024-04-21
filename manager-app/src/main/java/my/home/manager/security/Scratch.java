package my.home.manager.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class Scratch {
    public static void main(String[] args) {
        System.out.println(
                new BCryptPasswordEncoder().encode("password")
        );
    }
}
