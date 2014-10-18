package com.romansun.hibernate.DAO.impl;

import static com.romansun.hibernate.DAO.utils.QueryStorage.GET_COUNT_OF_ASSOCIATIONS;

import java.util.Collection;

import org.hibernate.Session;

import com.romansun.hibernate.DAO.AssociationDAO;
import com.romansun.hibernate.factory.Invoker;
import com.romansun.hibernate.logic.Association;

public class AssociationDAOImpl implements AssociationDAO {

	@Override
	public void add(final Association a) throws Exception {
		if (a == null)
			throw new IllegalArgumentException("Association must be not null");

		new Invoker<Void>() {
			@Override
			public Void task(Session session) {
				session.save(a);
				return null;
			}
		}.invoke();
	}

	@Override
	public void update(final Association a) throws Exception {
		if (a == null)
			throw new IllegalArgumentException("Association must be not null");

		new Invoker<Void>() {
			@Override
			public Void task(Session session) {
				session.update(a);
				return null;
			}
		}.invoke();
	}

	@Override
	public void delete(final Association a) throws Exception {
		if (a == null)
			throw new IllegalArgumentException("Association must be not null");

		new Invoker<Void>() {
			@Override
			public Void task(Session session) {
				session.delete(a);
				return null;
			}
		}.invoke();
	}

	@Override
	public Association getById(final long id) throws Exception {
		if (id <= 0)
			throw new IllegalArgumentException("ID must be positive");

		return new Invoker<Association>() {

			@Override
			public Association task(Session session) {
				Association asc = (Association) session.load(Association.class,	id);
				return asc;
			}
		}.invoke();
	}

	@Override
	public Collection<Association> getAll() throws Exception {
		return new Invoker<Collection<Association>>() {

			@Override
			public Collection<Association> task(Session session) {
				Collection<Association> ascs = session.createCriteria(Association.class).list();
				return ascs;
			}
		}.invoke();
	}

	@Override
	public int getCount() throws Exception {
		return new Invoker<Integer>() {

			@Override
			public Integer task(Session session) {
				return (Integer) session.createQuery(GET_COUNT_OF_ASSOCIATIONS).uniqueResult();
			}
		}.invoke();
	}

}
