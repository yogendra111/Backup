package fileUp.daos;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import fileUp.entities.UploadedFile;

@Repository
public class Dao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addRecord(UploadedFile f) {
		hibernateTemplate.save(f);
	}

}
