import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewBookings extends JFrame {

    DefaultTableModel model;
    JTable table;

    public ViewBookings(){

        setTitle("View Bookings");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        Color bg = new Color(30,30,30);
        Color tableBg = new Color(45,45,45);

        getContentPane().setBackground(bg);

        JLabel title = new JLabel("CAR BOOKINGS",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,30));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));

        model = new DefaultTableModel();

        model.addColumn("User");
        model.addColumn("Car");
        model.addColumn("Days");
        model.addColumn("Total");

        table = new JTable(model);

        table.setRowHeight(35);
        table.setFont(new Font("Arial",Font.PLAIN,16));
        table.setBackground(tableBg);
        table.setForeground(Color.WHITE);
        table.setGridColor(Color.GRAY);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);

        for(int i=0;i<4;i++){
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }

        JScrollPane sp = new JScrollPane(table);
        sp.getViewport().setBackground(tableBg);

        JButton returnCar = new JButton("Return Selected Car");

        returnCar.setBackground(new Color(0,120,215));
        returnCar.setForeground(Color.WHITE);
        returnCar.setFont(new Font("Arial",Font.BOLD,14));

        JPanel bottom = new JPanel();
        bottom.setBackground(bg);
        bottom.add(returnCar);

        add(title,BorderLayout.NORTH);
        add(sp,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);

        loadBookings();

        returnCar.addActionListener(e -> returnCar());

        setVisible(true);
    }

    private void loadBookings(){

        model.setRowCount(0);

        for(Booking b : BookingDatabase.bookings){

            model.addRow(new Object[]{
                    b.username,
                    b.carName,
                    b.days,
                    b.total
            });

        }

    }

    private void returnCar(){

        int row = table.getSelectedRow();

        if(row==-1){
            JOptionPane.showMessageDialog(this,"Select booking first");
            return;
        }

        Booking b = BookingDatabase.bookings.get(row);

        // Make car available again
        for(Car c : CarDatabase.cars){

            if(c.name.equals(b.carName)){
                c.available = true;
            }

        }

        BookingDatabase.bookings.remove(row);

        loadBookings();

        JOptionPane.showMessageDialog(this,"Car Returned Successfully");

    }

}