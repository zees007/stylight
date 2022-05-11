package com.stylight.ge.repositories;

import com.stylight.ge.models.UrlLookup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LookupRepository extends CrudRepository<UrlLookup, Long> {
    UrlLookup findFirstByPrettyURL(String parameterizedUrl);
    UrlLookup findFirstByParameterizedURL(String prettyUrl);

}
