package com.sdlite.localization;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageConfiguration {

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setAlwaysUseMessageFormat(true);
    messageSource.setUseCodeAsDefaultMessage(true);
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setBasenames("classpath:messages");
    String str = messageSource.getMessage("messages.home_ru_RU",null,"empty",new Locale("ru","RU"));
    str.isEmpty();
    return messageSource;
  }

}
