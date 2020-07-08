package ATM;

import javax.swing.*;  
import java.awt.*; 
import java.awt.event.*;

/*
 * ATM�Զ�ȡ����ĵ�¼����
 */

public class Login extends JFrame implements ActionListener{
	//����һ���̳�JFrame��Ĺ����࣬ʵ��ActionListener����ӿ�
	private JPanel p0,p1,p2,p3;//�������
	
	//�������
	private JTextField userName;//�����˺ŵ��ı���
	private JPasswordField passWord;//��������������
	private JButton login,exit;  //��¼���˳���ť
	private JLabel jl1,jl2,jl3;//��ǩ
	
	//�����¼����
	public Login(){
		super("��¼ATM");//������� 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô��ڵĵ�����Ͻǵ�x�Ĵ���ʽ���������õ����˳�����  
		
		p0=new JPanel();
		jl1=new JLabel("��ӭʹ��ATM��Ա��ϵͳ��");//���ñ�ǩ���ݣ���ͬ��
		jl1.setFont(new Font("����",Font.BOLD,40));//���ñ�ǩ���壬�Ӵ֣���С����ͬ��
		p0.add(jl1);//������������ǩ��ӵ���壨��ͬ��
		
		p1=new JPanel();
		jl2=new JLabel("���ţ�");
		jl2.setFont(new Font("����",Font.BOLD,25));
		p1.add(jl2);
		userName=new JTextField(20);//�����ı��򳤶�Ϊ20
		userName.setFont(new Font("����",Font.PLAIN,25));
		p1.add(userName);
		
		p2=new JPanel();
		jl3=new JLabel("���룺");
		jl3.setFont(new Font("����",Font.BOLD,25));
		p2.add(jl3);
		passWord=new JPasswordField(20);
		passWord.setFont(new Font("����",Font.PLAIN,25));
		passWord.setEchoChar('*');//�����������������ʱ��ʾΪ*
		p2.add(passWord);
		
		p3=new JPanel();
		p3.setLayout(null);//����������Ϊ���Բ��֣����λ�������С���Զ���
		login=new JButton("��¼");
		login.setBounds(350, 50, 60, 40);//���尴ť�����С
		exit=new JButton("�˳�");
		exit.setBounds(500, 50, 60, 40);
		p3.add(login);
		p3.add(exit);
		
		//�������ӵ�����
		add(p0);
		add(p1);
		add(p2);
		add(p3);
		
		pack();
		setVisible(true);//���ô���ɼ�
		setSize(900, 700);//���ô����С
		setLayout(new GridLayout(4,1));//���ô��岼��Ϊ4*1�����񲼾�
		setLocationRelativeTo(null);//����
		setResizable(false);//���ô����С�̶�
		
		//��ť��Ӽ���
		login.addActionListener(this);
		exit.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			//login������������İ�ť��login��¼��ִ����������
			
				if (Test.currentAccount.id.equals(userName.getText())) { //�˺�һ��
					if(new String(passWord.getPassword()).equals(Test.currentAccount.password)) {//����һ�� 
						JOptionPane.showMessageDialog(this, "��¼�ɹ�");  //����						
						Menu menu=new Menu();//ʵ�������������洰��   
						Test.menu=menu;  
						setVisible(false);//���ص�½����  
					}
					else  
						JOptionPane.showMessageDialog(this, "�������"); //����
						  
				}  
				else
					JOptionPane.showMessageDialog(this, "���û�������");  //����
		}  		
		
		if(e.getSource()==exit){
			//����������İ�ť��exit��ִ����������
			JOptionPane.showMessageDialog(null, "ȷ���˳���");//����
			dispose();//�رմ���
		}
	}    
}
