package pl.carrental.config.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.carrental.user.dto.UserCredentialsDto;
import pl.carrental.user.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }


//    @PostConstruct
//    public void initUsers() {
//        User.UserBuilder userBuilder = User.builder();
//        //superadmin / hard
//        String password1 = "{bcrypt}" + new BCryptPasswordEncoder().encode("admin");
//        UserDetails admin = userBuilder.username("admin@o2.pl").password(password1).roles("ADMIN").build();
//        System.out.println(password1);
//
//
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", username)));
    }


    private UserDetails createUserDetails(UserCredentialsDto credentials) {
        return User.builder()
                .username(credentials.getEmail())
                .password(credentials.getPassword())
                .roles(credentials.getRoles().toArray(String[]::new))
                .build();
    }
}
