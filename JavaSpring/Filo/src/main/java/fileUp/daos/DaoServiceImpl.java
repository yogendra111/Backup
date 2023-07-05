package fileUp.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fileUp.entities.UploadedFile;

@Service
public class DaoServiceImpl implements DaoService{
	
	@Autowired
	private Dao dao;

	@Override
	public void uploadFile(UploadedFile f) {
		dao.addRecord(f);		
	}
}
