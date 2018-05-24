import java.util.random;

public class coin
{
    string sideUp;
    
    public coin ()
    {
        toss();
    }
    public void toss()
    {
        random side = new Random();
        int number = side.nextInt(2);
        if (number == 0)
        {
            sideUp = "Heads";
        }
        else {
        sideUp = "Tails";
        }
    public string getSideUp()
    {
        return sideUp;
    }
}
        