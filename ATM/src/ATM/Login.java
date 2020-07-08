package ATM;

import javax.swing.*;  
import java.awt.*; 
import java.awt.event.*;

/*
 * ATM自动取款机的登录界面
 */

public class Login extends JFrame implements ActionListener{
	//声明一个继承JFrame类的公共类，实现ActionListener这个接口
	private JPanel p0,p1,p2,p3;//定义面板
	
	//定义组件
	private JTextField userName;//输入账号的文本框
	private JPasswordField passWord;//输入密码的密码框
	private JButton login,exit;  //登录，退出按钮
	private JLabel jl1,jl2,jl3;//标签
	
	//构造登录界面
	public Login(){
		super("登录ATM");//窗体标题 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口的点击右上角的x的处理方式，这里设置的是退出程序  
		
		p0=new JPanel();
		jl1=new JLabel("欢迎使用ATM柜员机系统！");//设置标签内容（下同）
		jl1.setFont(new Font("黑体",Font.BOLD,40));//设置标签字体，加粗，大小（下同）
		p0.add(jl1);//添加组件，将标签添加到面板（下同）
		
		p1=new JPanel();
		jl2=new JLabel("卡号：");
		jl2.setFont(new Font("黑体",Font.BOLD,25));
		p1.add(jl2);
		userName=new JTextField(20);//设置文本框长度为20
		userName.setFont(new Font("黑体",Font.PLAIN,25));
		p1.add(userName);
		
		p2=new JPanel();
		jl3=new JLabel("密码：");
		jl3.setFont(new Font("黑体",Font.BOLD,25));
		p2.add(jl3);
		passWord=new JPasswordField(20);
		passWord.setFont(new Font("黑体",Font.PLAIN,25));
		passWord.setEchoChar('*');//设置密码框输入密码时显示为*
		p2.add(passWord);
		
		p3=new JPanel();
		p3.setLayout(null);//将容器设置为绝对布局，组件位置坐标大小可自定义
		login=new JButton("登录");
		login.setBounds(350, 50, 60, 40);//定义按钮坐标大小
		exit=new JButton("退出");
		exit.setBounds(500, 50, 60, 40);
		p3.add(login);
		p3.add(exit);
		
		//将面板添加到窗体
		add(p0);
		add(p1);
		add(p2);
		add(p3);
		
		pack();
		setVisible(true);//设置窗体可见
		setSize(900, 700);//设置窗体大小
		setLayout(new GridLayout(4,1));//设置窗体布局为4*1的网格布局
		setLocationRelativeTo(null);//居中
		setResizable(false);//设置窗体大小固定
		
		//按钮添加监听
		login.addActionListener(this);
		exit.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			//login，如果监听到的按钮是login登录，执行下面的语句
			
				if (Test.currentAccount.id.equals(userName.getText())) { //账号一致
					if(new String(passWord.getPassword()).equals(Test.currentAccount.password)) {//密码一致 
						JOptionPane.showMessageDialog(this, "登录成功");  //弹窗						
						Menu menu=new Menu();//实例化操作主界面窗口   
						Test.menu=menu;  
						setVisible(false);//隐藏登陆窗口  
					}
					else  
						JOptionPane.showMessageDialog(this, "密码错误"); //弹窗
						  
				}  
				else
					JOptionPane.showMessageDialog(this, "该用户不存在");  //弹窗
		}  		
		
		if(e.getSource()==exit){
			//如果监听到的按钮是exit，执行下面的语句
			JOptionPane.showMessageDialog(null, "确认退出！");//弹窗
			dispose();//关闭窗体
		}
	}    
}
