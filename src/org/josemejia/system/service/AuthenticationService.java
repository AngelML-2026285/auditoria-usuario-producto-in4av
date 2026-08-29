package org.josemejia.system.service;

import org.josemejia.system.model.User;
import org.josemejia.system.repository.AuthenticationRepository;
import org.josemejia.system.service.AuthenticationStatus;
import org.josemejia.system.service.UserService;

public class AuthenticationService {

    private AuthenticationRepository authRepo = new AuthenticationRepository();
    private UserService userService = new UserService();
    private User authenticatedUser;

    public AuthenticationStatus login(String email, String password) {
        User existingUser = userService.findByEmail(email);
        if (existingUser == null) {
            return AuthenticationStatus.NOT_EXIST_USER;
        }

        User user = authRepo.login(email, password);
        if (user == null) {
            return AuthenticationStatus.INVALID_PASSWORD;
        }

        authenticatedUser = user;
        return AuthenticationStatus.LOGIN_SUCCESS;
    }

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }
}
