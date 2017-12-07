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

import student.Student;

import course.Course;

import main.SGS;


public class QueryScoreDialog extends JDialog implements ActionListener{
	private JTextField jtfCourseNo;
	private JButton jbtQuery;
	private JTable jTable1;
	public QueryScoreDialog(JFrame owner){
		super(owner,"成绩查询");
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		JPanel jPanel1 = new JPanel();
		jtfCourseNo = new JTextField(10);
		jbtQuery = new JButton("查询");
		jPanel1.add(new JLabel("课程号："));
		jPanel1.add(jtfCourseNo);
		jPanel1.add(jbtQuery);
		getContentPane().add(jPanel1, BorderLayout.NORTH);

		TableModel jTable1Model = new DefaultTableModel(new String[0][0] ,	new String[] { "学号", "姓名","成绩" });
		jTable1 = new JTable();
		jTable1.setModel(jTable1Model);
		JScrollPane jScrollPane1 = new JScrollPane(jTable1);
		getContentPane().add(jScrollPane1, BorderLayout.CENTER);		
		

		jbtQuery.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
			if(jtfCourseNo.getText().length()==0){
				JOptionPane.showMessageDialog(null, "请输入课程号！");
				return ;
			}
			Course course = SGS.courseCatalog.findCourse(jtfCourseNo.getText());
			if(course==null){
				JOptionPane.showMessageDialog(null, "课程号不存在！");
				return ;				
			}
			DefaultTableModel tm = new DefaultTableModel(new String[0][0] ,	new String[] { "学号", "姓名","成绩" });
			jTable1.setModel(tm);
			ArrayList<Student>  studentList = course.getStudentList();
			for(Student  s : studentList){
				int grade = course.findScore(s.getUserNo()).getGrade();
				tm.addRow(new String[]{s.getUserNo(),s.getName(),String.valueOf(grade)});
			}		
	}
}
