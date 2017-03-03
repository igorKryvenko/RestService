package com.restservice.repository;

import com.restservice.model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Igor on 13.01.2017.
 */
@Repository
public interface CurrencyRepository extends MongoRepository<Currency, String> {

}
