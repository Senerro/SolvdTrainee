package Farm;

import ReqularClasses.*;

public class Farm {
    private static int purchase;
    public FarmingList farmingList = new FarmingList();
    public Farm()
    {
        PlantAppleTree (1, "golden");
        BullPurchase(2, 15, 950);
        PlantCabbage ( 3,  "Chineese");
        ChickenPurchase(2, 2, true);
        CowPurchase(5, 1);
        HorsePurchase(10, 7, 999);
        PlantLemonTree(10);
        PlantPotato(5, "Aspia");
        SheepPurchase(5, 4);
    }
    public void PlantAppleTree(int count, String sort)
    {

        for (int i = 0; i < count; i++)
        {
            var acquisition = new Appletree();
            acquisition.SetName("Apple tree number " + i + " from procurement " + purchase);
            acquisition.SetCropYield(50);
            acquisition.SetSort(sort);
            farmingList.AddFruit(acquisition);
        }
    }
    public void BullPurchase (int count, int age, float tonnage)
    {
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Bull();
            acquisition.SetName("Bull number " + i + " from procurement " + purchase);
            acquisition.SetTonage(tonnage);
            acquisition.SetAge(age);
            farmingList.AddWorkCastles(acquisition);
        }
    }
    public void PlantCabbage (int count, String sort)
    {
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Cabbage();
            acquisition.SetSort(sort);
            farmingList.AddVegetable(acquisition);
        }
    }
    public void ChickenPurchase (int count, int age, boolean sex)
    {
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Chicken();
            acquisition.SetName("Chicken number " + i + " from procurement " + purchase);

            acquisition.SetAge(age);
            acquisition.SetAge(i);
            acquisition.SetChickenSex(sex);
            farmingList.AddRawCattle(acquisition);
        }
    }
    public void CowPurchase (int count, int age)
    {
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Cow();
            acquisition.SetName("Cow number " + i + " from procurement " + purchase);
            acquisition.SetAge(age);
            acquisition.SetColor(0);//black
            farmingList.AddRawCattle(acquisition);
        }
    }

    public void HorsePurchase (int count, int age, int endurance)
    {
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Horse();
            acquisition.SetName("horse number " + i + " from procurement " + purchase);
            acquisition.SetMaxEndurance(endurance);
            acquisition.SetAge(age);
            farmingList.AddWorkCastles(acquisition);
        }
    }
    public void PlantLemonTree(int count)
    {

        for (int i = 0; i < count; i++)
        {
            var acquisition = new LemonTree();
            acquisition.SetName("Lemon tree number " + i + " from procurement " + purchase);
            acquisition.SetCropYield(50);
            acquisition.SetAcidLevel(4);//very acid
            farmingList.AddFruit(acquisition);
        }

    }
    public void PigPurchase (int count, int age)
    {
        for (int i = 0; i < count; i++) {
            var acquisition = new Pig();
            acquisition.SetName("Pig number " + i + " from procurement " + purchase);
            acquisition.SetAge(age);
            farmingList.AddRawCattle(acquisition);
        }
    }
    public void PlantPotato (int count, String sort)
    {
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Potato();
            acquisition.SetSort(sort);
            acquisition.SetName("Potato number " + i + " from procurement" + purchase);
            acquisition.SetSort(sort);
            acquisition.SetSize(2);// little
            farmingList.AddVegetable(acquisition);
        }
    }
    public void SheepPurchase (int count, int age)
    {
        for (int i = 0; i < count; i++) {
            var acquisition = new Sheep();
            acquisition.SetName("Sheep number " + i + " from procurement " + purchase);
            acquisition.SetAge(age);
            farmingList.AddRawCattle(acquisition);
        }
    }
    public static void main(String[] args)
    {
        var obj = new Farm();
       System.out.println("All is working");
    }
}
