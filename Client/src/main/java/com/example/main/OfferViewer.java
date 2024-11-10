package com.example.main;

import com.example.model.Offer;

import javax.swing.*;
import java.awt.*;
import java.util.List;



public class OfferViewer extends JFrame {
    public OfferViewer(List<Offer> offers) {
        setTitle("Available Offers");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create table with custom model
        OfferTableModel model = new OfferTableModel(offers);
        JTable offerTable = new JTable(model);

        // Customize the JTable (Optional)
        offerTable.setRowHeight(25);
        offerTable.getColumnModel().getColumn(5).setPreferredWidth(300); // Make picture link column wider

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(offerTable);
        add(scrollPane, BorderLayout.CENTER);
    }
}