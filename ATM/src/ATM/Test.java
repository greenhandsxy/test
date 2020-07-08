package ATM;

public class Test {	
	public static Account currentAccount;//登录的用户  	
    public static Menu menu;//自定义的主界面 
	
	  
	public static void main(String[] args)throws Exception { 
	    currentAccount=new Account("888888", "123456", "50000");//账户模拟，仅此一个账户
	    
	    /*****************************Login****************************/  
	    Login login = new Login();  
	    }  
}
