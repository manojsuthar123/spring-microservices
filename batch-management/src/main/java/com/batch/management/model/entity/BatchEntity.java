package com.batch.management.model.entity;

import com.batch.management.constant.BatchStatus;
import com.batch.management.constant.DataSource;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "batch")
public class BatchEntity {
    private int id;
    private String name;
    //data source
    private DataSource dataSource;
    private String dataSourceFile;
    private String dataSourceUrl;
    private String dataSourceUsername;
    private String dataSourcePassword;
    //data destination
    private DataSource dataDestination;
    private String dataDestFile;
    private String dataDestUrl;
    private String dataDestUsername;
    private String dataDestPassword;
    private boolean isRunning;
    private boolean isMail;
    private String mail;
    private BatchStatus status;
    private String createdAt;
    private String startDateTime;
}
