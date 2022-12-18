package view;

import model.InvoiceHeader;
import model.InvoiceLine;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class InvoiceTablePart extends JFrame {

    private InvoiceHeader invoiceHeader;
    private JPanel jPanel;

    public InvoiceTablePart(InvoiceHeader invoiceHeader) throws HeadlessException {
        this.invoiceHeader = invoiceHeader;
    }

    public JPanel createTable(){

        double totalAmount = 0;
        jPanel = new JPanel();
//        jPanel.setLayout(new GridLayout(1, 1));
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        String[] cols = {"Item Description", "Unit Price", "Quantity", "Amount"};
        DefaultTableModel table = new DefaultTableModel();
        for (String col : cols) {
            table.addColumn(col);
        }
        for (InvoiceLine invoiceLine : invoiceHeader.getInvoiceLineArrayList()) {
            table.addRow(new Object[]{invoiceLine.getItemName(), String.format("$%.2f", invoiceLine.getItemPrice()), invoiceLine.getCount(), String.format("$%.2f", invoiceLine.getCount() * invoiceLine.getItemPrice())});
            totalAmount += invoiceLine.getCount() * invoiceLine.getItemPrice();
        }

        JTable jTable = new JTable(table);

        jTable.setCellSelectionEnabled(false);
        jTable.setFocusable(false);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        jTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        jTable.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTable.getColumnModel().getColumn(1).setMaxWidth(70);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTable.getColumnModel().getColumn(2).setMaxWidth(70);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTable.getColumnModel().getColumn(3).setMaxWidth(70);
        JScrollPane jScrollPane = new JScrollPane(jTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jPanel.add(jScrollPane);

        JLabel total = new JLabel(String.format("Total Price: $%.2f", totalAmount), SwingConstants.RIGHT);
        total.setAlignmentX(RIGHT_ALIGNMENT);
        jPanel.add(total);

        return jPanel;
    }
}
