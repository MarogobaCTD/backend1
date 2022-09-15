package com.example.MongoDB.sequence;

public interface SequenceDao {
    Integer getNextSequenceId(String key) throws SequenceException;
}
