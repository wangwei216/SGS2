package score;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import common.SGSDataAccess;
import common.SGSPersistenceException;

import student.Student;

import course.Course;

import main.SGS;


public class InputScoreDialog extends JDialog implements ActionListener{
	private JTextField jtfCourseNo;
	private JButton jbtCancel;
	private JButton jbtSave;
	private JButton jbtInput;
	private JTable jTable1;
	private Course course;
	public InputScoreDialog(JFrame owner){
		super(owner,"�ɼ�¼��");
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		JPanel jPanel1 = new JPanel();
		jtfCourseNo = new JTextField(10);
		jbtInput = new JButton("��ʼ¼��");
		jPanel1.add(new JLabel("�γ̺ţ�"));
		jPanel1.add(jtfCourseNo);
		jPanel1.add(jbtInput);
		getContentPane().add(jPanel1, BorderLayout.NORTH);

		JPanel jPanel2 = new JPanel();
		jbtSave = new JButton("����");
		jbtCancel = new JButton("ȡ��");
		jPanel2.add(jbtSave);
		jPanel2.add(jbtCancel);		
		getContentPane().add(jPanel2, BorderLayout.SOUTH);

		TableModel jTable1Model = new DefaultTableModel(new String[0][0] ,	new String[] { "ѧ��", "����","�ɼ�" });
		jTable1 = new JTable();
		jTable1.setModel(jTable1Model);
		JScrollPane jScrollPane1 = new JScrollPane(jTable1);
		getContentPane().add(jScrollPane1, BorderLayout.CENTER);		
		
		jbtSave.setEnabled(false);
		jbtInput.addActionListener(this);
		jbtSave.addActionListener(this);
		jbtCancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtInput){
			//�ɼ�¼��
			if(jtfCourseNo.getText().length()==0){
				JOptionPane.showMessageDialog(null, "������γ̺ţ�");
				jbtSave.setEnabled(false);
				return ;
			}
			course = SGS.courseCatalog.findCourse(jtfCourseNo.getText());
			if(course==null){
				JOptionPane.showMessageDialog(null, "�γ̺Ų����ڣ�");
				jbtSave.setEnabled(false);
				return ;				
			}
			DefaultTableModel tm = new DefaultTableModel(new String[0][0] ,	new String[] { "ѧ��", "����","�ɼ�" });
			jTable1.setModel(tm);
			ArrayList<Student>  studentList = course.getStudentList();
			for(Student  s : studentList){
				int grade = course.findScore(s.getUserNo()).getGrade();
				tm.addRow(new String[]{s.getUserNo(),s.getName(),String.valueOf(grade)});
			}
			jbtSave.setEnabled(true);
		}else if(e.getSource()==jbtSave){
			//�ɼ�����
			DefaultTableModel   tm = (DefaultTableModel)jTable1.getModel() ;
			Vector datas = tm.getDataVector();
			for(int i=0;i<datas.size();i++){
				Vector v = (Vector)datas.get(i);
				String studentNo = (String)v.get(0);
				String grade =  (String)v.get(2);
				Score  score = new Score(studentNo,course.getCourseNo(),Integer.parseInt(grade));
				course.setScore(score);
			}
			try {
				SGSDataAccess.persistenceCourseCatalog(SGS.courseCatalog);
				JOptionPane.showMessageDialog(null, "�ɼ�����ɹ���");
				jbtSave.setEnabled(false);
			} catch (SGSPersistenceException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "�ɼ�����ʧ�ܣ�");
			}			
		}else if(e.getSource()==jbtCancel){
			this.dispose();
		}
		
	}
}
