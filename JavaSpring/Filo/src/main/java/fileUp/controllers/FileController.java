package fileUp.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fileUp.daos.DaoServiceImpl;
import fileUp.entities.UploadedFile;

@Controller
public class FileController {
	
	@Autowired
	private DaoServiceImpl daos;
	
    @RequestMapping(value="savefile",method=RequestMethod.POST)  
	public ModelAndView saveFile(@RequestParam CommonsMultipartFile file, HttpSession session) {
    	String filename = file.getOriginalFilename(); 
        System.out.println("uploaded "+filename + ", " + file.getSize() + ", " + file.getContentType());
        
        UploadedFile newFile = new UploadedFile();
        newFile.setFileName(filename);
        newFile.setFileSize(file.getSize());
        newFile.setFileType(file.getContentType());
        newFile.setData(file.getBytes());
        daos.uploadFile(newFile);
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("uploadSuccess");
        mv.addObject("filename", filename);
        return mv;
	}

}
