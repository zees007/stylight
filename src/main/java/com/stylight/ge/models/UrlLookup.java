package com.stylight.ge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author mhmdz
 * Created By Zeeshan on 08-05-2022
 * @project stylight-pretty-urls
 */

@Data
@Entity
@Table(name = "URL_LOOKUPS")
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "LOOKUP_TYPE", discriminatorType = DiscriminatorType.STRING)
public class UrlLookup extends BaseEntityWithIdentifier{

    private String parameterizedURL;

    private String prettyURL;

}
