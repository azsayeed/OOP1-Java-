package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Entity.*;
import Service.*;
import File.FileIO;

public class RentalManagerGUI extends JFrame implements ActionListener {

    JTextField rentalIdTF, vehicleNameTF, regNoTF, typeTF, priceTF;
    JTextField customerIdTF, customerNameTF, addressTF;
    JTextField driverIdTF, driverNameTF, driverTypeTF;
    JTextField paymentTF, methodTF, daysTF;

    JButton addBtn, editBtn, removeBtn, showBtn, clearBtn;

    JTextArea screen;

    public RentalManagerGUI() {
        super("Vehicle Rental Management System");
        setSize(950, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Font f = new Font("Arial", Font.BOLD, 13);

        int x1 = 20, x2 = 160, y = 20, gap = 32;

        addLabel("Rental ID", x1, y, f);
        rentalIdTF = addTextField(x2, y); y += gap;

        addLabel("Vehicle Name", x1, y, f);
        vehicleNameTF = addTextField(x2, y); y += gap;

        addLabel("Reg No", x1, y, f);
        regNoTF = addTextField(x2, y); y += gap;

        addLabel("Vehicle Type", x1, y, f);
        typeTF = addTextField(x2, y); y += gap;

        addLabel("Base Price", x1, y, f);
        priceTF = addTextField(x2, y); y += gap;

        addLabel("Customer ID", x1, y, f);
        customerIdTF = addTextField(x2, y); y += gap;

        addLabel("Customer Name", x1, y, f);
        customerNameTF = addTextField(x2, y); y += gap;

        addLabel("Location", x1, y, f);
        addressTF = addTextField(x2, y); y += gap;

        addLabel("Driver ID", x1, y, f);
        driverIdTF = addTextField(x2, y); y += gap;

        addLabel("Driver Name", x1, y, f);
        driverNameTF = addTextField(x2, y); y += gap;

        addLabel("Payment Type", x1, y, f);
        paymentTF = addTextField(x2, y); y += gap;

        addLabel("Pay Method", x1, y, f);
        methodTF = addTextField(x2, y); y += gap;

        addLabel("Days", x1, y, f);
        daysTF = addTextField(x2, y);

        addBtn = addButton("Add Rental", 20, 520);
        editBtn = addButton("Edit Rental", 150, 520);
        removeBtn = addButton("Remove Rental", 280, 520);
        showBtn = addButton("Show All", 20, 560);
        clearBtn = addButton("Clear Screen", 150, 560);

        screen = new JTextArea();
        screen.setFont(new Font("Consolas", Font.PLAIN, 13));
        screen.setEditable(false);
        JScrollPane sp = new JScrollPane(screen);
        sp.setBounds(450, 20, 460, 570);
        add(sp);

        setVisible(true);
    }

    void addLabel(String text, int x, int y, Font f) {
        JLabel l = new JLabel(text);
        l.setBounds(x, y, 130, 25);
        l.setFont(f);
        add(l);
    }

    JTextField addTextField(int x, int y) {
        JTextField t = new JTextField();
        t.setBounds(x, y, 250, 25);
        add(t);
        return t;
    }

    JButton addButton(String text, int x, int y) {
        JButton b = new JButton(text);
        b.setBounds(x, y, 120, 30);
        b.addActionListener(this);
        add(b);
        return b;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addBtn || e.getSource() == editBtn) {
            try {
                Vehicle v = new Vehicle(
                        vehicleNameTF.getText(),
                        regNoTF.getText(),
                        typeTF.getText(),
                        Double.parseDouble(priceTF.getText())
                      
                );

                Customer c = new Customer(
                        customerIdTF.getText(),
                        customerNameTF.getText(),
                        addressTF.getText()
                );

                Driver d = null;
                if (!driverIdTF.getText().isEmpty()) {
                    d = new Driver(
                            driverIdTF.getText(),
                            driverNameTF.getText(),
                            "Assigned"
                    );
                }

                Rental r = new Rental(
                        rentalIdTF.getText(),
                        v, c, d,
                        paymentTF.getText(),
                        methodTF.getText()
                );

                if (e.getSource() == addBtn) {
                    Rental.addRental(r);
                    screen.append(">>> System: Rental " + rentalIdTF.getText() + " Added and Saved to File.\n");
                } else {
                    Rental.editRental(rentalIdTF.getText(), r);
                    screen.append(">>> System: Rental " + rentalIdTF.getText() + " Updated.\n");
                }
            } 
			catch (Exception ex) {
                screen.append("!!! Error: Check numeric fields (Price/Days).\n");
			}
        }

        else if (e.getSource() == removeBtn) {
            Rental.removeRental(rentalIdTF.getText());
            screen.append(">>> System: Rental ID " + rentalIdTF.getText() + " removed.\n");
        }


        else if (e.getSource() == clearBtn) {
            screen.setText(""); 
        }
		else if (e.getSource() == showBtn) {
			String latestData = File.FileIO.readFromFile();
			screen.setText(""); 
			screen.append("======= LATEST FILE UPDATE =======\n");
			screen.append(latestData);
			screen.append("==================================\n");
		}
		
    }

    public static void main(String[] args) {
        new RentalManagerGUI();
    }
}