package com.springbootproject.ecommerce.service;

import com.springbootproject.ecommerce.api.model.LoginBody;
import com.springbootproject.ecommerce.api.model.RegistrationBody;
import com.springbootproject.ecommerce.exception.UserAlreadyExistsException;
import com.springbootproject.ecommerce.model.LocalUser;
import com.springbootproject.ecommerce.model.dao.LocalUserDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private LocalUserDAO localUserDAO;
    private EncryptionService encryptionService;
    private JWTService jwtService;

    public UserService(LocalUserDAO localUserDAO, EncryptionService encryptionService, JWTService jwtService) {
        this.localUserDAO = localUserDAO;
        this.encryptionService = encryptionService;
        this.jwtService = jwtService;
    }

    public LocalUser registerUser(RegistrationBody registerBody) throws UserAlreadyExistsException {

        LocalUser user = new LocalUser();
        if( localUserDAO.findByEmailIgnoreCase(registerBody.getEmail()).isPresent() || localUserDAO.findByUsernameIgnoreCase(registerBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        user.setEmail(registerBody.getEmail());
        user.setUsername(registerBody.getUsername());
        user.setFirstName(registerBody.getFirstName());
        user.setLastName(registerBody.getLastName());
        // TODO: Encrypt password
        user.setPassword(encryptionService.encryptPassword(registerBody.getPassword()));
        return localUserDAO.save(user);
    }


    public String loginUser(LoginBody loginBody) {
        Optional<LocalUser> opUser = localUserDAO.findByUsernameIgnoreCase(loginBody.getUsername());
        if (opUser.isPresent()) {
            LocalUser user = opUser.get();
            if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())) {
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }
}
