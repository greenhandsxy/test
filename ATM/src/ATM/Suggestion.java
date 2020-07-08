package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;



public class Suggestion extends JFrame implements ActionListener {
    private Container contentPane;
    private FlowLayout layout;
    private JButton bt1,bt2,btExit;
    private JTextArea ta;
//    private Test h;//监听对象

    public Suggestion(){
        setTitle("安抚");
        contentPane=getContentPane();
        layout=new FlowLayout();//拿画纸
        contentPane.setLayout(layout);//在画板上铺画纸
        bt1=new JButton("Submit");
        contentPane.add(bt1);


        bt1.addActionListener(this);
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Suggestion.this,"Success");
                dispose();
            }
        });


        ta=new JTextArea(10,30);
        contentPane.add(new JScrollPane(ta));


        ta.setEditable(true);



        setVisible(true);
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDateTime time =LocalDateTime.now();
        int h=time.getHour();
        int m=time.getMinute();
        int s=time.getSecond();
        String str=ta.getText()+h+":"+m+":"+s+e.getActionCommand()+"\n";
//        if(e.getSource()==bt1){
//            JOptionPane.showMessageDialog(this, "Success");
//        }
        ta.setText(str);
    }
}