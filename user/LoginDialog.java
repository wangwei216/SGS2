package user;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.SGS;

public class LoginDialog extends JDialog implements ActionListener{
	JTextField  jtfUser = new JTextField(10);
	JPasswordField  jtfPass = new JPasswordField(10);
	JComboBox  jcbUserType = new JComboBox();
	JButton   jbtOk = new JButton("登录");
	JButton   jbtCancel = new JButton("退出");
	public LoginDialog(JFrame owner){
		super(owner);
		this.setTitle("登录");
		JPanel  p1 = new JPanel();
		p1.add(new JLabel("用户ID："));
		p1.add(jtfUser);
		JPanel  p2 = new JPanel();
		p2.add(new JLabel("密    码："));
		p2.add(jtfPass);
		JPanel p3 = new JPanel();
		p2.add(new JLabel("用户类别："));
		jcbUserType.addItem("教务管理员");
		jcbUserType.addItem("教师");
		jcbUserType.addItem("学生");
		jcbUserType.setSelectedIndex(0);
		p2.add(jcbUserType);
		p3.add(jbtOk);
		p3.add(jbtCancel);

		this.getContentPane().add(p1,BorderLayout.NORTH);
		this.getContentPane().add(p2,BorderLayout.CENTER);
		this.getContentPane().add(p3,BorderLayout.SOUTH);
		jbtOk.addActionListener(this);
		jbtCancel.addActionListener(this);
		this.addWindowListener(new MyListener());
		this.setSize(200,180);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtOk){
			if(jcbUserType.getSelectedIndex()==User.USER_TYPE_ADMIN){
				if(SGS.admin.verifyPassword(jtfUser.getText(), jtfPass.getText())==-1){
					JOptionPane.showMessageDialog(null, "用户名或者密码不正确！");
					jtfUser.setText("");
					jtfPass.setText("");
				}else{
					SGS.currentUser = SGS.admin;
					this.dispose();				
				}
			}else if(jcbUserType.getSelectedIndex()==User.USER_TYPE_TEACHER){
				Collection<Teacher> teachers = SGS.faculty.values();
				Iterator<Teacher> it = teachers.iterator();
				while(it.hasNext()){
					Teacher t1 = it.next();
					if(t1.verifyPassword(jtfUser.getText(), jtfPass.getText())!=-1){
						SGS.currentUser = t1;
						this.dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "用户名或者密码不正确！");
				jtfUser.setText("");
				jtfPass.setText("");
			}else{
				
			}
		}else if(e.getSource()==jbtCancel){
			System.exit(0);
		}
		
	}
	class MyListener extends WindowAdapter{
		public void windowClosing(WindowEvent e){		
			System.exit(0);
		}		
	}
}
