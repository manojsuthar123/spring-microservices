package com.batch.management.model.entity;

import com.batch.management.constant.BatchStatus;
import com.batch.management.constant.DataSource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "batch")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Boolean isRunning;
    private Boolean isMail;
    private String mail;
    @Enumerated(EnumType.STRING)
    private BatchStatus status;
    private String createdAt;
    private String startDateTime;

    @PrePersist
    public void prePersist() {
        createdAt = ""+System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        createdAt = ""+System.currentTimeMillis();
    }
}
