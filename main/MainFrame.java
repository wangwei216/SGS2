package main;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import score.InputScoreDialog;
import score.QueryScoreDialog;
import user.LoginDialog;

import student.*;
public class MainFrame extends JFrame implements ActionListener{
	JMenuBar  menubar = new JMenuBar();
	
	JMenu   userMenu = new JMenu("用户管理");
	JMenuItem  teacherMenuItem = new JMenuItem("教师用户管理");
	JMenuItem  passMenuItem = new JMenuItem("修改密码");
	JMenuItem  exitMenuItem = new JMenuItem("退出系统");

	JMenu   gradeMenu = new JMenu("成绩管理");
	JMenuItem inputMenuItem = new JMenuItem("成绩录入");
	JMenuItem queryMenuItem = new JMenuItem("成绩查询");

	JMenu   courseMenu = new JMenu("课程管理");
	JMenuItem courseCatalogMenuItem = new JMenuItem("开课目录管理");
	JMenuItem studentListMenuItem = new JMenuItem("课程名单管理");
	
	JMenu   studentMenu = new JMenu("学生管理");
	JMenuItem addStudentMenuItem = new JMenuItem("添加学生");
	JMenuItem updateStudentMenuItem = new JMenuItem("学生修改");
	JMenuItem queryStudentMenuItem = new JMenuItem("学生查询");
	
	JLabel  welcomeLabel = new JLabel("××学生成绩管理系统");
	
	LoginDialog  loginDialog ;
	InputScoreDialog inputScoreDialog;
	QueryScoreDialog queryScoreDialog;
	//这个地方每次你新加一个子菜单的时候都需要重新建一个那个功能的会话框
	AddStudentDialog addStudentDialog;
	UpdateStudentDialog updateStudentDialog;
	QueryStudentDialog queryStudentDialog;
	
	
	
	
	
	public MainFrame(){
		this.setTitle("学生成绩管理系统");
		//构造主菜单
		this.setJMenuBar(menubar);
		menubar.add(userMenu);
		menubar.add(gradeMenu);
		menubar.add(courseMenu);
		menubar.add(studentMenu);
		//构造用户管理菜单
		userMenu.add(teacherMenuItem);
		userMenu.add(passMenuItem);
		userMenu.add(exitMenuItem);
		//构造成绩管理菜单
		gradeMenu.add(inputMenuItem);
		gradeMenu.add(queryMenuItem);
		//构造课程管理菜单
		courseMenu.add(courseCatalogMenuItem);
		courseMenu.add(studentListMenuItem);
		//构造学生管理菜单
		studentMenu.add(addStudentMenuItem);  //这个功能已经实现
		studentMenu.add(updateStudentMenuItem);//这个页面功能已经实现
		studentMenu.add(queryStudentMenuItem);
		//构造欢迎页面
		welcomeLabel.setFont(new java.awt.Font("DialogInput", 1, 48));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(Color.blue);
		this.getContentPane().add(welcomeLabel);

		//创建并弹出登录对话框
		loginDialog = new LoginDialog(this);

		//为主菜单注册监听器
		exitMenuItem.addActionListener(this);
		passMenuItem.addActionListener(this);
		inputMenuItem.addActionListener(this);
		queryMenuItem.addActionListener(this);
		//而且每次新增一个功能之后还都需要为那个菜单栏的子菜单中注册一个监听器
		/////////////////////////////////////////////////////////////////////////
		addStudentMenuItem.addActionListener(this);
		updateStudentMenuItem.addActionListener(this);
		queryStudentMenuItem.addActionListener(this);
		
			
		//显示系统主界面
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		//主菜单控制
		if(e.getSource()==exitMenuItem){//退出系统
			if(JOptionPane.showConfirmDialog(this, "确认要退出系统？","退出",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				System.exit(0);
			}			
		}else if(e.getSource()==inputMenuItem){//录入成绩
			//创建成绩录入面板
			if(inputScoreDialog==null){
				inputScoreDialog = new InputScoreDialog(this);
			}
			inputScoreDialog.setVisible(true);
		}else if(e.getSource()==queryMenuItem){//查询成绩
			//创建成绩查询面板
			if(queryScoreDialog==null){
				queryScoreDialog = new QueryScoreDialog(this);
			}
			queryScoreDialog.setVisible(true);
		}
////////////////////////////////////////////////////////////
		else if(e.getSource()==addStudentMenuItem){
			//创建一个学生管理面板中的添加学生功能面板
			if(addStudentDialog==null){
				addStudentDialog = new AddStudentDialog(this);
			}
			addStudentDialog.setVisible(true);
		}
		else if(e.getSource()==updateStudentMenuItem){
			//创建一个学生管理面板中的学生修改功能面板
			if(updateStudentDialog==null){
				updateStudentDialog = new UpdateStudentDialog(this);
			}
			updateStudentDialog.setVisible(true);
		}
		else if(e.getSource()==queryStudentMenuItem){
			//创建一个学生管理面板中的学生查询功能面板
			if(queryScoreDialog==null){
				queryStudentDialog = new QueryStudentDialog(this);
			}
			queryStudentDialog.setVisible(true);
		}
		
	}
}
