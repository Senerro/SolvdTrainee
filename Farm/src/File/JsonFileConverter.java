package File;

import AbstractEntities.Farming;

import java.io.*;

import Farm.Farm;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

public class JsonFileConverter
{
    private static final Logger LOGGER = Logger.getLogger(JsonFileConverter.class);
    private final String PATH;
    public JsonFileConverter()
    {
        this.PATH = "C:\\Users\\Павел\\IdeaProjects\\gitRep\\SolvdTrainee\\Farm\\src\\File\\SaveFile";
    }
    public JsonFileConverter (final String Path)
    {
        this.PATH = Path;
    }
    public void ConvertObjectToFile(final Farming object)
    {
        try (PrintWriter out = new PrintWriter(new FileWriter(PATH)))
        {
            var converter = new Gson();
            String jsonString = converter.toJson(object);

            out.write(jsonString);

        } catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
    }
    public void SaveObjectToFile(final Farm object)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH)))
        {
            oos.writeObject(object);
            LOGGER.debug("Save file has been saved");
        }
        catch(Exception ex){

            LOGGER.error(ex.getMessage());
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

            LOGGER.error(ex.getMessage());
        }

        return newFarm;
    }
}



