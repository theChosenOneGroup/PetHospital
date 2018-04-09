package base.config;

import javax.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author long
 * @since 18-4-8
 */
@Configuration
public class MultipartConfig {

  @Bean
  public MultipartConfigElement multipartConfigElement() {
    MultipartConfigFactory factory = new MultipartConfigFactory();
    factory.setMaxFileSize("20MB");
    factory.setMaxRequestSize("20MB");
    return factory.createMultipartConfig();
  }
}
