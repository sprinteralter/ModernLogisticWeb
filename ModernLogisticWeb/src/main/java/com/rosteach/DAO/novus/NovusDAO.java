package com.rosteach.DAO.novus;

import java.sql.SQLException;

public interface NovusDAO {
public String test() throws SQLException;
String Insert(String database, String name, String password, String path) throws SQLException;
}
