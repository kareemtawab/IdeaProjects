package view;

import model.InvoiceHeader;
import model.InvoiceLine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class InvoiceHeaderPart extends JFrame {

    private InvoiceHeader invoiceHeader;
    private JPanel jPanel;

    public InvoiceHeaderPart(InvoiceHeader invoiceHeader) throws HeadlessException {
        this.invoiceHeader = invoiceHeader;

    }

    public JPanel createHeader(){
        jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel businessBlock = new JPanel();
//        businessBlock.setLayout(new GridLayout(6, 1));
        businessBlock.setLayout(new BoxLayout(businessBlock, BoxLayout.Y_AXIS));
        JLabel businessName = new JLabel("MartZilla Supermarkets Group Co. Ltd", SwingConstants.LEFT);
        businessName.setFont(new Font("Arial", Font.PLAIN, 20));
        businessName.setAlignmentX(LEFT_ALIGNMENT);
        JLabel businessAddress1 = new JLabel("Victor Emanuel St., Smouha", SwingConstants.LEFT);
        businessAddress1.setFont(new Font("Arial", Font.PLAIN, 10));
        businessAddress1.setAlignmentX(LEFT_ALIGNMENT);
        JLabel businessAddress2 = new JLabel("Sidi Gaber, Alexandria", SwingConstants.LEFT);
        businessAddress2.setFont(new Font("Arial", Font.PLAIN, 10));
        businessAddress2.setAlignmentX(LEFT_ALIGNMENT);
        JLabel businessPhone = new JLabel("+20-101-234-2345", SwingConstants.LEFT);
        businessPhone.setFont(new Font("Arial", Font.PLAIN, 10));
        businessPhone.setAlignmentX(LEFT_ALIGNMENT);
        JLabel businessEmail = new JLabel("email@domain.com", SwingConstants.LEFT);
        businessEmail.setFont(new Font("Arial", Font.PLAIN, 10));
        businessEmail.setAlignmentX(LEFT_ALIGNMENT);
        businessBlock.add(businessName);
        businessBlock.add(businessAddress1);
        businessBlock.add(businessAddress2);
        businessBlock.add(businessPhone);
        businessBlock.add(businessEmail);
        businessBlock.add(new JLabel(" ", SwingConstants.LEFT));
        businessBlock.setAlignmentX(LEFT_ALIGNMENT);

        JPanel titleBlock = new JPanel();
//        titleBlock.setLayout(new GridLayout(6, 1));
        titleBlock.setLayout(new BoxLayout(titleBlock, BoxLayout.Y_AXIS));

        JLabel title1 = new JLabel("Invoice", SwingConstants.RIGHT);
        title1.setFont(new Font("Arial", Font.BOLD, 25));
        title1.setAlignmentX(RIGHT_ALIGNMENT);
        JLabel title2 = new JLabel("Sales Department", SwingConstants.RIGHT);
        title2.setFont(new Font("Arial", Font.PLAIN, 10));
        title2.setAlignmentX(RIGHT_ALIGNMENT);
        titleBlock.add(title1);
        titleBlock.add(title2);

        JPanel topHeader = new JPanel();
        topHeader.setLayout(new GridLayout(1, 2));
        topHeader.add(businessBlock);
        topHeader.add(titleBlock);

        //////////////////////////////////////////////////////////////////////////////////////////
        JPanel customerBlock = new JPanel();
//        customerBlock.setLayout(new GridLayout(3, 1));
        customerBlock.setLayout(new BoxLayout(customerBlock, BoxLayout.Y_AXIS));

        JLabel billInfo = new JLabel("Billing Information:", SwingConstants.LEFT);
        billInfo.setFont(new Font("Arial", Font.ITALIC, 12));
        billInfo.setAlignmentX(LEFT_ALIGNMENT);
        JLabel customerName = new JLabel(invoiceHeader.getCustomerName(), SwingConstants.LEFT);
        customerName.setFont(new Font("Arial", Font.PLAIN, 15));
        customerName.setAlignmentX(LEFT_ALIGNMENT);
        JLabel customerAddress1 = new JLabel(invoiceHeader.getCustomerAddressLine1(), SwingConstants.LEFT);
        customerAddress1.setFont(new Font("Arial", Font.PLAIN, 10));
        customerAddress1.setAlignmentX(LEFT_ALIGNMENT);
        JLabel customerAddress2 = new JLabel(invoiceHeader.getCustomerAddressLine2(), SwingConstants.LEFT);
        customerAddress2.setFont(new Font("Arial", Font.PLAIN, 10));
        customerAddress2.setAlignmentX(LEFT_ALIGNMENT);

        customerBlock.add(billInfo);
        customerBlock.add(customerName);
        customerBlock.add(customerAddress1);
        customerBlock.add(customerAddress2);

        JPanel invoiceBlock = new JPanel();
//        invoiceBlock.setLayout(new GridLayout(3, 1));
        invoiceBlock.setLayout(new BoxLayout(invoiceBlock, BoxLayout.Y_AXIS));
        JLabel invoiceNumber = new JLabel("Invoice Number: # " + String.valueOf(invoiceHeader.getInvoiceNum()), SwingConstants.RIGHT);
        invoiceNumber.setFont(new Font("Arial", Font.PLAIN, 10));
        invoiceNumber.setAlignmentX(RIGHT_ALIGNMENT);
        JLabel invoiceDate = new JLabel("Issue Date: " + invoiceHeader.getInvoiceDate(), SwingConstants.RIGHT);
        invoiceDate.setFont(new Font("Arial", Font.PLAIN, 10));
        invoiceDate.setAlignmentX(RIGHT_ALIGNMENT);

        invoiceBlock.add(invoiceNumber);
        invoiceBlock.add(invoiceDate);

        JPanel bottomHeader = new JPanel();
        bottomHeader.setLayout(new GridLayout(1, 2));
        bottomHeader.add(customerBlock);
        bottomHeader.add(invoiceBlock);

        jPanel.add(topHeader);
        jPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        jPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        jPanel.add(bottomHeader);
        return jPanel;
    }

}
