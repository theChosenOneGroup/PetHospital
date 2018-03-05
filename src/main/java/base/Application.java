package base;

import base.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author long
 * @since 18-3-4
 */
@SpringBootApplication
@Import({WebSecurityConfig.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
}
