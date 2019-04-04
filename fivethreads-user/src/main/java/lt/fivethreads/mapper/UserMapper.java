package lt.fivethreads.mapper;

import lt.fivethreads.entities.Role;
import lt.fivethreads.entities.RoleName;
import lt.fivethreads.entities.User;
import lt.fivethreads.entities.request.RegistrationForm;
import lt.fivethreads.entities.request.UserDTO;
import lt.fivethreads.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    public User convertRegistrationUserToUser(RegistrationForm registrationForm) {
        User user = new User();
        user.setEmail(registrationForm.getEmail());
        user.setFirstname(registrationForm.getFirstname());
        user.setLastName(registrationForm.getLastname());
        user.setPassword(encoder.encode(registrationForm.getPassword()));
        user.setPhone(registrationForm.getPhone());
        Set<String> strRoles = registrationForm.getRole();
        user.setRoles(getRoles(strRoles));
        return user;
    }

    public UserDTO getUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastName());
        userDTO.setId(user.getId());
        userDTO.setPhone(user.getPhone());
        userDTO.setRole(user.getRoles()
                .stream()
                .map(e -> e.getName().toString())
                .collect(Collectors.toSet()));
        return userDTO;
    }

    public Set<Role> getRoles(Set<String> strRoles) {
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "ROLE_ADMIN":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(adminRole);

                    break;
                case "ROLE_ORGANIZER":
                    Role pmRole = roleRepository.findByName(RoleName.ROLE_ORGANIZER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(pmRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });
        return roles;
    }
}
