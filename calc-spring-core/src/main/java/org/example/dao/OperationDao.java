package org.example.dao;

import org.example.entity.Operation;

import java.util.List;

public interface OperationDao {

    void save(Operation operation);
    List<Operation> findAllByUser(String login);
    List<Operation> findAll();
}
