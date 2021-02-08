package com.myretail.repository;

import com.myretail.exception.ApplicationException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class PriceDetailsRepositoryImpl implements PriceDetailsRepository {

  private StringRedisTemplate redisTemplate;

  private ValueOperations<String, String> valueOps;

  @Autowired
  public PriceDetailsRepositoryImpl(StringRedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
    this.valueOps = redisTemplate.opsForValue();
  }

  @Override
  public void put(String key, String value) {
    try {
      valueOps.set(key, value);
    } catch (RuntimeException e) {
      throw new ApplicationException("Error while saving to redis");
    }
  }

  @Override
  public Optional<String> get(String key) {
    try {
      Boolean b = redisTemplate.hasKey(key);
      if (Boolean.TRUE.equals(b)) {
        return Optional.ofNullable(valueOps.get(key));
      } else {
        return Optional.empty();
      }
    } catch (RuntimeException e) {
      throw new ApplicationException("Error while retrieving from the redis ");
    }
  }
}
