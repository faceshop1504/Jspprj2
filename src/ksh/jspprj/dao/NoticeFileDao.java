package ksh.jspprj.dao;

import java.util.List;

import ksh.jspprj.model.NoticeFile;

public interface NoticeFileDao {
	public List<NoticeFile> getNoticeFiles(String NoticeCode);
	public int insert(NoticeFile file);
}
