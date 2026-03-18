import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdminDashboard extends JFrame {

    DefaultTableModel model;
    JTable table;

    public AdminDashboard(){

        setTitle("Admin Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        Color bg = new Color(30,30,30);
        Color tableBg = new Color(45,45,45);
        Color accent = new Color(0,120,215);

        getContentPane().setBackground(bg);

        JLabel title = new JLabel("ADMIN DASHBOARD",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,30));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));

        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Car Name");
        model.addColumn("Year");
        model.addColumn("Price/Day");
        model.addColumn("Available");

        table = new JTable(model);

        table.setRowHeight(35);
        table.setFont(new Font("Arial",Font.PLAIN,16));
        table.setBackground(tableBg);
        table.setForeground(Color.WHITE);
        table.setGridColor(Color.GRAY);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);

        for(int i=0;i<5;i++){
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }

        JScrollPane sp = new JScrollPane(table);
        sp.getViewport().setBackground(tableBg);

        JPanel panel = new JPanel();
        panel.setBackground(bg);

        JButton addCar = new JButton("Add Car");
        JButton viewBookings = new JButton("View Bookings");
        JButton revenue = new JButton("View Revenue");

        styleButton(addCar,accent);
        styleButton(viewBookings,accent);
        styleButton(revenue,accent);

        panel.add(addCar);
        panel.add(viewBookings);
        panel.add(revenue);

        add(title,BorderLayout.NORTH);
        add(sp,BorderLayout.CENTER);
        add(panel,BorderLayout.SOUTH);

        loadCars();

        addCar.addActionListener(e -> addCar());

        viewBookings.addActionListener(e -> new ViewBookings());

        revenue.addActionListener(e -> showRevenue());

        setVisible(true);
    }

    private void loadCars(){

        model.setRowCount(0);

        for(Car c : CarDatabase.cars){

            model.addRow(new Object[]{
                    c.id,
                    c.name,
                    c.year,
                    c.pricePerDay,
                    c.available ? "YES" : "NO"
            });

        }

    }

    private void addCar(){

        String name = JOptionPane.showInputDialog("Enter Car Name");
        String year = JOptionPane.showInputDialog("Enter Car Year");
        String priceStr = JOptionPane.showInputDialog("Enter Price Per Day");

        try{

            int price = Integer.parseInt(priceStr);
            int id = CarDatabase.cars.size() + 1;

            Car car = new Car(id,name,year,price);

            CarDatabase.cars.add(car);

            loadCars();

        }
        catch(Exception e){

            JOptionPane.showMessageDialog(this,"Invalid Price");

        }

    }

    private void showRevenue(){

        double total = 0;

        for(Booking b : BookingDatabase.bookings){
            total += b.total;
        }

        JOptionPane.showMessageDialog(this,
                "Total Revenue Generated : ₹ " + total);

    }

    private void styleButton(JButton btn, Color color){

        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial",Font.BOLD,14));
        btn.setFocusPainted(false);

    }

}