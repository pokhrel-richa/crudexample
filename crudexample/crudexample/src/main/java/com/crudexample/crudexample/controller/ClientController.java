package com.crudexample.crudexample.controller;

import com.crudexample.crudexample.dto.*;
import com.crudexample.crudexample.entity.Client;
import com.crudexample.crudexample.service.ApiService;
import com.crudexample.crudexample.service.ClientService;
import com.crudexample.crudexample.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService service;
    @Autowired
    private ApiService apiService;
    @Autowired
    private UserTokenService userTokenService;
    @PostMapping("/addclient")
    public ClientRequest addClient(@RequestBody ClientRequest client){
        return service.saveClient(client);
    }

//    @PostMapping("/addclients")
//    public List<Client> addClients(@RequestBody List<Client> clients){
//        return service.saveClients(clients);
//    }

    @GetMapping("/clients")
    public List<ClientRequest> findAllClients(){
        return service.getClients();
    }
    @GetMapping("clientid/{id}")
    public ClientRequest findClientById(@PathVariable String id){
        return service.getClientById(Long.parseLong(id));
    }
    @GetMapping("clientname/{name}")
    public Client findClientByName(@PathVariable String name){
        return service.getClientByName(name);
    }
    @PutMapping("/update/{id}")
    public ClientRequest updateClient(@RequestBody ClientRequest client, @PathVariable String id){
        return service.updateClient(client, Long.parseLong(id));
    }
    @GetMapping("/clients/active")
    public List<ClientRequest> findAllActiveClients(){
        return service.getClientByStatus();
    }

    @PutMapping("client/status/{id}")
    public String changeStatus(@PathVariable("id") String id){
        return service.changeStatus(Long.parseLong(id));
    }

    @PostMapping("api/add")
    public String addApi(@RequestBody ApiDataRequest apiDataRequest){
       return  apiService.addApi(apiDataRequest);
    }
    @GetMapping("/apis")
    public List<ApiDataResponse> findAllApis(){
        return apiService.findAllApis();
    }

    @PostMapping("api/token")
    public String generateToken(@RequestBody UserCheck clientCheck)
    {
        return userTokenService.generateToken(clientCheck);
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteClient( String id){
//        return service.deleteClient(Long.parseLong(id));
//    }
    //delete the client
//    @DeleteMapping("/student/{clientId}")
//    public ResponseEntity<HttpStatus> deleteClientnow(@PathVariable String clientId){
//        try {
//            this.service.deleteClient(Long.parseLong(clientId));
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
}
