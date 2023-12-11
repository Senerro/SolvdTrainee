package outPackage;

public class ReflectionTemplate
{
    private String name;
    protected String surname;
    public int age;
    private int tmp;
    public ReflectionTemplate()
    {
        this.name = "unknown";
        this.surname = "unknown";
        this.age = 18;
    }
    public ReflectionTemplate(String name, String surname, int age)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public ReflectionTemplate(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
        this.age = 18;
    }
    private void getAgeCode()
    {
        calculateAgeCode(age);
    }

    protected void calculateAgeCode(int age)
    {
        if(age == 4) {

            this.tmp += 2;
            return;
        }
        if(age == 2) {

            this.tmp += 1;
            return;
        }
        if(age == 1) {

            this.tmp += 0;
            return;
        }

        this.tmp++;
        if(age % 2 == 0)
        {
            calculateAgeCode(age/2);
        }
        else
            calculateAgeCode(3 * age + 1);
    }
    public String ageCode()
    {
        this.tmp=0;
        getAgeCode();
        return "Code of my age is " + this.tmp;
    }
    @Override
    public String toString()
    {
        if(age <= 0)
            return "I am " + name + ". My family is " + surname + " and I'm [DATA DELETED] years old";
        return "I am " + name + ". My family is " + surname + " and I'm " + ageCode() + " years old";
    }
}
