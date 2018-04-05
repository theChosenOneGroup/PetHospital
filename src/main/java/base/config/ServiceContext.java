package base.config;

import base.service.FileStore;
import base.service.impl.FileStoreImpl;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author long
 * @since 18-4-5
 */
@Configuration
public class ServiceContext {

  @Value("${store.directory}")
  private String directory;

  @Value("${store.bufferSize}")
  private Integer bufferSize;

  @Bean
  public FileStore fileStore() throws IOException {
    FileStoreImpl fileStore = new FileStoreImpl();
    fileStore.setDirectory(directory);
    fileStore.setBufferSize(bufferSize);
    return fileStore;
  }

}
