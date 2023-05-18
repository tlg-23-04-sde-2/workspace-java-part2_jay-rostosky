package gov.irs;

public interface IRS {
    public void collectTaxes();
    public void register(TaxPayer payer);

    // static factory method for clients to obtain the (sole) instance of IRSEnum
    public static IRS getInstance() {
        return IRSEnum.INSTANCE;
    }
}
