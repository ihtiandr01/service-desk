package com.sdlite.domain.repositaries;

import com.sdlite.domain.entities.ConfigurationItem;
import org.springframework.data.repository.CrudRepository;

public interface SettingsRepository extends CrudRepository<ConfigurationItem, String> {
  ConfigurationItem findOneByKey(String key);
}
