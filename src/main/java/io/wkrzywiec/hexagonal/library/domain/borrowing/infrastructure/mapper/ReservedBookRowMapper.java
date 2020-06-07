package io.wkrzywiec.hexagonal.library.domain.borrowing.infrastructure.mapper;

import io.wkrzywiec.hexagonal.library.domain.borrowing.core.model.ReservedBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservedBookRowMapper implements RowMapper<ReservedBook> {

    @Override
    public ReservedBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ReservedBook(
                rs.getLong("book_id"),
                rs.getLong("user_id"),
                rs.getTimestamp("reserved_date").toInstant()
        );
    }
}
