package org.example.dao;

import org.example.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryOperationDao implements OperationDao{
    public final Map<String, List<Operation>> map = new HashMap<>();

    @Override
    public void save(Operation operation) {
        if (map.containsKey(operation.getUser().getLogin())) {
            List<Operation> operations = map.get(operation.getUser().getLogin());
            operations.add(operation);
        } else {
            map.put(operation.getUser().getLogin(), new ArrayList<>());
        }
    }

    @Override
    public List<Operation> findAllByUser(String login) {
        return new ArrayList<>(map.get(login));
    }

    @Override
    public List<Operation> findAll() {
        return new ArrayList<Operation>();
    }
}
