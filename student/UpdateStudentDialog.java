package student;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sun.org.apache.xerces.internal.dom.DeferredDOMImplementationImpl;

import sun.tools.jar.resources.jar_zh_TW;

public class UpdateStudentDialog extends JDialog implements ActionListener{

	JPanel jPanel = new JPanel();
	JButton jButtonSave = new JButton("确定修改");
	JButton jButtonCancel = new JButton("取消修改");
	JTable jTable = new JTable(); //不知道这个参数里面有什么
	JPanel jPanel2 = new JPanel();
	JLabel jLabelNo = new JLabel("输入你要查询的学号:");
	JTextField jtfNo = new JTextField(10);
	JButton jButtonQuery = new JButton("确定查询");
	
	public UpdateStudentDialog(JFrame owner) {
		super(owner,"学生修改");
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		
		jPanel2.add(jLabelNo);
		jPanel2.add(jtfNo);
		jPanel2.add(jButtonQuery);
		getContentPane().add(jPanel2,BorderLayout.NORTH);
		//下面是如何用java写出来一个自定义的表格
		TableModel jTableModel = new 
				DefaultTableModel(new String[0][0],new String[]{"学生姓名","学号","专业"});
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
		// TODO 自动生成的方法存根
		
	}

}
