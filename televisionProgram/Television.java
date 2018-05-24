// The purpose of this class is to model a television.
// Blaine Jacques 3/15/17


public class Television 
{
	private String MANUFACTURER; //Field for the manufacturers brand name.
	private int SCREEN_SIZE; //Field for the size of the tv's screen.
	private boolean powerOn; //Field for the tv to be turned off and on.
	private int channel; //Field to hold the station the tv is on.
	private int volume; //Field for the current volume level of the tv.
	
	/**
		Constructor
		channel and volume are initialized to 2 and 20
		@param brand holds the MANUFACTURER's name.
		@param size holds the SCREEN_SIZE's size.
	*/
	public Television(String brand, int size)
	{
		MANUFACTURER = brand;
		SCREEN_SIZE = size;
		channel = 2;
		volume = 20;
	}

	/**
		The setChannel method sets the channel/station for the television.
		@param station is the television's channel
	*/
	public void setChannel(int station)
	{
		
		channel = station;
		
	}
	/**
		The power method sets the on or off state of the television. Preset is
		to have the television off.
		@param power controls the on and off state of the television.
	*/
	public void power()
	{
		
		powerOn = !powerOn;
			
		
	}
	/**
		The increaseVolume method +1 the volume everytime it is called
		@param Increases the volume for the television by one.
	*/
	public void increaseVolume()
	{
		volume ++;
		
	}
	/**
		The descreaseVolume method -1 the volume everytime it is called
		@param Decreases the volume for the television by one.
	*/
	public void decreaseVolume()
	{
		
		volume --;
		
	}
	
	/**
		getChannel method sets the channel/station.
		@return The channel the user chooses for the television.
	*/
	public int getChannel()
	{
		return channel; 
		
	}
	/**
		getVolume method sets the volume level
		@return the volume level for the television
	*/
	public int getVolume()
	{
		
		return volume; 
		
	}
	/**
		getManufacturer method returns the manufacturer's brand
		@return The brand of the manufacturer.
	*/
	public String getManufacturer()
	{
		
		return MANUFACTURER; 
		
	}
	/**
		getScreenSize method returns the size of the screen.
		@return The size of the screen for the television.
	*/
	public int getScreenSize()
	{
		
		return SCREEN_SIZE; 
		
	}
	
}