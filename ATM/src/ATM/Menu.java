package ATM;
import javax.swing.*; 
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
/*
 *ATM自动取款机的菜单界面 
 */

public class Menu extends JFrame implements ActionListener {
	//声明一个继承JFrame类的公共类，实现ActionListener这个接口
	
	private JPanel mp1,mp2;//定义面板

	//定义组件
	private JButton inqury;  //查询
	private JButton outmoney;  //取款 
	private JButton inmoney;  //存款
	private JButton changepassword;  //更改密码
	private JButton exit;//退卡
	private JButton evaluation;//评价
	
	//构造菜单界面
	public Menu(){
		super("ATM自动取款机系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//定义按钮
		inqury=new JButton("查询");
		outmoney=new JButton("取款");  
		inmoney=new JButton("存款");  
		changepassword=new JButton("更改密码");  
		exit=new JButton("退卡");
		evaluation= new JButton("评价");
		inqury.setFont(new Font("黑体",Font.BOLD,30));
		outmoney.setFont(new Font("黑体",Font.BOLD,30));
    	inmoney.setFont(new Font("黑体",Font.BOLD,30));
		changepassword.setFont(new Font("黑体",Font.BOLD,30));
		exit.setFont(new Font("黑体",Font.BOLD,30));
		evaluation.setFont(new Font("黑体",Font.BOLD,30));

		mp1=new JPanel(new BorderLayout());//将mp1面板设置为边界布局
		JLabel jlb1=new JLabel("ATM业务选择",JLabel.CENTER);//定义标签，标签居中
		jlb1.setFont(new Font("黑体",Font.BOLD,60));
		jlb1.setForeground(Color.blue);//设置标签的文字颜色为蓝色
		mp1.add(jlb1,BorderLayout.CENTER);//将标签添加到面板布局的中间位置
		
		mp2=new JPanel();
		mp2.add(inqury); 
		mp2.add(inmoney);
		mp2.add(outmoney);   
		mp2.add(changepassword);  
		mp2.add(exit);
		mp2.add(evaluation);
		mp2.setLayout(new GridLayout(6,1));  //设置面板mp2为5*1的网格布局
		
		add(mp1);
		add(mp2);
		
		pack();
		setVisible(true);//设置可见
		setSize(800, 600);//设置大小
		setLocationRelativeTo(null);//居中
		setResizable(false);//设置窗体大小固定
		setLayout(new GridLayout(3,1));//设置窗体为3*1的网格布局
		
		//绑定监听器
		inqury.addActionListener(this);  
		inmoney.addActionListener(this);  
		outmoney.addActionListener(this);  
		changepassword.addActionListener(this);  
		exit.addActionListener(this);
		evaluation.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd=e.getActionCommand();//cmd赋值为点击的按钮的标题文字 
		if(cmd.equals("查询")){
			Inqury inqury=new Inqury();
		}
		else if(cmd.equals("取款")){
			OutMoney outmoney=new OutMoney();
		}
	    else if(cmd.equals("存款"))  
		{  
			InMoney inMoney=new InMoney();  
		}
	    else if(cmd.equals("更改密码"))  
		{  
			ChangePassword changePassword=new ChangePassword();  
		}
	    else if(cmd.equals("评价")){
			Evaluation evaluation=new Evaluation();
		}
		else if(cmd.equals("退卡")){
			JOptionPane.showMessageDialog(null,"请记得取走您的银行卡");//弹窗
			dispose();//关闭窗体
			Login login=new Login();  //返回登录界面			  
		}  
	}
}