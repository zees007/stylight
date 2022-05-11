package com.stylight.ge.services;

import com.stylight.ge.Dtos.LookupResponseDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface LookupService {

    Map<String, String> getAllParameterizedUrlsAsValue(List<String> prettyUrls);

    Map<String, String> getAllPrettyUrlsAsValue(List<String> parameterizedUrls);
}
