package ATM;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

/*
 * ATM��ѯ������
 */

public class Inqury implements ActionListener{
	
	//�������
	public JFrame iframe;
	public JPanel ip0,ip1,ip2;
	public JLabel id,yue;
	public JButton ok;
	
	//�����ѯ����
    public Inqury(){
	    iframe=new JFrame("��ѯ");
	    iframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    ip0=new JPanel();
	    id=new JLabel("�˺ţ�"+Test.currentAccount.id);//��ȡTest���е��˺����ݣ���ͬ��
	    ip0.add(id);
	    id.setFont(new Font("����",Font.BOLD,25));

	    ip1=new JPanel();
	    yue=new JLabel("�˻���"+Test.currentAccount.money);
	    yue.setFont(new Font("����",Font.BOLD,25));
        ip1.add(yue);
	
    	ok=new JButton("ȷ��");
    	ok.setFont(new Font("����",Font.PLAIN,25));
    
    	iframe.add(ip0);
    	iframe.add(ip1);
    	iframe.add(ok);
	
	
    	iframe.setLayout(new FlowLayout());//���ô���Ϊ������
    	iframe.setVisible(true);//���ô���ɼ�
    	iframe.setSize(400, 300);//���ô�С
    	iframe.setLocationRelativeTo(null);//����
    	iframe.setResizable(false);//���ô����С�̶�	
    	ok.addActionListener(this);//��Ӽ���
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ȷ��")){
			iframe.dispose();
		}
	}
}

