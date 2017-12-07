package course;
import java.io.Serializable;
import java.util.*;
import score.Score;
import student.Student;
import user.Teacher;

public class Course implements Serializable{
	private String courseNo;
	private String courseName;
	private int credit;
	private int semster;
	private int period;
	private Teacher  teacher;
	private HashMap<String,Score>  scoreBook;	
	private ArrayList<Student> studentList;


	public Course(String courseNo,String courseName,int credit,int semster,int period,Teacher teacher){
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.credit = credit;
		this.semster = semster;
		this.period = period;
		this.teacher = teacher;
		scoreBook = new HashMap<String ,Score>();
		studentList = new ArrayList<Student>();
	}

	public String getCourseNo() {
			return courseNo;
	}
	public String getCourseName() {
		return courseName;
	}	
	
	public void setScore(Score  s){
		if(scoreBook.containsKey(s.getStudentNo())){
			scoreBook.put(s.getStudentNo(), s);
		}
	}

	public Score findScore(String studentNo){
		return scoreBook.get(studentNo);
	}
	public void addStudent(Student student){
		studentList.add(student);
		scoreBook.put(student.getUserNo(), new Score(student.getUserNo(),this.courseNo,0));
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}	
	public void display(){
		System.out.println("************************");
		System.out.println("课程号: "+this.courseNo+" 课程名称: "+this.courseName);
		System.out.println("成绩单：");
		System.out.println("学号：\t   姓名：\t 成绩：\t");
		for(int i=0;i<studentList.size();i++){
			Student s = studentList.get(i);
			System.out.print(s.getUserNo()+"\t"+s.getName()+"\t");
			System.out.println(this.findScore(s.getUserNo()).getGrade());
		}
		System.out.println();
		System.out.println("************************");
	}
}
