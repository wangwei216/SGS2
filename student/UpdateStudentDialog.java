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
	JButton jButtonSave = new JButton("ȷ���޸�");
	JButton jButtonCancel = new JButton("ȡ���޸�");
	JTable jTable = new JTable(); //��֪���������������ʲô
	JPanel jPanel2 = new JPanel();
	JLabel jLabelCourse = new JLabel("�����ѯ�Ŀγ̺�:");  //��֮ǰ��jLableNo ���ĳɿγ̺�
	JTextField jtfCourse = new JTextField(10);						//��jtfNo ���ĳ�jtfCourse
	JButton jButtonQuery = new JButton("ȷ����ѯ");
	
	public UpdateStudentDialog(JFrame owner) {
		super(owner,"ѧ���޸�");
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		
		jPanel2.add(jLabelCourse);
		jPanel2.add(jtfCourse);
		jPanel2.add(jButtonQuery);
		getContentPane().add(jPanel2,BorderLayout.NORTH);
		//�����������javaд����һ���Զ���ı��
		TableModel jTableModel = new 
				DefaultTableModel(new String[0][0],new String[]{"ѧ������","�γ̺�","רҵ"});
		jTable = new JTable();
		jTable.setModel(jTableModel);
		JScrollPane jScrollPane1 = new JScrollPane(jTable);
		getContentPane().add(jScrollPane1, BorderLayout.CENTER);		
		
		jPanel.add(jButtonSave);
		jPanel.add(jButtonCancel);
		getContentPane().add(jPanel , BorderLayout.SOUTH);
		//�������Ϊ��ѯ��ťע�������
		jButtonQuery.addActionListener(this);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jButtonQuery){
			if(jtfCourse.getText().length()==0){
				JOptionPane.showMessageDialog(null, "������γ̺�");
				return ;
			}
			//������൱�ڵ��ÿγ̵����ݿ⣬�����������ݿ����������ʱ���ͻ����
			Course course = SGS.courseCatalog.findCourse(jButtonQuery.getText());
			//���course����û�����ݵ�ʱ�� �͸�����ʾ����Ŀγ��Ҳ���
			if(course==null){
				JOptionPane.showMessageDialog(null, "������Ŀγ̺�����");
				return;
			}
			
			DefaultTableModel tm = new DefaultTableModel(new String[0][0] ,	new String[] { "ѧ��", "����","�ɼ�" });
			jTable.setModel(tm);
			ArrayList<Student>  studentList = course.getStudentList();
			for(Student  s : studentList){
				int grade = course.findScore(s.getUserNo()).getGrade();
				tm.addRow(new String[]{s.getUserNo(),s.getName(),String.valueOf(grade)});
			}		
		}
		
	}

}
