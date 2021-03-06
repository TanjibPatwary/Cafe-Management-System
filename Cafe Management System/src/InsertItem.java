import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertItem extends JFrame implements ActionListener {
    private JTextField tf1,tf2;
    JLabel jl1,jl2;
    JButton jB1,jB2;
    private Font f;
    Container c;
    PlaceOrder pO1;
    
     DataAccess da3=new DataAccess();
    public void actionPerformed(ActionEvent e){
              
		 boolean flag=true;
                 String s=e.getActionCommand();
		if(flag && s.equals("Save")){
                   
		String ItemName=this.tf1.getText();
                int Price = Integer.parseInt(this.tf2.getText());	
	        
			if(ItemName.length()==0 || Price==0){
				JOptionPane.showMessageDialog(null,"You must provide ItemName and Price both");
				flag=false;
			}
                        else {
				String sql="INSERT INTO item (ItemName,Price) VALUES ('"+ItemName+"','"+Price+"')";
				da3.updateDB(sql);
                               // pO1.addItem();
				
				}
			}
                
                else if(s.equals("Back"))
                {
			System.out.println("go to main frame");
                        this.dispose();
                        new MainFrame();
		}
		}		
	
    InsertItem()
    {
        intiComponents();
    }
     public void intiComponents()
    {
            this.setVisible(true);
            c = this.getContentPane();
            c.setLayout(null);
            c.setBackground(Color.DARK_GRAY);
            f=new Font("arial",Font.BOLD,18);
            this.setTitle("InsertItem Frame");
            this.setLayout(null);
            this.setBounds(500,500,500,500);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tf1= new JTextField();
            tf1.setBounds(250, 100, 200, 50);
            tf2= new JTextField();
            tf2.setBounds(250, 200, 200, 50);

            jl1=new JLabel();
            jl1.setText("Enter The Item Name");
            jl1.setBounds(50,100,200,50);
            jl1.setFont(f);
            jl1.setForeground(Color.WHITE);

            jl2=new JLabel();
            jl2.setText("Enter THe Item Price");
            jl2.setBounds(50,200,200,50);
            jl2.setFont(f);
            jl2.setForeground(Color.WHITE);

            jB1=new JButton("Save");
            jB1.setBounds(90,300,150,50);

            jB2=new JButton("Back");
            jB2.setBounds(250,300,150,50);

            jB1.addActionListener(this);
            jB2.addActionListener(this);

            this.add(tf1);
            this.add(tf2);
            this.add(jl1);
            this.add(jl2);
            this.add(jB1);
            this.add(jB2);
       
      
    }
    
    public static void main(String[] args) {
         
         InsertItem iI1=new InsertItem();
    }
    
}
