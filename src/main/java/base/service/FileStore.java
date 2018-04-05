package base.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author long
 * @since 18-4-4
 */
public interface FileStore {

  void store(InputStream in, Uniqueness uniqueness) throws IOException;

  void store(byte[] in, Uniqueness uniqueness) throws IOException;

  InputStream retrieve(Uniqueness uniqueness) throws FileNotFoundException;

  void delete(Uniqueness uniqueness) throws IOException;
}
