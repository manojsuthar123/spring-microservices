package com.batch.management.model.dto;

import com.batch.management.constant.BatchStatus;
import com.batch.management.constant.DataSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchDto {
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
    private Boolean isRunning;
    private Boolean isMail;
    private String mail;
    private BatchStatus status;
    private String createdAt;
    private String startDateTime;
}
