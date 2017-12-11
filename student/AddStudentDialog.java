package student;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import sun.awt.image.PixelConverter.Bgrx;
import sun.net.www.content.image.jpeg;
import sun.text.resources.bg.JavaTimeSupplementary_bg;

public class AddStudentDialog extends JDialog implements ActionListener{

	JLabel jLabelCourse = new JLabel("课程号:");
	JLabel jLabelName = new JLabel("姓名:");
	JLabel jLabelSex = new JLabel("性别");
	JLabel jLabelMajor = new JLabel("专业");
	JRadioButton jRadioButton01 = new JRadioButton("男");
	JRadioButton jRadioButton02 = new JRadioButton("女");
	JTextField jtfCourse = new JTextField(11);
	JTextField jtfName = new JTextField(11); 
	JTextField jtfMajor = new JTextField(11);  //这个表示学生的专业
	JButton jbtSave = new JButton("保存");
	JButton  jbtCancel = new JButton("取消");
	JPanel jPanel = new JPanel();
	JPanel jPanel2 = new JPanel();
	ButtonGroup group = new ButtonGroup();
	public AddStudentDialog(JFrame owner) {
		super(owner,"添加学生");
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		

		jPanel.add(jLabelName);
		jPanel.add(jtfName);
		jPanel.add(jLabelCourse);
		jPanel.add(jtfCourse);
		jPanel.add(jLabelSex);
		jPanel.add(jRadioButton01);
		jPanel.add(jRadioButton02);
		jPanel.add(jLabelMajor);
		jPanel.add(jtfMajor);
		group.add(jRadioButton01);
		group.add(jRadioButton02);

		getContentPane().add(jPanel,BorderLayout.CENTER);
		jPanel2.add(jbtSave);
		jPanel2.add(jbtCancel);
		getContentPane().add(jPanel2, BorderLayout.SOUTH);
		
	//这部分是注册监听器

		jbtSave.addActionListener(this);
		jbtCancel.addActionListener(this);
		
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== jbtSave){
			if(jtfName.getText().length()==0){
				JOptionPane.showMessageDialog(null,"你没有输入姓名");
				jbtSave.setEnabled(false);
				return ;
			}
			else if(jtfCourse.getText().length()==0){
				JOptionPane.showMessageDialog(null,"你没有输入学号");
				jbtSave.setEnabled(false);
				return;
			}else if(jtfMajor.getText().length()==0){
				JOptionPane.showMessageDialog(null, "你没有输入专业");
				jbtSave.setEnabled(false);
				return ;
			}
			
		}
		else if(e.getSource()==jbtCancel){
			//这个就是当你点击取消的时候就相当于把这个界面给关闭了
			this.dispose();
		}
		
	}
	

}
