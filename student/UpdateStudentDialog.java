package student;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sun.org.apache.xerces.internal.dom.DeferredDOMImplementationImpl;

import course.Course;
import main.SGS;
import sun.tools.jar.resources.jar_zh_TW;

public class UpdateStudentDialog extends JDialog implements ActionListener{

	JPanel jPanel = new JPanel();
	JButton jButtonSave = new JButton("确定修改");
	JButton jButtonCancel = new JButton("取消修改");
	JTable jTable = new JTable(); //不知道这个参数里面有什么
	JPanel jPanel2 = new JPanel();
	JLabel jLabelCourse = new JLabel("输入查询的课程号:");  //把之前的jLableNo 都改成课程号
	JTextField jtfCourse = new JTextField(10);						//把jtfNo 都改成jtfCourse
	JButton jButtonQuery = new JButton("确定查询");
	
	public UpdateStudentDialog(JFrame owner) {
		super(owner,"学生修改");
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		
		jPanel2.add(jLabelCourse);
		jPanel2.add(jtfCourse);
		jPanel2.add(jButtonQuery);
		getContentPane().add(jPanel2,BorderLayout.NORTH);
		//下面是如何用java写出来一个自定义的表格
		TableModel jTableModel = new 
				DefaultTableModel(new String[0][0],new String[]{"学生姓名","课程号","专业"});
		jTable = new JTable();
		jTable.setModel(jTableModel);
		JScrollPane jScrollPane1 = new JScrollPane(jTable);
		getContentPane().add(jScrollPane1, BorderLayout.CENTER);		
		
		jPanel.add(jButtonSave);
		jPanel.add(jButtonCancel);
		getContentPane().add(jPanel , BorderLayout.SOUTH);
		//下面就是为查询按钮注册监听器
		jButtonQuery.addActionListener(this);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jButtonQuery){
			if(jtfCourse.getText().length()==0){
				JOptionPane.showMessageDialog(null, "请输入课程号");
				return ;
			}
			//这个就相当于调用课程的数据库，当你输入数据库里面的数据时，就会调用
			Course course = SGS.courseCatalog.findCourse(jButtonQuery.getText());
			//如果course里面没有内容的时候 就给个提示输入的课程找不到
			if(course==null){
				JOptionPane.showMessageDialog(null, "你输入的课程号有误");
				return;
			}
			
			DefaultTableModel tm = new DefaultTableModel(new String[0][0] ,	new String[] { "学号", "姓名","成绩" });
			jTable.setModel(tm);
			ArrayList<Student>  studentList = course.getStudentList();
			for(Student  s : studentList){
				int grade = course.findScore(s.getUserNo()).getGrade();
				tm.addRow(new String[]{s.getUserNo(),s.getName(),String.valueOf(grade)});
			}		
		}
		
	}

}
