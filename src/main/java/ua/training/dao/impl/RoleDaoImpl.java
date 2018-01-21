package ua.training.dao.impl;

import ua.training.dao.AbstractDao;
import ua.training.dao.RoleDao;
import ua.training.dao.util.QueryBuilder;
import ua.training.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ua.training.util.constant.table.RoleConstants.*;

public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {

    private RoleDaoImpl(Connection connection) {
        super(ROLE_TABLE, connection);
    }

    public static RoleDaoImpl getInstance(Connection connection) {
        return new RoleDaoImpl(connection);
    }

    @Override
    public Role findByUser(final Long userId) throws SQLException {
        String query = new QueryBuilder()
                // SELECT * FROM user_role INNER JOIN user ON user_role.id = user.role_id WHERE user.id = ?;
                .selectAll()
                .from()
                .table(ROLE_TABLE)
                .innerJoin()
                .table(USER_TABLE)
                .on()
                .tableColumn(ROLE_TABLE, ID)
                .queryEquals()
                .tableColumn(USER_TABLE, ROLE_ID)
                .where()
                .condition(USER_TABLE, ID)
                .build();
        return getEntityByQuery(query, (statement) -> statement.setLong(1, userId));
    }

    @Override
    protected String[] getParameterNames() {
        return new String[]{NAME};
    }

    @Override
    protected void setEntityParameters(Role entity, PreparedStatement statement) throws SQLException {
        statement.setString(1, entity.getName());
    }

    @Override
    protected Role getEntityFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ID);
        String name = resultSet.getString(NAME);
        return new Role.RoleBuilder()
                .setId(id)
                .setName(name)
                .buildRole();
    }
}
