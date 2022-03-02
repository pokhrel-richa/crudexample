package com.crudexample.crudexample.service;

import com.crudexample.crudexample.dto.ClientRequest;
import com.crudexample.crudexample.entity.Client;
import com.crudexample.crudexample.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientRequest saveClient (ClientRequest client)
    {
        Client client1 = new Client();
        client1.setName(client.getName());
        client1.setUsername(client.getUsername());
        client1.setPassword(client.getPassword());
        client1.setActive(client.getActive());
        clientRepository.save(client1);
        return client;
    }
    public List<Client> saveClients(List<Client> clients){
        return clientRepository.saveAll(clients);
    }
    public List<ClientRequest> getClients(){
        List<Client> clients= clientRepository.findAll();
        List<ClientRequest> clientRequests = new ArrayList<>();
        for(Client client: clients){
            ClientRequest clientR = new ClientRequest();
            clientR.setName(client.getName());
            clientR.setPassword(client.getPassword());
            clientR.setUsername(client.getUsername());
            clientR.setActive(client.getActive());
            clientRequests.add(clientR);
        }
        return clientRequests;
    }

    public ClientRequest getClientById(long clientId){
        Client clientid = clientRepository.getOne(clientId);
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setName(clientid.getName());
        clientRequest.setUsername(clientid.getUsername());
        clientRequest.setPassword(clientid.getPassword());
        clientRequest.setActive(clientid.getActive());
        return clientRequest;

    }
    public Client  getClientByName(String name){
        return clientRepository.findByName(name);
    }
//    public String deleteClient(long id){
//        clientRepository.deleteById(id);
//        return "Client with ID: " + id + "is Deleted";
//    }
      public List<ClientRequest>  getClientByStatus(){
    List<Client> activeClient =  clientRepository.findByActive();
    List<ClientRequest> clientRequests = new ArrayList<>();
    for(Client active : activeClient){
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setName(active.getName());
        clientRequest.setUsername(active.getUsername());
        clientRequest.setPassword(active.getPassword());
        clientRequest.setActive(active.getActive());
        clientRequests.add(clientRequest);
    }
    return  clientRequests;

}
//    public String deleteClient(long parseLong) {
////        list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
//        Client entity = clientRepository.getOne(parseLong);
//        clientRepository.delete(entity);
//        return null;
//    }

    public ClientRequest updateClient(ClientRequest client, long id){
        Client existingClient = clientRepository.findById(id).orElse(null);
        existingClient.setName(client.getName());
        existingClient.setUsername(client.getUsername());
        existingClient.setPassword(client.getPassword());
        clientRepository.save(existingClient);
        ClientRequest newClient= new ClientRequest();
        newClient.setName(existingClient.getName());
        newClient.setUsername(existingClient.getUsername());
        newClient.setPassword(existingClient.getPassword());
        newClient.setActive(existingClient.getActive());
        return newClient;
    }
    public String changeStatus(long id){
        Client client = clientRepository.findById(id).orElse(null);
        Character prevStatus = client.getActive();
        if(client.getActive() == 'Y') {
            client.setActive('N');
        }
        else{
            client.setActive('Y');
        }
        String success = "Succefully changed status of ID: "+id +" from " + prevStatus + " to" + client.getActive();

        return success;
    }
}
