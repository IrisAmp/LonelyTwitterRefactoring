package ca.ualberta.cs.lonelytwitter.manager;

import java.util.List;

import android.content.Context;
import ca.ualberta.cs.lonelytwitter.data.LonelyTweet;

public abstract class TweetsManager {

	protected Context ctx;

	public TweetsManager(Context context)
	{
		this.ctx = context;
	}

	public abstract List<LonelyTweet> loadTweets();
	public abstract void saveTweets(List<LonelyTweet> tweets);

}