package com.crudexample.crudexample.service;

import com.crudexample.crudexample.dto.ClientResponse;
import com.crudexample.crudexample.dto.UserCheck;
import com.crudexample.crudexample.entity.Client;
import com.crudexample.crudexample.entity.UserToken;
import com.crudexample.crudexample.repository.ClientRepository;
import com.crudexample.crudexample.repository.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserTokenRepository userTokenRepository;

    public String generateToken(UserCheck clientResponse){
        Client verified = clientRepository.findByUsernameAndPassword(clientResponse.getUsername(),clientResponse.getPassword());
        if(verified == null){
            return "invalid string";
        }
        String token = RandomString.getAlphaNumericString(8);
        UserToken userToken = new UserToken();
        userToken.setToken(token);
        userToken.setClient(verified);
        userTokenRepository.save(userToken);
        return "User Verified Succefully!! \nGenerated Token is :" + token;
    }



}
