package com.crudexample.crudexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "API_DATA")
public class ApiData {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;
    @Column(name = "api_data")
    private String apiData;
    @Column(name = "api_name")
    private String apiName;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
