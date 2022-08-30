import java.text.NumberFormat;
import java.util.Objects;

public abstract class CaffeinatedBeverage
{
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    protected String mName;
    protected int mOunces;
    protected double mPrice;

    public CaffeinatedBeverage(String name, int ounces, double price) {
        mName = name;
        mOunces = ounces;
        mPrice = price;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getOunces() {
        return mOunces;
    }

    public void setOunces(int ounces) {
        mOunces = ounces;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaffeinatedBeverage that = (CaffeinatedBeverage) o;
        return mOunces == that.mOunces && Double.compare(that.mPrice, mPrice) == 0 && Objects.equals(mName, that.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mOunces, mPrice);
    }

}
