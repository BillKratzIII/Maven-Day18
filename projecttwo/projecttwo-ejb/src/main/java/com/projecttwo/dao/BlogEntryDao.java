package com.projecttwo.dao;

import java.util.List;

import javax.ejb.Local;

import com.projecttwo.BlogEntry;
import com.projecttwo.dao.common.Dao;

@Local
public interface BlogEntryDao extends Dao<BlogEntry> {

	List<BlogEntry> find(int maxresults, int firstresult);

	Long count();

}
