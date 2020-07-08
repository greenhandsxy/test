package ATM;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

/*
 * ATM查询余额界面
 */

public class Inqury implements ActionListener{
	
	//定义组件
	public JFrame iframe;
	public JPanel ip0,ip1,ip2;
	public JLabel id,yue;
	public JButton ok;
	
	//构造查询界面
    public Inqury(){
	    iframe=new JFrame("查询");
	    iframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    ip0=new JPanel();
	    id=new JLabel("账号："+Test.currentAccount.id);//获取Test类中的账号数据（下同）
	    ip0.add(id);
	    id.setFont(new Font("黑体",Font.BOLD,25));

	    ip1=new JPanel();
	    yue=new JLabel("账户余额："+Test.currentAccount.money);
	    yue.setFont(new Font("黑体",Font.BOLD,25));
        ip1.add(yue);
	
    	ok=new JButton("确定");
    	ok.setFont(new Font("黑体",Font.PLAIN,25));
    
    	iframe.add(ip0);
    	iframe.add(ip1);
    	iframe.add(ok);
	
	
    	iframe.setLayout(new FlowLayout());//设置窗体为流布局
    	iframe.setVisible(true);//设置窗体可见
    	iframe.setSize(400, 300);//设置大小
    	iframe.setLocationRelativeTo(null);//居中
    	iframe.setResizable(false);//设置窗体大小固定	
    	ok.addActionListener(this);//添加监听
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确定")){
			iframe.dispose();
		}
	}
}

