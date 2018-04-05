package base.service.impl;

import base.service.FileStore;
import base.service.Uniqueness;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author long
 * @since 18-4-4
 */
public class FileStoreImpl implements FileStore {

  private static Logger logger = LoggerFactory.getLogger(FileStoreImpl.class);

  private File directory;

  private int bufferSize;

  public void setDirectory(String fileName) throws IOException {
    File directory = new File(fileName);
    if (directory.exists() && directory.isDirectory()) {
      if (!directory.canRead()) {
        throw new IOException("Cant't read from directory" + directory.getAbsolutePath());
      }
      if (!directory.canWrite()) {
        throw new IOException("Can't write to directory" + directory.getAbsolutePath());
      }
    } else {
      throw new IOException("Can't find directory" + directory.getAbsolutePath());
    }
    this.directory = directory;
  }

  public void setBufferSize(int bufferSize) {
    this.bufferSize = bufferSize;
  }

  public void store(InputStream in, Uniqueness uniqueness) throws IOException {
    File to = createFile(uniqueness);
    BufferedInputStream inputStream = new BufferedInputStream(in);
    BufferedOutputStream out = null;
    byte[] buffer = new byte[8192];
    int count;
    try {
      out = new BufferedOutputStream(new FileOutputStream(to), bufferSize);
      while (-1 != (count = inputStream.read(buffer))) {
        out.write(buffer, 0, count);
      }
      out.flush();
    } catch (FileNotFoundException e) {
      //do nothing
    } catch (IOException e) {
      if (to.exists() && !to.delete()) {
        logger.error("Can't delete file {}", to.getAbsolutePath());
      }
      throw new IOException(e);
    } finally {
      try {
        in.close();
        out.close();
      } catch (IOException ex) {
      }
    }
  }

  public void store(byte[] in, Uniqueness uniqueness) throws IOException {
    File to = createFile(uniqueness);
    FileOutputStream out = null;
    try {
      out = new FileOutputStream(to);
      out.write(in);
      out.flush();
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
      if (to.exists() && !to.delete()) {
        logger.error("Can't delete file {}", to.getAbsolutePath());
      }
      throw new IOException(e);
    } finally {
      try {
        if (out != null) {
          out.close();
        }
      } catch (IOException ex) {
      }
    }
  }

  private File createFile(Uniqueness uniqueness) throws FileAlreadyExistsException {
    File to = new File(directory, uniqueness.uniqueSequence());
    if (to.exists()) {
      throw new FileAlreadyExistsException(to.getAbsolutePath());
    }
    return to;
  }

  public InputStream retrieve(Uniqueness uniqueness) throws FileNotFoundException {
    File target = new File(directory, uniqueness.uniqueSequence());
    if (!target.exists()) {
      throw new FileNotFoundException("Can't find file " + target.getAbsolutePath());
    }
    return new FileInputStream(target);
  }

  public void delete(Uniqueness uniqueness) throws IOException {
    File to = seekFile(uniqueness);
    if (!to.delete()) {
      logger.error("Can't delete file " + to.getAbsolutePath());
      throw new IOException();
    }
  }

  public File seekFile(Uniqueness uniqueness) throws FileNotFoundException {
    File to = new File(directory, uniqueness.uniqueSequence());
    if (!to.exists() || to.isDirectory()) {
      throw new FileNotFoundException("can't find file " + to.getAbsolutePath());
    }
    return to;
  }
}
