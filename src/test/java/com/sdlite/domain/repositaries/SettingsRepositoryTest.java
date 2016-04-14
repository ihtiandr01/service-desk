package com.sdlite.domain.repositaries;

import com.sdlite.Application;
import com.sdlite.domain.entities.ConfigurationItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SettingsRepositoryTest {

  @Autowired
  SettingsRepository repository;

  @Test
  public void testSettingsRepository() {
    ConfigurationItem confItem = new ConfigurationItem("testKey", "testValue");
    repository.save(confItem);
    confItem = repository.findOneByKey("testKey");
    assertThat(confItem.getKey(), is("testKey"));
    assertThat(confItem.getValue(), is("testValue"));
  }


}
