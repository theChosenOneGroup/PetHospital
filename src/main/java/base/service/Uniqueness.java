package base.service;

import base.model.Record;

/**
 * @author long
 * @since 18-4-4
 */
public class Uniqueness {

  Long time;
  Integer differ;
  Integer sequence;

  public String uniqueSequence() {
    return time.toString() + differ.toString() + sequence.toString();
  }

  public static Uniqueness toUniqueness(Record record) {
    Uniqueness uniqueness = new Uniqueness();
    uniqueness.time = record.getCreatedTime();
    uniqueness.differ = record.getRand();
    uniqueness.sequence = record.getSequence();
    return uniqueness;
  }
}
