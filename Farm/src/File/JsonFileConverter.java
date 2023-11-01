package File;

import AbstractEntities.Farming;

import java.io.*;

import Farm.Farm;
import com.google.gson.Gson;

public class JsonFileConverter
{
    private final  String PATH;
    public JsonFileConverter()
    {
        this.PATH = "C:\\Users\\Павел\\IdeaProjects\\gitRep\\SolvdTrainee\\Farm\\src\\File\\SaveFile";
    }
    public JsonFileConverter (String Path)
    {
        this.PATH = Path;
    }
    public void ConvertObjectToFile(Farming object)
    {
        try (PrintWriter out = new PrintWriter(new FileWriter(PATH)))
        {
            var converter = new Gson();
            String jsonString = converter.toJson(object);

            out.write(jsonString);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void SaveObjectToFile(Farm object)
    {
        String filename = PATH;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(object);
            System.out.println("File has been written");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

    }
    public Farm LoadObjectFromFile()
    {
        Farm newFarm = new Farm();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH)))
        {
            newFarm=((Farm)ois.readObject());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        return newFarm;
    }
}



