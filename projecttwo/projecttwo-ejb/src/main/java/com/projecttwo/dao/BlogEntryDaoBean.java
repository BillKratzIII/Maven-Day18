package com.projecttwo.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.projecttwo.BlogEntry;
import com.projecttwo.BlogEntry_;
import com.projecttwo.dao.common.AbstractDaoBean;

@Stateless
public class BlogEntryDaoBean extends AbstractDaoBean<BlogEntry> implements
		BlogEntryDao {

	@Inject
	private Logger log;

	@Override
	public List<BlogEntry> find(int maxresults, int firstresult) {
		log.info("find blog entry, max results " + maxresults + " next result " + firstresult);

		CriteriaBuilder builder = getCriteriaBuilder();
		CriteriaQuery<BlogEntry> query = builder.createQuery(BlogEntry.class);

		Root<BlogEntry> from = query.from(BlogEntry.class);
		query.select(from).orderBy(builder.desc(from.get(BlogEntry_.created)));
		return getResultList(query, maxresults, firstresult);
	}

	@Override
	public Long count() {
		CriteriaBuilder builder = getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<BlogEntry> from = query.from(BlogEntry.class);

		query.select(builder.count(from));

		return this.<Long> getTypedSingleResult(query);

	}
}
