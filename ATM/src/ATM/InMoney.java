package ATM;


import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

/*
 *ATM������ 
 */

public class InMoney implements ActionListener{
	
	//�������
	public JTextField money;
	public JFrame inframe;
	public JPanel op0,op1,op2,op3,op4;
	public JButton confirm,cancel,exit;
	public JLabel id,yue,cun,tishi;
	boolean flag1=false;
	boolean flag2=false;
	
	//���������
	public InMoney(){
		inframe=new JFrame("���");
		inframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		op0=new JPanel();
		id=new JLabel("�˺ţ�"+Test.currentAccount.id);//��ȡTest���е��˺����ݣ���ͬ��
		id.setFont(new Font("����",Font.BOLD,25));
		op0.add(id);
		
		op1=new JPanel();
		yue=new JLabel("�˻���"+Test.currentAccount.money);
		yue.setFont(new Font("����",Font.BOLD,25));
		op1.add(yue);
		
		op2=new JPanel();
		cun=new JLabel("����");
		cun.setFont(new Font("����",Font.BOLD,25));
		money=new JTextField(20);
		money.setFont(new Font("����",Font.BOLD,25));
		
		op2.add(cun);
		op2.add(money);
		
		op3=new JPanel();  
	    confirm=new JButton("ȷ��");  
	    confirm.setFont(new Font("����",Font.PLAIN,25));
	    op3.add(confirm);  
	    cancel=new JButton("����"); 
	    cancel.setFont(new Font("����",Font.PLAIN,25));
	    op3.add(cancel);  
		
	    inframe.add(op0);  
	    inframe.add(op1);  
	    inframe.add(op2); 
	    inframe.add(op3);
	    
	    inframe.setLayout(new FlowLayout());  //���ô���Ϊ������
	    inframe.setVisible(true);  //����ɼ�
	    inframe.setSize(450, 300);//�����С 
	    inframe.setLocationRelativeTo(null);//����Ļ�м���ʾ(������ʾ)  
	    inframe.setResizable(false);//�����С�̶�
	      
	    //��Ӽ���
	    confirm.addActionListener(this);  
	    cancel.addActionListener(this);  
	  
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ȷ��")){
			 try {
	             int money1=Integer.parseInt(money.getText());
	             if(money1%100==0) {
	        	     Test.currentAccount.inMoney(Integer.parseInt(money.getText()));//���õ�ǰ��½�˻��Ĵ�Ǯ����          
	                 JOptionPane.showMessageDialog(null, "���ɹ�");//����  
	                 money.setText("");//�ı������
	                 yue.setText("�˻����:"+Test.currentAccount.money);//�˻�������
	            }
	             else {
	                 JOptionPane.showMessageDialog(null, "ϵͳ��֧�ַ�100Ԫ�������\n ��������������� �� ");//���� 
	            	 money.setText("");
	            	}
	         }  
	         catch (ClassCastException e1){//����ǰ��¼�˻���inmoney�����е��쳣������ת���쳣
	             JOptionPane.showMessageDialog(null, "�����������ʹ�������������");  
	            }  
	         catch (Exception e1) {
	             JOptionPane.showMessageDialog(null, e1.getMessage());  
	            }  
	        }  
		else if(e.getActionCommand().equals("����")){
				inframe.dispose();//�رմ�Ǯ����
		}
	}
}
