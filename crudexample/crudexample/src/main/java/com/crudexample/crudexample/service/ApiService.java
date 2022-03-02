package com.crudexample.crudexample.service;

import com.crudexample.crudexample.dto.ApiDataRequest;
import com.crudexample.crudexample.dto.ApiDataResponse;
import com.crudexample.crudexample.dto.ClientResponse;
import com.crudexample.crudexample.entity.ApiData;
import com.crudexample.crudexample.entity.Client;
import com.crudexample.crudexample.entity.UserToken;
import com.crudexample.crudexample.repository.ApiDataRepository;
import com.crudexample.crudexample.repository.ClientRepository;
import com.crudexample.crudexample.repository.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserTokenRepository userTokenRepository;
    @Autowired
    private ApiDataRepository apiDataRepository;
    public String addApi(ApiDataRequest apiDataRequest) {
        UserToken userToken =userTokenRepository.findByToken(apiDataRequest.getToken());
        if(userToken == null){
            return "Invalid Token";
        }
        Client client = clientRepository.findById(userToken.getClient().getId()).orElse(null);;
        ApiData apiData=new ApiData();
        apiData.setApiName(apiDataRequest.getApiName());
        apiData.setApiData(apiDataRequest.getApiData());
        apiData.setClient(client);
        apiDataRepository.save(apiData);
        return "Token " +apiDataRequest.getToken()+ " Verified Succefully \nApi Added Successfully";
    }
    public List<ApiDataResponse> findAllApis() {
        List<ApiDataResponse> apiDataResponseS=new ArrayList<>();
        List<ApiData> apiData=apiDataRepository.findAll();

        for(ApiData api:apiData){
            ApiDataResponse apiDataResponse=new ApiDataResponse();
            apiDataResponse.setApiName(api.getApiName());
            apiDataResponse.setApiData(api.getApiData());
            Client clients=api.getClient();
            List<ClientResponse> clientRequestS=new ArrayList<>();

            ClientResponse clientResponse=new ClientResponse();
            clientResponse.setUsername(clients.getUsername());
            clientResponse.setName(clients.getName());
            clientResponse.setActive(clients.getActive());
            clientRequestS.add(clientResponse);
            apiDataResponse.setClientResponses(clientRequestS);
            apiDataResponseS.add(apiDataResponse);
        }
        return apiDataResponseS;

    }

}
