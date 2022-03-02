package com.crudexample.crudexample.repository;

import com.crudexample.crudexample.dto.ClientResponse;
import com.crudexample.crudexample.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository  extends JpaRepository<Client, Long > {
    public Client findByName(String name);
    public Client findByUsername(String username);
//    public Client findByUsernameAndPassword(ClientResponse clientResponse);

//    List<Client> findByActive(String name);
    @Query("SELECT u FROM Client u WHERE u.active = 'Y'")
   public  List<Client> findByActive();


    public Client  findByUsernameAndPassword(String username, String password);
}
