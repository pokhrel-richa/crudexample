package com.crudexample.crudexample.dto;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ApiDataRequest {
    private long id;
    private String apiName;
    private String apiData;
    private String token;
    private List<ClientRequest> clientRequests;
}
