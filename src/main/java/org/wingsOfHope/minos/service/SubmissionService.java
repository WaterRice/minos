/**  

* 创建时间：2019年4月10日 下午10:24:23  

* 项目名称：minos  

* @author 罗强  

* @version 1.0   

* @since JDK 1.8  

* 文件名称：SubmissionService.java  

* 类说明：  

*/

package org.wingsOfHope.minos.service;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wingsOfHope.minos.entity.Submission;
import org.wingsOfHope.minos.mapper.SubmissionMapper;

@Service
public class SubmissionService {

	@Autowired
	private SubmissionMapper submissionMapper;
	
	public Submission findById(Integer id) throws Exception {
		return submissionMapper.findById(id);
	}
	
	public Integer save(Submission submission) throws Exception {
		submission.setTime(System.currentTimeMillis());
		submissionMapper.save(submission);
		return submission.getId();
	}
	
	public List<Submission> getAllSubmissionsByHid(Integer hid) throws Exception {
		return submissionMapper.getAllSubmissionsByHid(hid);
	}
	
	public Boolean updateGrade(Integer id, Integer grade) throws Exception {
		submissionMapper.updateGrade(grade, id);
		return true;
	}
	
	public boolean exist(Integer studentId, Integer homeworkId) throws Exception {
		return submissionMapper.exist(studentId, homeworkId) == null ? false : true;
	}
	
	public ByteArrayOutputStream getGradesSheet(Integer hid) throws Exception {	
		List<Submission> submissions = submissionMapper.getGradesSheet(hid);
		Collections.sort(submissions, new Comparator<Submission>() {
			public int compare(Submission o1, Submission o2) {
				if(o1.getGrade() < o2.getGrade()) return -1;
				else if(o1.getGrade() == o2.getGrade()) return 0;
				else return 1;
			}
			
		});
		ByteArrayOutputStream out = null;	
		XSSFWorkbook workbook = new XSSFWorkbook();		
		XSSFSheet sheet = workbook.createSheet("作业" + hid + "成绩表");	
		XSSFRow header = sheet.createRow(0);	
		String[] headers = {"学号","姓名","成绩"};	
		for(int i = 0; i < headers.length; i++) {
			XSSFCell cell = header.createCell(i);
			cell.setCellValue(headers[i]);
		}	
		int row = 0;
		for(Submission submission : submissions) {
			XSSFRow datarow = sheet.createRow(++row);
			datarow.createCell(0).setCellValue(submission.getStudentId());
			datarow.createCell(1).setCellValue(submission.getStudent().getName());
			datarow.createCell(2).setCellValue(submission.getGrade());
		}
		out = new ByteArrayOutputStream();
		workbook.write(out);
		workbook.close();
		return out;
	}
	
}
