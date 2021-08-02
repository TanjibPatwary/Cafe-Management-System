import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JFrame; 
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.border.TitledBorder;
  
public class Receipt { 
     JFrame f; 
     JTable j; 
      DataAccess da=new DataAccess();
       ResultSet rs=null;
       Receipt() 
    {
        f = new JFrame(); 
        f.setTitle("Receipt"); 
        Object[] columnNames = {"Item Name", "Quantity", "Price"};
        Object[][] data=new Object[5][4];
        try {                                    
            String query = "SELECT Item_Name,Quantity,Price*Quantity FROM Menu where check_box=1";           
            rs = da.getData(query);             
            
            for(int i=0;rs.next();++i){
                data[i][0] = rs.getString("Item_Name");
                data[i][1] = rs.getInt("Quantity");
                data[i][2] = rs.getInt("Price");
                //data[i][3]=0;
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Some Error Occured");
        }
        j = new JTable(data, columnNames); 
        j.setBounds(50, 100, 150, 300); 
        JScrollPane sp = new JScrollPane(j); 
        f.add(sp); 
        f.setSize(500, 500); 
        f.setVisible(true); 
    } 
  
    public static void main(String[] args) 
    { 
        
        new Receipt(); 
          JFrame frame = new JFrame();
      JPanel panel = new JPanel();
      panel.setBorder(BorderFactory.createTitledBorder(
      BorderFactory.createEtchedBorder(), "My Demo Table", TitledBorder.LEFT,
      TitledBorder.TOP));
    } 
}

