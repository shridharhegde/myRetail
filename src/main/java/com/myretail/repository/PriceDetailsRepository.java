package com.myretail.repository;

import java.util.Optional;

public interface PriceDetailsRepository {

  /**
   * Store the key value pair in cache
   *
   * @param key   String key
   * @param value Integer value
   */
  void put(String key, String value);

  /**
   * Retrieve value from cache when key is provided
   *
   * @param key String key
   * @return Optional String
   */
  Optional<String> get(String key);
}
