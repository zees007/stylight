package com.stylight.ge.models;

import javax.persistence.*;

/**
 * @author mhmdz
 * Created By Zeeshan on 08-05-2022
 * @project stylight-pretty-urls
 */

@MappedSuperclass
public class BaseEntityWithIdentifier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
