package base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author long
 * @since 18-3-8
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/").setViewName("home");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/manage/user").setViewName("user-manage");
    registry.addViewController("/article/create/**").setViewName("article-create");
    registry.addViewController("/article/view/**").setViewName("article-view");
//    registry.addViewController("/error").setViewName("error");
  }
}
