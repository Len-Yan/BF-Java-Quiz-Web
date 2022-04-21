package com.quizendpoint.dao.imp;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quizendpoint.dao.AbstractHibernateDAO;
import com.quizendpoint.dao.QuestionDAO;
import com.quizendpoint.domain.Question;
import com.quizendpoint.exception.IdNotFoundException;

@Repository("QuestionhibernateDAO")
public class QuestionhibernateDao extends AbstractHibernateDAO<Question> implements QuestionDAO{

    //@Autowired
    //protected SessionFactory sessionFactory;
    
	@Override
	public Question getQuestion(int question_id) throws IdNotFoundException {
        Query query = getCurrentSession().createQuery("from Question q where q.question_id = :question_id");
        query.setParameter("question_id", question_id);
        List<Question> q = query.getResultList();
        if(q.size() == 0) return throwQuestionExcption();
        return q.size() == 0 ? null : q.get(0);
	}

	@Override
	public List<Question> getQuestionbyCat(int cat_id) {
		List<Question> questions = getCurrentSession().createQuery("from Question q where q.category_id = " + cat_id).list();
		return questions;
	}

	@Override
	public List<Question> getXquestionbyCat(int cat_id, int questionNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getQuestionCount() {
		Long l =  (Long) getCurrentSession().createQuery("SELECT COUNT(*) from Question").uniqueResult();
		//force cast
		return Integer.valueOf((int) (long)l);
	}

	@Override
	public List<Question> getAllQuestion() {
		List<Question> questions = getCurrentSession().createQuery("from Question").list();
		return questions;
	}

	@Override
	public Question throwQuestionExcption() throws IdNotFoundException {
		throw new IdNotFoundException("Question Id Not found");
	}

	@Override
	public Question addQuestion(int cat_id, String content) {
		int count = this.getQuestionCount();
		if(cat_id != 1) {System.out.println("not such cate now"); return null;}
		Question q = new Question(count + 1, content, cat_id);
		
		getCurrentSession().save(q);
		return q;
	}

	@Override
	public Question addQuestionObj(Question q) {
		int count = this.getQuestionCount();
		//System.out.println(count);
		//q.setQuestion_id(count + 1);
		Question q1 = q;
		getCurrentSession().save(q1);
		
		return q1;
	}

	
}
