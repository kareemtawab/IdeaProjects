package model;

import java.util.ArrayList;

public class InvoiceHeader {

    private long invoiceNum;
    private String invoiceDate;
    private String customerName;
    private String customerAddressLine1;
    private String customerAddressLine2;
    private ArrayList<InvoiceLine> invoiceLineArrayList;

    public InvoiceHeader(long invoiceNum, String invoiceDate, String customerName, String customerAddressLine1, String customerAddressLine2, ArrayList<InvoiceLine> invoiceLineArrayList) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        this.customerAddressLine1 = customerAddressLine1;
        this.customerAddressLine2 = customerAddressLine2;
        this.invoiceLineArrayList = invoiceLineArrayList;
    }

    public long getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(long invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddressLine1() {
        return customerAddressLine1;
    }

    public void setCustomerAddressLine1(String customerAddressLine1) {
        this.customerAddressLine1 = customerAddressLine1;
    }

    public String getCustomerAddressLine2() {
        return customerAddressLine2;
    }

    public void setCustomerAddressLine2(String customerAddressLine2) {
        this.customerAddressLine2 = customerAddressLine2;
    }

    public ArrayList<InvoiceLine> getInvoiceLineArrayList() {
        return invoiceLineArrayList;
    }

    public void setInvoiceLineArrayList(ArrayList<InvoiceLine> invoiceLineArrayList) {
        this.invoiceLineArrayList = invoiceLineArrayList;
    }
}