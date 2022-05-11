package com.stylight.ge.controllers;

import com.stylight.ge.Dtos.LookupResponseDTO;
import com.stylight.ge.services.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author mhmdz
 * Created By Zeeshan on 08-05-2022
 * @project stylight-pretty-urls
 */

@RestController
public class LookupController {

    @Autowired
    LookupService lookupService;

    @GetMapping("/getAllParameterizedUrls")
    public ResponseEntity getAllParameterizedUrls(@RequestBody List<String> prettyUrls) {
        try {
            Map<String, String> prettyUrlMap = lookupService.getAllParameterizedUrlsAsValue(prettyUrls);
            return ResponseEntity.ok(prettyUrlMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getAllPrettyUrls")
    public ResponseEntity getAllPrettyUrls(@RequestBody List<String> paramUrls) {
        try {
            Map<String, String> paramUrlMap = lookupService.getAllPrettyUrlsAsValue(paramUrls);
            return ResponseEntity.ok(paramUrlMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
