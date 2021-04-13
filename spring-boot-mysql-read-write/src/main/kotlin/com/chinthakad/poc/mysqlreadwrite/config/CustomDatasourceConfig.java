package com.chinthakad.poc.mysqlreadwrite.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.datasource")
public class CustomDatasourceConfig {
    private DataSourceProperties leader;
    private DataSourceProperties follower;

    public DataSourceProperties getLeader() {
        return leader;
    }

    public void setLeader(DataSourceProperties leader) {
        this.leader = leader;
    }

    public DataSourceProperties getFollower() {
        return follower;
    }

    public void setFollower(DataSourceProperties follower) {
        this.follower = follower;
    }
}
