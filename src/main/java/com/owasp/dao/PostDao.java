package com.owasp.dao;

import java.util.List;
import com.owasp.model.Post;

public interface PostDao {
    List<Post> getByTitle(String title, Long userId);
}
