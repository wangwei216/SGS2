package score;

import java.io.Serializable;

public class Score implements Serializable{
	private String studentNo;
	private String courseNo;
	private int grade;
	public Score(String studentNo,String courseNo,int grade){
		this.studentNo = studentNo;
		this.courseNo = courseNo;
		this.grade = grade;
	}
	public String getStudentNo() {
		return this.studentNo;
	}
	public int getGrade() {
		return grade;
	}
	public String getCourseNo() {
		return courseNo;
	}
	
}
