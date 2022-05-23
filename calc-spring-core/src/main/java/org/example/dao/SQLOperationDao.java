package org.example.dao;

import org.example.entity.Operation;
import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SQLOperationDao implements OperationDao{
    private Connection connection;
    private SQLUserDao sqlUserDao;
    private static final String SAVING = "insert into operation(operation, num1, num2, result, user_id) values (?, ?, ?, ?, ?)";
    private static final String FINDALL = "select * from operation";
    private static final String FINDBYLOGIN = "select * from operation where user_id = ?";

    @Override
    public void save(Operation operation) {
        try {
            PreparedStatement statement = connection.prepareStatement(SAVING);
            statement.setString(1, operation.getOperation());
            statement.setDouble(2, operation.getNum1());
            statement.setDouble(3, operation.getNum2());
            statement.setDouble(4, operation.getResult());
            statement.setLong(5, operation.getUser().getId());
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Operation> findAll() {
        List<Operation> operationList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(FINDALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                operationList.add(new Operation(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDouble(5),
                        sqlUserDao.findById(resultSet.getLong(6))));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return operationList;
    }

    @Override
    public List<Operation> findAllByUser(String login) {
        List<Operation> operationList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(FINDBYLOGIN);
            statement.setLong(1, sqlUserDao.findByUsername(login).getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                operationList.add(new Operation(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getDouble(3), resultSet.getDouble(4),
                        resultSet.getDouble(5), sqlUserDao.findById(resultSet.getLong(6))));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operationList;
    }

}
