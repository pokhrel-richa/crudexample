package com.crudexample.crudexample.dto;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiDataResponse {
    private String apiName;
    private String apiData;
    private List<ClientResponse> clientResponses;
}
