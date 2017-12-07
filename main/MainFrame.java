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
	
	JMenu   userMenu = new JMenu("�û�����");
	JMenuItem  teacherMenuItem = new JMenuItem("��ʦ�û�����");
	JMenuItem  passMenuItem = new JMenuItem("�޸�����");
	JMenuItem  exitMenuItem = new JMenuItem("�˳�ϵͳ");

	JMenu   gradeMenu = new JMenu("�ɼ�����");
	JMenuItem inputMenuItem = new JMenuItem("�ɼ�¼��");
	JMenuItem queryMenuItem = new JMenuItem("�ɼ���ѯ");

	JMenu   courseMenu = new JMenu("�γ̹���");
	JMenuItem courseCatalogMenuItem = new JMenuItem("����Ŀ¼����");
	JMenuItem studentListMenuItem = new JMenuItem("�γ���������");
	
	JMenu   studentMenu = new JMenu("ѧ������");
	JMenuItem addStudentMenuItem = new JMenuItem("���ѧ��");
	JMenuItem updateStudentMenuItem = new JMenuItem("ѧ���޸�");
	JMenuItem queryStudentMenuItem = new JMenuItem("ѧ����ѯ");
	
	JLabel  welcomeLabel = new JLabel("����ѧ���ɼ�����ϵͳ");
	
	LoginDialog  loginDialog ;
	InputScoreDialog inputScoreDialog;
	QueryScoreDialog queryScoreDialog;
	//����ط�ÿ�����¼�һ���Ӳ˵���ʱ����Ҫ���½�һ���Ǹ����ܵĻỰ��
	AddStudentDialog addStudentDialog;
	UpdateStudentDialog updateStudentDialog;
	QueryStudentDialog queryStudentDialog;
	
	
	
	
	
	public MainFrame(){
		this.setTitle("ѧ���ɼ�����ϵͳ");
		//�������˵�
		this.setJMenuBar(menubar);
		menubar.add(userMenu);
		menubar.add(gradeMenu);
		menubar.add(courseMenu);
		menubar.add(studentMenu);
		//�����û�����˵�
		userMenu.add(teacherMenuItem);
		userMenu.add(passMenuItem);
		userMenu.add(exitMenuItem);
		//����ɼ�����˵�
		gradeMenu.add(inputMenuItem);
		gradeMenu.add(queryMenuItem);
		//����γ̹���˵�
		courseMenu.add(courseCatalogMenuItem);
		courseMenu.add(studentListMenuItem);
		//����ѧ������˵�
		studentMenu.add(addStudentMenuItem);  //��������Ѿ�ʵ��
		studentMenu.add(updateStudentMenuItem);//���ҳ�湦���Ѿ�ʵ��
		studentMenu.add(queryStudentMenuItem);
		//���컶ӭҳ��
		welcomeLabel.setFont(new java.awt.Font("DialogInput", 1, 48));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(Color.blue);
		this.getContentPane().add(welcomeLabel);

		//������������¼�Ի���
		loginDialog = new LoginDialog(this);

		//Ϊ���˵�ע�������
		exitMenuItem.addActionListener(this);
		passMenuItem.addActionListener(this);
		inputMenuItem.addActionListener(this);
		queryMenuItem.addActionListener(this);
		//����ÿ������һ������֮�󻹶���ҪΪ�Ǹ��˵������Ӳ˵���ע��һ��������
		/////////////////////////////////////////////////////////////////////////
		addStudentMenuItem.addActionListener(this);
		updateStudentMenuItem.addActionListener(this);
		queryStudentMenuItem.addActionListener(this);
		
			
		//��ʾϵͳ������
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		//���˵�����
		if(e.getSource()==exitMenuItem){//�˳�ϵͳ
			if(JOptionPane.showConfirmDialog(this, "ȷ��Ҫ�˳�ϵͳ��","�˳�",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				System.exit(0);
			}			
		}else if(e.getSource()==inputMenuItem){//¼��ɼ�
			//�����ɼ�¼�����
			if(inputScoreDialog==null){
				inputScoreDialog = new InputScoreDialog(this);
			}
			inputScoreDialog.setVisible(true);
		}else if(e.getSource()==queryMenuItem){//��ѯ�ɼ�
			//�����ɼ���ѯ���
			if(queryScoreDialog==null){
				queryScoreDialog = new QueryScoreDialog(this);
			}
			queryScoreDialog.setVisible(true);
		}
////////////////////////////////////////////////////////////
		else if(e.getSource()==addStudentMenuItem){
			//����һ��ѧ����������е����ѧ���������
			if(addStudentDialog==null){
				addStudentDialog = new AddStudentDialog(this);
			}
			addStudentDialog.setVisible(true);
		}
		else if(e.getSource()==updateStudentMenuItem){
			//����һ��ѧ����������е�ѧ���޸Ĺ������
			if(updateStudentDialog==null){
				updateStudentDialog = new UpdateStudentDialog(this);
			}
			updateStudentDialog.setVisible(true);
		}
		else if(e.getSource()==queryStudentMenuItem){
			//����һ��ѧ����������е�ѧ����ѯ�������
			if(queryScoreDialog==null){
				queryStudentDialog = new QueryStudentDialog(this);
			}
			queryStudentDialog.setVisible(true);
		}
		
	}
}
