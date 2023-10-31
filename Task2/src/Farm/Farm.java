package Farm;

import ReqularClasses.*;

public class Farm {
    private static int purchase;
    public FarmingList farmingList = new FarmingList();
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
            acquisition.SetName("bull number " + i + " from procurement " + purchase);
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
    public void ChickenPurchase (int count, int age, float tonnage)
    {
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Chicken();
            acquisition.SetName("chicken number " + i + " from procurement " + purchase);

            acquisition.SetAge(age);
            acquisition.SetAge(i);
            acquisition.SetChickenSex(true);
            farmingList.AddRawCattle(acquisition);
        }
    }
    public void CowPurchase (int count, int age, float tonnage)
    {
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Cow();
            acquisition.SetName("cow number " + i + " from procurement " + purchase);
            acquisition.SetAge(age);
            acquisition.SetColor(0);//black
            farmingList.AddRawCattle(acquisition);
        }
    }


    public void HorsePurchase (int count, int age, float tonnage)
    {
        for (int i = 0; i < count; i++)
        {
            var acquisition = new Horse();
            acquisition.SetName("horse number " + i + " from procurement " + purchase);
            acquisition.SetMaxEndurance(500);
            acquisition.SetAge(age);
            farmingList.AddWorkCastles(acquisition);
        }
    }
    public void PlantLemonTree(int count)
    {

        for (int i = 0; i < count; i++)
        {
            var acquisition = new LemonTree();
            acquisition.SetName("Apple tree number " + i + " from procurement " + purchase);
            acquisition.SetCropYield(50);
            acquisition.SetAcidLevel(4);//very acid
            farmingList.AddFruit(acquisition);
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
    public void SheepPurchase (int count, int age, float tonnage)
    {
        for (int i = 0; i < count; i++) {
            var acquisition = new Sheep();
            acquisition.SetName("chicken number " + i + " from procurement " + purchase);
            acquisition.SetAge(i);
            farmingList.AddRawCattle(acquisition);
        }
    }
}
