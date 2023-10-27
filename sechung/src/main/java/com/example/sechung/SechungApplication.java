package com.example.sechung;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SechungApplication {

  public static void main(String[] args) {
    SpringApplication.run(SechungApplication.class, args);
  }


  /**
   * <p>
   *  ModelMapper를 Bean으로 등록합니다. 이를 통해 객체 간의 매핑 작업을 수행할 수 있습니다.
   * </p>
   *
   * @param
   * @return org.modelmapper.ModelMapper
   * @throws
   */

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration()
        .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
        .setFieldMatchingEnabled(true)
        .setMatchingStrategy(MatchingStrategies.STRICT);
    return mapper;
  }
}
