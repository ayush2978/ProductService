package com.ayush.productservicespring.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {
    private long id;
    private Date createdDate;
    private Date lastUpdatedDate;
    private boolean isDeleted;
}
