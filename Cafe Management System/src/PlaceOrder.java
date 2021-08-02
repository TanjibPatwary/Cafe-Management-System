import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.border.TitledBorder;
public final class PlaceOrder extends JFrame implements ActionListener{
    
    JLabel jL1,jL2;
    JButton jB1,jB2;
    JTextField tF1;
    JTable jT1;
    JScrollPane jS1;
    JPanel panel;
    Container c;
    DataAccess da=new DataAccess();
    ResultSet rs=null;
    Font f;
    
    
                            
    public void actionPerformed(ActionEvent e)
    {
         if(e.getSource()==jB2)
         {
             this.dispose();
             new MainFrame();
         }
         else if(e.getSource()==jB1)
         {
             this.dispose();
             new Receipt();
         }
    }
    
    
    PlaceOrder()
    {
        intiComponents();
        addItem();
        
    }
    public void addItem()
    {
        
       Object [] coLs={"Item_Name","Price","Quantity","check_box"};
        Object[][] data=new Object[5][4];
         jT1=new JTable(data,coLs);
        jT1.setBounds(60,100,450,170);
        this.add(jT1);
       try {                                    
            String query = "SELECT ItemName,Price FROM item";           
            rs = da.getData(query);             
            
            for(int i=0;rs.next();++i){
                data[i][0] = rs.getString("ItemName");
                data[i][1] = rs.getInt("Price");
                data[i][2] = 0;
                data[i][3]=0;
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Some Error Occured");
        }
       
        
        
    }
    public void intiComponents()
    {
        c=this.getContentPane();    
        c.setLayout(null);
        this.setVisible(true);
        this.setTitle("Place Order");
        this.setBounds(500,500,500,500);
        c.setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       /* panel = new JPanel();
         panel.setBorder(BorderFactory.createTitledBorder(
         BorderFactory.createEtchedBorder(), "Order Table", TitledBorder.LEFT,
           TitledBorder.TOP));*/
       
        f=new Font("arial",Font.BOLD,18);
        jB1=new JButton("Reciept");
        jB1.setBounds(350,350,100,50);
        jB2=new JButton("Back");
        jB2.setBounds(470,350,100,50);
        jL2=new JLabel();
        jL2.setText("Menu");
        jL2.setBounds(30,10,100,50);
        jL2.setFont(f);
        jS1 = new JScrollPane(jT1); 
       jS1.setBounds(550,100,50,50);
        this.add(jB1);
        this.add(jB2);
        
        this.add(jS1);
        this.add(jL2);
        jB1.addActionListener(this);
        jB2.addActionListener(this);
        
    }
    public static void main(String[] args) {
        PlaceOrder pO1=new PlaceOrder();
         }
}
