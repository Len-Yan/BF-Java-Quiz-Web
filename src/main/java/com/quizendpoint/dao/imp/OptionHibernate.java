package com.quizendpoint.dao.imp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quizendpoint.dao.AbstractHibernateDAO;
import com.quizendpoint.dao.OptionDao;
import com.quizendpoint.domain.Option;
import com.quizendpoint.domain.Question;

@Repository("Optionhibernate")
public class OptionHibernate extends AbstractHibernateDAO<Option> implements OptionDao{
	
	//@Autowired
	//protected SessionFactory sessionFactory;
	
	@Override
	public List<Option> getOption(int question_id) {
        Query query = getCurrentSession().createQuery("from Option o where o.question_id = :question_id");
        query.setParameter("question_id", question_id);
        List<Option> o = query.getResultList();
     
        return o;
	}

	@Override
	public Option getRightOption(int question_id) {
        Query query = getCurrentSession().createQuery("from Option o where o.question_id = :question_id AND isCorrect = true" );
        query.setParameter("question_id", question_id);
        List<Option> o = query.getResultList();
     
        return o.get(0);
	}
	
	@Override
	public void add(Option opt) {
		getCurrentSession().save(opt);
	}

}
