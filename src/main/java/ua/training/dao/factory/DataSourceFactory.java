package ua.training.dao.factory;

import ua.training.dao.datasource.ConnectionPool;

import javax.sql.DataSource;

public class DataSourceFactory { // TODO ?
    private DataSource dataSource;

    private DataSourceFactory() {
        dataSource = ConnectionPool.getDataSource();
    }

    public static DataSourceFactory getInstance() {
        return new DataSourceFactory();
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
