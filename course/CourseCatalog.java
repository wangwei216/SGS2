package course;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import score.Score;

public class CourseCatalog implements Serializable{

	private HashMap<String, Course> courses;

	public CourseCatalog() {
			courses = new HashMap<String, Course>();
	}

	public void addCourse(Course c) {
		String key = c.getCourseNo();
		courses.put(key, c);
	}

	public Course findCourse(String courseNo) {
		return courses.get(courseNo);
	}
	//根据学号查询该学生的成绩单
	public ArrayList<HashMap<String, String>>  findTranscript(String studentNo){
		ArrayList<HashMap<String, String>>  transcript = new ArrayList<HashMap<String, String>>();
		Collection<Course>  c = courses.values();
		for(Course course : c){
			Score score = course.findScore(studentNo);
			if(score!=null){
				int grade = score.getGrade();
				HashMap<String, String>  hs = new HashMap<String, String>();
				hs.put("courseNo", course.getCourseNo());
				hs.put("courseName", course.getCourseName());
				hs.put("grade", String.valueOf(grade));
				transcript.add(hs);
			}
		}
		return transcript;
	}
}
