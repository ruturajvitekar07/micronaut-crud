package com.example.configuration;

import com.aerospike.client.AerospikeClient;
import com.aerospike.mapper.tools.AeroMapper;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class AerospikeConfiguration {

    @Inject
    AerospikeConfigurationProperties config;

    AeroMapper mapper = null;

    @PostConstruct
    public void setupAerospikeClient() {

        AerospikeClient client = new AerospikeClient(config.getHost(), config.getPort());
        mapper = new AeroMapper.Builder(client).build();
    }
    public AeroMapper getMapper() {
        return this.mapper;
    }
}
