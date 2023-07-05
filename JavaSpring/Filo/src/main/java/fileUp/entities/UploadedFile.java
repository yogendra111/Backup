package fileUp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class UploadedFile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(name = "File_Name")
	String fileName;

	@Column(name = "Size")
	long fileSize;

	@Column(name = "Type")
	String fileType;

	@Lob
	@Column(name = "Data")
	byte[] data;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public UploadedFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UploadedFile(int id, String fileName, long fileSize, String fileType, byte[] data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.data = data;
	}

}
