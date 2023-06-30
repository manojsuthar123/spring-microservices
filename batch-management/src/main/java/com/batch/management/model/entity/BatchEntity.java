package com.batch.management.model.entity;

import com.batch.management.constant.BatchStatus;
import com.batch.management.constant.DataSource;
import jakarta.persistence.*;

@Entity
@Table(name = "batch")
public class BatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //data source
    @Enumerated(EnumType.STRING)
    private DataSource dataSource;
    private String dataSourceFile;
    private String dataSourceUrl;
    private String dataSourceUsername;
    private String dataSourcePassword;
    //data destination
    @Enumerated(EnumType.STRING)
    private DataSource dataDestination;
    private String dataDestFile;
    private String dataDestUrl;
    private String dataDestUsername;
    private String dataDestPassword;
    private boolean isRunning;
    private boolean isMail;
    private String mail;
    @Enumerated(EnumType.STRING)
    private BatchStatus status;
    private String createdAt;
    private String startDateTime;
}
