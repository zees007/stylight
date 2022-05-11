package com.stylight.ge.services.implementations;

import com.stylight.ge.models.UrlLookup;
import com.stylight.ge.repositories.LookupRepository;
import com.stylight.ge.services.LookupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class LookupServiceImpl implements LookupService {

    @Autowired
    LookupRepository lookupRepository;

    @Override
    public Map<String, String> getAllParameterizedUrlsAsValue(List<String> prettyUrls) {
        Map<String, String> urlLookupMap = new HashMap<>();
        String lookupValue = null;
        for(String prettyUrl : prettyUrls) {
            UrlLookup lookup = lookupRepository.findFirstByPrettyURL(prettyUrl);
            if(lookup != null){
                lookupValue = lookup.getParameterizedURL();
            } else {
                String chopStr = prettyUrl;
                for (int i = prettyUrl.length(); i >= 0; i--) {
                    chopStr= StringUtils.chop(chopStr);
                    UrlLookup lp = lookupRepository.findFirstByPrettyURL(chopStr);
                    if(lp != null){
                        lookupValue = lp.getParameterizedURL() + biDirectionalMatchingUrl(prettyUrl, chopStr);
                        break;
                    } else {
                        lookupValue = prettyUrl;
                    }
                }
            }
            urlLookupMap.put(prettyUrl,lookupValue);
        }
        return urlLookupMap;
    }

    @Override
    public Map<String, String> getAllPrettyUrlsAsValue(List<String> parameterizedUrls) {
        Map<String, String> urlLookupMap = new HashMap<>();
        String lookupValue = null;

        for(String paramUrl : parameterizedUrls) {
            UrlLookup lookup = lookupRepository.findFirstByParameterizedURL(paramUrl);
            if(lookup != null){
                lookupValue = lookup.getPrettyURL();
            } else {
                String chopStr = paramUrl;
                for (int i = paramUrl.length(); i >= 0; i--) {
                    chopStr= StringUtils.chop(chopStr);
                    UrlLookup lp = lookupRepository.findFirstByParameterizedURL(chopStr);
                    if(lp != null){
                        lookupValue = lp.getPrettyURL() + biDirectionalMatchingUrl(paramUrl, chopStr);
                        break;
                    } else {
                        lookupValue = paramUrl;
                    }
                }

            }
            urlLookupMap.put(paramUrl,lookupValue);
        }
        return urlLookupMap;
    }


    public String biDirectionalMatchingUrl(String inputUrl, String chopUrl){
        int lastIndexOfInputString = inputUrl.length();
        int lastIndexOfLookupString = chopUrl.length();
        String finalStr = inputUrl.substring(lastIndexOfLookupString, lastIndexOfInputString);
        return finalStr;
    }

}
