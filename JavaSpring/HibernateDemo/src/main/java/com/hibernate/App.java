package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources().buildMetadata(ssr);
//        SessionFactory sessionFactory = metadata.buildSessionFactory();
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Question q1 = new Question();
        q1.setQuestion("How are you!");
        Question q2 = new Question();
        q2.setQuestion("Who are you!");
        Answer a1 = new Answer();
        a1.setAnswer("I am fine.");
//        a1.setQuestion(q1);
        
        Answer a2 = new Answer();
        a2.setAnswer("Tumse Matlab!!");
//        a2.setQuestion(q1);
        
        List<Question> questions = new ArrayList<Question>();
        questions.add(q1);
        questions.add(q2);
        
        List<Answer> answers = new ArrayList<Answer>();
        answers.add(a1);
        answers.add(a2);
        
        q1.setAnswers(answers);
//        a2.setQuestions(questions);
//        q1.setAnswer(a1);
//        q2.setAnswer(a1);
        
        session.persist(q1);
        session.persist(q2);
        session.persist(a1);
        session.persist(a2);
        
//        Question q = session.get(Question.class, 1);
//        
//        for(Answer a: q.getAnswers()) {
//        	System.out.println(a.getAnswer());
//        }

        transaction.commit();
        
        session.close();
        sessionFactory.close();
        
        
        
    }
}
