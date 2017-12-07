package main;

import java.util.ArrayList;
import java.util.HashMap;

import common.SGSDataAccess;
import common.SGSInitializationException;
import common.SGSPersistenceException;

import course.Course;
import course.CourseCatalog;
import score.Score;
import student.Student;
import user.Admin;
import user.Teacher;
import user.User;
public class SGS {
	public static User currentUser ;
	public static Admin admin ;
	public static HashMap<String,Teacher> faculty;//ȫ���ʦ
	public static HashMap<String,Student> school;//ȫ��ѧ��
	public static CourseCatalog  courseCatalog ;//����Ŀ¼
//	//��ʼ��ȫ���ʦ
//	public static void initFaculty(){
//		faculty = new HashMap<String,Teacher>();
//		faculty.put("t001", new Teacher("t001","tom"));
//		faculty.put("t002", new Teacher("t002","alice"));
//	}
//	//��ʼ��ȫ��ѧ��
//	public static void initSchool(){
//		school = new HashMap<String,Student>();
//		school.put("s001", new Student("s001","john"));
//		school.put("s002", new Student("s002","bill"));
//		school.put("s003", new Student("s003","mary"));
//	}
//	//��ʼ������Ŀ¼
//	public static void initCourseCatalog(){
//		initFaculty();
//		initSchool();
//		courseCatalog = new CourseCatalog();
//		
//		Teacher  t1 = faculty.get("t001");
//		Course  c1 = new Course("c001", "Java", 6, 2011, 2, t1);
//		c1.addStudent(school.get("s001"));
//		c1.addStudent(school.get("s002"));
//		courseCatalog.addCourse(c1);	
//		c1.setScore(new Score("s001","c001",90));
//		c1.setScore(new Score("s002","c001",70));
//
//		Teacher  t2 = faculty.get("t002");
//		Course  c2 = new Course("c002", "���ݽṹ", 4, 2011, 2, t2);
//		c2.addStudent(school.get("s001"));
//		c2.addStudent(school.get("s003"));
//		courseCatalog.addCourse(c2);	
//		c2.setScore(new Score("s001","c002",60));
//		c2.setScore(new Score("s003","c002",85));
//	}
//	//��Ϊ���ɲ��������ļ�ʹ��
//	public static void createDataFile(){
//		admin = new Admin("a001","admin"); 
//		initCourseCatalog();
//		try {
//			SGSDataAccess.persistenceAdmin(admin);
//			SGSDataAccess.persistenceFaculty(faculty);
//			SGSDataAccess.persistenceStudent(school);
//			SGSDataAccess.persistenceCourseCatalog(courseCatalog);
//		} catch (SGSPersistenceException e) {
//			// TODO �Զ����� catch ��
//			e.printStackTrace();
//		}
//	}
	public static void main(String[] args){
//		createDataFile();
		try {
			admin = SGSDataAccess.initAdmin();
			faculty = SGSDataAccess.initFaculty();
			school = SGSDataAccess.initSchool();
			courseCatalog = SGSDataAccess.initCourseCatalog();
		} catch (SGSInitializationException e) {
			e.printStackTrace();
			System.exit(0);
		}
		new MainFrame();
	}
}
