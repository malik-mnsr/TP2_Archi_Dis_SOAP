package com.example.main;
import com.example.model.Offer;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class OfferTableModel extends AbstractTableModel {
    private final List<Offer> offers;
    private final String[] columnNames = {"ID", "New Price", "Start Date", "End Date", "Beds", "Picture Link"};

    public OfferTableModel(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public int getRowCount() {
        return offers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Offer offer = offers.get(rowIndex);
        switch (columnIndex) {
            case 0: return offer.getId();
            case 1: return offer.getNewPrice();
            case 2: return offer.getAvailabilityStart();
            case 3: return offer.getAvailabilityEnd();
            case 4: return offer.getNumberOfBeds();
            case 5: return offer.getGetPictureUrl();
            default: return null;
        }
    }
}
