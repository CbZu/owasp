package com.owasp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.owasp.model.Post;

@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Post> getByTitle(String title, Long userId) {
        String sql = "SELECT * FROM POST WHERE USER_ID = " + userId + " and  TITLE like '%" + title + "%'";
        List<Post> posts = jdbcTemplate.query(sql, postRowMapper);
        return posts;
    }

    private RowMapper<Post> postRowMapper = ((rs, rowNum) -> {
        return new Post(rs.getLong("id"),
                null,
                rs.getString("title"),
                rs.getString("content"));
    });
}
