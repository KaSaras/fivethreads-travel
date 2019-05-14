package lt.fivethreads.services;

import lt.fivethreads.entities.User;
import lt.fivethreads.exception.file.EmailAlreadyExists;
import lt.fivethreads.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AdvancedUserCreationServiceImplementation implements UserCreationService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    MailService mailService;

    @Autowired
    UserService userService;

    public User createNewUser(User user) {
        if (userService.checkIfEmailExists(user.getEmail())) {
            throw new EmailAlreadyExists();
        }
        User created_user = userRepository.save(user);
        String subject = "You were added to the DevBridge Travel application.";
        String text = "You were added to the DevBridge Travel application. Your credentials:\nEmail: "+
                user.getEmail()+"\nPassword: newAdmin123" + "\nPlease log in to the system (url) and change the password.";
        mailService.sendSimpleMessage(user.getEmail(), subject, text);
        return created_user;
    }
}