package com.restservice.resository;

import com.restservice.model.Currency;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Igor on 13.01.2017.
 */
public interface CurrencyRepository extends MongoRepository<Currency, String> {

}
