public class coinToss
{
    public static void main(string[] args)
    {
        coin quarter = new coin();
        int numHeads = 0;
        int numTails = 0;
        string side = "";
        
        system.out.println("Side up = " + quarter.getSideUp());
        
        for (int counter = 1; counter <=20; counter++)
        {
            quarter.toss();
            side = quarter.getSideUp();
            system.out.println("Side up = " + side);
            if (side.equals("Heads"))
            {
                numHeads++;
            }
            else
            {
                numTails++;
            }
        }
        system.out.println("number of heads = " + numHeads);    
        system.out.println("number of heads = " + numTails);    
    }
}