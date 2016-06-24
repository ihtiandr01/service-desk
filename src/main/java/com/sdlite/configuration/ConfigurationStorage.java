package com.sdlite.configuration;

import com.sdlite.Application;
import com.sdlite.domain.entities.ConfigurationItem;
import com.sdlite.domain.repositaries.SettingsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.sdlite.configuration.ConfigurationDefaultValues.SD_CONF_DEFAULT_VALUES;

@Component
public class ConfigurationStorage {
  private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationStorage.class);

  @Autowired
  private SettingsRepository settingsRepository;

  private Map<String, String> configurationMap = new ConcurrentHashMap<>();

  public String getValue(String key) {
    String value = configurationMap.get(key);
    if(value == null){
      ConfigurationItem configurationItem = settingsRepository.findOneByKey(key);
      if(configurationItem != null) {
        value = configurationItem.getValue();
        configurationMap.put(key, value);
      }
    }
    return value == null ? SD_CONF_DEFAULT_VALUES.get(key) : value;
  }




}
