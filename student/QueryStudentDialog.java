package student;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sun.javafx.tk.Toolkit.ImageAccessor;
import com.sun.org.apache.xpath.internal.operations.String;

public class QueryStudentDialog extends JDialog implements ActionListener{

	JLabel jLabelNo = new JLabel("ѧ��ѧ��");
	JTextField jtfNo = new JTextField(10);
	JButton jbtQuery = new JButton("��ѯ");
	
	public QueryStudentDialog(JFrame owner) {
		
		super(owner,"��ѯѧ��");
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		
		JPanel jPanel01 = new JPanel();
		jPanel01.add(jLabelNo);
		jPanel01.add(jtfNo);
		jPanel01.add(jbtQuery);
		getContentPane().add(jPanel01,BorderLayout.NORTH);
		//����һ�����֮ǰ��Ҫ�ȶ���һ��ʧ�ܵ�TableModel��
		TableModel jtableModel = new DefaultTableModel(new String[0][0], new String[] { });
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		
	}

}
