package ca.ualberta.cs.lonelytwitter.data;

import java.util.Date;

import android.util.Log;

public class ImportantLonelyTweet
extends LonelyTweet
{
	public ImportantLonelyTweet()
	{
		super();
	}
	
	public ImportantLonelyTweet(String text, Date date)
	{
		super(text, date);
	}

	@Override
	public boolean isValid()
	{
		if (tweetBody.trim().length() == 0
				|| tweetBody.trim().length() > 20)
		{
			return false;
		}
		else
			return true;
	}

	@Override
	public String toString()
	{
		String tweetString = "IMPORTANT: " + getTweetDate() + " | " + getTweetBody();
		Log.i("Dunder Tag!", tweetString);
		return tweetString;
	}

	@Override
	public String getTweetBody()
	{
		return "IMPORTANT: " + tweetBody;
	}
}
