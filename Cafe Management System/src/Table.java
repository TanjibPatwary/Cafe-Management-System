import javax.swing.BorderFactory;
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.border.TitledBorder;
  
public class Table { 
     JFrame f; 
     JTable j; 
       Table() 
    {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Sell History"); 
        Object[] columnNames = {"Item Name","Quantity(per day)","Quantity(per month)"};
        Object[][] data = { 
            { "Pizza 12 inch","720", 8}, 
            { "Burger Naga", "260", 70} 
        }; 
        j = new JTable(data, columnNames); 
        j.setBounds(50, 100, 150, 300); 
        JScrollPane sp = new JScrollPane(j); 
        f.add(sp); 
        f.setSize(500, 500); 
        f.setVisible(true); 
        f.add(j);
    } 
  
    public static void main(String[] args) 
    { 
        
        new Table(); 
          JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      panel.setBorder(BorderFactory.createTitledBorder(
      BorderFactory.createEtchedBorder(), "My Demo Table", TitledBorder.LEFT,
      TitledBorder.TOP));
    } 
}
