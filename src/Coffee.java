import java.text.NumberFormat;
import java.util.Objects;

public class Coffee extends CaffeinatedBeverage
{
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    // 1 = light roast
    // 2 = medium roast
    // 3 = dark roast
    private int mRoastType;

    public Coffee(String name, int ounces, double price, int roastType) {
        super(name, ounces, price);
        mRoastType = roastType;
    }

    public int getRoastType() {
        return mRoastType;
    }

    public void setRoastType(int roastType) {
        mRoastType = roastType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Coffee coffee = (Coffee) o;
        return mRoastType == coffee.mRoastType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mRoastType);
    }

    @Override
    public String toString()
    {
        String correctString = "";
        switch (mRoastType)
        {
            case 1:
                correctString += "Coffee:" +
                        mName + ", " +
                        mOunces + " ounces, " +
                        "light roast, " +
                        currency.format(mPrice);
                break;
            case 2:
                correctString += "Coffee:" +
                        mName + ", " +
                        mOunces + " ounces, " +
                        "medium roast, " +
                        currency.format(mPrice);
                break;
            case 3:
                correctString += "Coffee:" +
                        mName + ", " +
                        mOunces + " ounces, " +
                        "dark roast, " +
                        currency.format(mPrice);
                break;
        }

        return correctString;
    }

}


