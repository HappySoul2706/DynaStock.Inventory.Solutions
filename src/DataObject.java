class DataObject {
    private String Object_Name;
    private int Object_Stock_Amount;
    public String Object_Distributor;
    public boolean Object_Lent_Status;
    public String Object_Borrower_Identity;

    //Constructor
    public DataObject(String Object_Name, int Object_Stock_Amount, String Object_Distributor, boolean Object_Lent_Status, String Object_Borrower_Identity) {
        this.Object_Name = Object_Name;
        this.Object_Stock_Amount = Object_Stock_Amount;
        this.Object_Distributor = Object_Distributor;
        this.Object_Lent_Status = Object_Lent_Status;
        this.Object_Borrower_Identity = Object_Borrower_Identity;
    }

    //getters and setters
    public String getObject_Name() {
        return Object_Name;
    }
    public int getObject_Stock_Amount() {
        return Object_Stock_Amount;
    }
    public String getObject_Distributor() {
        return Object_Distributor;
    }
    public boolean getObject_Lent_Status() {
        return Object_Lent_Status;
    }
    public String getObject_Borrower_Identity() {
        return Object_Borrower_Identity;
    }
}
