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

	JLabel jLabelCourse = new JLabel("�γ̺�:");
	JLabel jLabelName = new JLabel("����:");
	JLabel jLabelSex = new JLabel("�Ա�");
	JLabel jLabelMajor = new JLabel("רҵ");
	JRadioButton jRadioButton01 = new JRadioButton("��");
	JRadioButton jRadioButton02 = new JRadioButton("Ů");
	JTextField jtfCourse = new JTextField(11);
	JTextField jtfName = new JTextField(11); 
	JTextField jtfMajor = new JTextField(11);  //�����ʾѧ����רҵ
	JButton jbtSave = new JButton("����");
	JButton  jbtCancel = new JButton("ȡ��");
	JPanel jPanel = new JPanel();
	JPanel jPanel2 = new JPanel();
	ButtonGroup group = new ButtonGroup();
	public AddStudentDialog(JFrame owner) {
		super(owner,"���ѧ��");
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
		
	//�ⲿ����ע�������

		jbtSave.addActionListener(this);
		jbtCancel.addActionListener(this);
		
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== jbtSave){
			if(jtfName.getText().length()==0){
				JOptionPane.showMessageDialog(null,"��û����������");
				jbtSave.setEnabled(false);
				return ;
			}
			else if(jtfCourse.getText().length()==0){
				JOptionPane.showMessageDialog(null,"��û������ѧ��");
				jbtSave.setEnabled(false);
				return;
			}else if(jtfMajor.getText().length()==0){
				JOptionPane.showMessageDialog(null, "��û������רҵ");
				jbtSave.setEnabled(false);
				return ;
			}
			
		}
		else if(e.getSource()==jbtCancel){
			//������ǵ�����ȡ����ʱ����൱�ڰ����������ر���
			this.dispose();
		}
		
	}
	

}
