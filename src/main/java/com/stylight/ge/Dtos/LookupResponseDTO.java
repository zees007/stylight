package com.stylight.ge.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author mhmdz
 * Created By Zeeshan on 08-05-2022
 * @project stylight-pretty-urls
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LookupResponseDTO {

    private String parameterizedURL;

    private String prettyURL;

}
