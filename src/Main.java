import java.text.NumberFormat;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
	// write your code here
        String name,flavor;
        int ounces, roastType;
        double price;
        int choice;
        int count = 0;

        String lineBreak = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        Scanner keyboard = new Scanner(System.in);

        CaffeinatedBeverage [] totalBeverages = new CaffeinatedBeverage[6];

        do {
            System.out.println(lineBreak);
            System.out.println("Enter (1) to enter a Coffee entry");        // ctrl + d Duplicate
            System.out.println("Enter (2) to enter an Energy Drink entry");    // ctrl + d Duplicate
            System.out.println("Enter (3) to exit");

            choice = keyboard.nextInt();
            keyboard.nextLine();

            switch (choice)
            {
                // Coffee Drink Entry
                case 1:
                    System.out.print("Please enter the name of the coffee: ");
                    name = keyboard.nextLine();
                    System.out.print("Please enter the ounces of coffee ordered: ");
                    ounces = keyboard.nextInt();
                    System.out.print("Please enter the price of the coffee: $");
                    price = keyboard.nextDouble();
                    keyboard.nextLine();
                    System.out.println("Please enter the roast type");
                    System.out.println("Enter (1) for light roasted");        // ctrl + d Duplicate
                    System.out.println("Enter (2) for medium roasted");    // ctrl + d Duplicate
                    System.out.print("Enter (3) for dark roasted\nEnter here: ");
                    roastType = keyboard.nextInt();
                    keyboard.nextLine();

                    totalBeverages[count++] = new Coffee(name, ounces, price, roastType);
                    System.out.println("Entry added!");
                    break;
                // Energy Drink Entry
                case 2:
                    System.out.print("Please enter the name of the energy drink: ");
                    name = keyboard.nextLine();
                    System.out.print("Please enter the ounces for the energy drink: ");
                    ounces = keyboard.nextInt();
                    System.out.print("Please enter the price of the energy drink: $");
                    price = keyboard.nextDouble();
                    keyboard.nextLine();
                    System.out.print("Please enter the flavor of the energy drink: ");
                    flavor = keyboard.nextLine();

                    totalBeverages[count++] = new EnergyDrink(name, ounces, price, flavor);
                    System.out.println("Entry added!");
                    break;
                //Exit
                case 3:
                    NumberFormat currency = NumberFormat.getCurrencyInstance();
                    System.out.println(lineBreak);
                    // print totalBeverages array
                    System.out.println("Complete List of entries: \n");
                    for (int i =0; i < count; i++)
                    {
                        System.out.println( "#" + (i + 1) + ": " + totalBeverages[i]);
                    }

                    System.out.println(lineBreak);
                    // use average price method
                    double averagePrice = Main.findAveragePrice(totalBeverages, count);
                    System.out.println("Average beverage price: " + currency.format(averagePrice));

                    System.out.println(lineBreak);
                    // method to use highest priced drink
                    CaffeinatedBeverage highestPriceDrink = Main.findHighestPricedCaffeinatedBeverage(totalBeverages, count);
                    System.out.println("Highest Priced Drink: " + highestPriceDrink);

                    Coffee highestPriceCoffeeDrink = Main.findHighestPricedCoffeeDrink(totalBeverages, count);
                    System.out.println("\nHighest Priced Coffee Drink: " + highestPriceCoffeeDrink);

                    EnergyDrink highestPriceEnergyDrink = Main.findHighestPricedEnergyDrink(totalBeverages, count);
                    System.out.println("\nHighest Priced Energy Drink: " + highestPriceEnergyDrink);
                    System.out.println(lineBreak);
                    break;
            }
        }
        while (choice != 3);

        System.out.println("\nThanks for the entries! ^_^");
        keyboard.close();
    }

    /**
     *
     * @param inventory - array to be sorted through
     * @param count - where to stop, just incase array isn't filled
     * @return double average ( total / count)
     */
    public static double findAveragePrice(CaffeinatedBeverage[] inventory, int count)
    {
        double total = 0.0;
        for (int i = 0; i < count; i++)
        {
            // Add the price of beverages to the total
            total += inventory[i].getPrice();
        }
        // total prices added up
        return total / count;
    }

    /**
     *
     * @param inventory array to full from
     * @param count for array size limit, incase array not filled
     * @return Energy object of highest price
     */
    public static EnergyDrink findHighestPricedEnergyDrink(CaffeinatedBeverage[] inventory, int count)
    {
        String name = "";
        int ounces = 0;
        double maxPrice = 0.00;
        String flavor = "";

        for(int i = 0; i < count; i++)
        {
            if( inventory[i] instanceof EnergyDrink )
            {
                EnergyDrink energyDrink = (EnergyDrink) inventory[i];
                double energyDrinkPrice = energyDrink.getPrice();

                if(maxPrice < energyDrinkPrice)
                {
                        maxPrice = energyDrinkPrice;
                        name = energyDrink.getName();
                        ounces = energyDrink.getOunces();
                        flavor = energyDrink.getFlavor();
                }
            }
        }
        return new EnergyDrink(name, ounces, maxPrice, flavor);
    }


/*
    public static EnergyDrink findHighestPricedEnergyDrink(CaffeinatedBeverage[] inventory, int count)
    {
        double maxPrice = 0.0;
        EnergyDrink maxDrink = null;
        for (int i = 0; i < count ; i++)
        {
            // this filters out any coffee
            if(inventory[i] instanceof EnergyDrink)
            {
                if(inventory[i].getPrice() > maxPrice)
                {
                    maxPrice = inventory[i].getPrice();
                    // downcasting
                    maxDrink = (EnergyDrink)inventory[i];
                }
            }
        }
        return maxDrink;
    }
*/
    /**
     *
     * @param inventory array to full from
     * @param count for array size limit, incase array not filled
     * @return Coffee object of highest price
     */
    public static Coffee findHighestPricedCoffeeDrink(CaffeinatedBeverage[] inventory, int count)
    {
        String name = "";
        int ounces = 0;
        double maxPrice = 0.00;
        int roastType = 0;

        for(int i = 0; i < count; i++)
        {
            if( inventory[i].getClass() == Coffee.class)
            {
                Coffee coffeeDrink = (Coffee) inventory[i];
                double coffeeDrinkPrice = coffeeDrink.getPrice();

                if(maxPrice < coffeeDrinkPrice)
                {
                    maxPrice = coffeeDrinkPrice;
                    name = coffeeDrink.getName();
                    ounces = coffeeDrink.getOunces();
                    roastType = coffeeDrink.getRoastType();
                }
            }
        }
        return new Coffee(name, ounces, maxPrice, roastType);
    }


    /**
     *
     * @param inventory array to full from
     * @param count for array size limit, incase array not filled
     * @return CaffeinatedBeverage object w/ highest priced drink
     */
    public static CaffeinatedBeverage findHighestPricedCaffeinatedBeverage(CaffeinatedBeverage[] inventory, int count)
    {
        Coffee highestCoffeePriceDrink = Main.findHighestPricedCoffeeDrink(inventory, count);
        EnergyDrink highestPricedEnergyDrinkPriceDrink = Main.findHighestPricedEnergyDrink(inventory, count);

        if(highestCoffeePriceDrink.getPrice() < highestPricedEnergyDrinkPriceDrink.getPrice())
        {
            return highestPricedEnergyDrinkPriceDrink;
        }
        return highestCoffeePriceDrink;
    }

}
