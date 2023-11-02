package Raw;

import java.io.Serializable;

public class AbstractRaw implements Serializable
{
    public int ID;
    private String name;
    private int spawnDay;
    private float defaultCost;
    private float shelfLife = 0f;
    public float GetDefaultCost() {
        return defaultCost;
    }
    public void SetDefaultCost(float defaultCost)
    {
        this.defaultCost = defaultCost;
    }
    public float GetShelfLife() {
        return shelfLife;
    }

    public void SetShelfLife(float shelfLife) {
        this.shelfLife = shelfLife;
    }
    public int GetSpawnDay()
    {
        return this.spawnDay;
    }
    public void SetSpawnDay(int spawnDay)
    {
        this.spawnDay = spawnDay;
    }
    public void Rot()
    {

    }
    public String GetName() {
        return this.name;
    }
    public void SetName(String name) {
        this.name = name;
    }
}
