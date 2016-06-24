package com.sdlite.configuration;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static com.sdlite.configuration.ConfigurationKeys.SD_CONF_DATE_TIME_MASK_KEY;

public final class ConfigurationDefaultValues {
public final static Map<String, String> SD_CONF_DEFAULT_VALUES = ImmutableMap.<String, String>builder()
        .put(SD_CONF_DATE_TIME_MASK_KEY,"dd.mm.yyyy HH:mm").build();
}
