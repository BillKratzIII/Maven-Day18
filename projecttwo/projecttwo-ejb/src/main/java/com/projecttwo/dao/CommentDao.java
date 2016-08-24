package com.projecttwo.dao;

import java.util.List;

import javax.ejb.Local;

import com.projecttwo.BlogEntry;
import com.projecttwo.Comment;
import com.projecttwo.dao.common.Dao;

@Local
public interface CommentDao extends Dao<Comment> {

	List<Comment> findComments(BlogEntry blogEntry);

}
