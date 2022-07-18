package com.soulcode.Servicos.Config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class CacheConfig {
      private final RedisSerializationContext.SerializationPair<Object> serializationPair =
              RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());

      @Bean
        public RedisCacheConfiguration cacheConfiguration() { // Customiza a configuração padrão do cache do Redis
            return RedisCacheConfiguration
                    .defaultCacheConfig() // customizar o cache
                    .entryTtl(Duration.ofMinutes(5)) // tempo de vida do cache
                    .disableCachingNullValues() // não cachear(salvar) valores nulos
                    .serializeValuesWith(serializationPair); // convererte do redis para json e vice versa
        }

        @Bean
        public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
            return (builder) ->
                    builder.withCacheConfiguration("clientesCache",
                        RedisCacheConfiguration.defaultCacheConfig()
                                .entryTtl(Duration.ofMinutes(5))
                                .serializeValuesWith(serializationPair)
                    ).withCacheConfiguration("chamadosCache",
                            RedisCacheConfiguration.defaultCacheConfig()
                                    .entryTtl(Duration.ofMinutes(5))
                                    .serializeValuesWith(serializationPair)
                    ).withCacheConfiguration("cargosCache",
                            RedisCacheConfiguration.defaultCacheConfig()
                                    .entryTtl(Duration.ofMinutes(5))
                                    .serializeValuesWith(serializationPair)
                    ).withCacheConfiguration("enderecoCache",
                            RedisCacheConfiguration.defaultCacheConfig()
                                    .entryTtl(Duration.ofMinutes(5))
                                    .serializeValuesWith(serializationPair)
                    );

        }

}
