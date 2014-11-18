package ca.ualberta.cs.lonelytwitter.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.data.LonelyTweet;
import android.content.Context;
import android.util.Log;

public class TweetsFileManager
extends TweetsManager
{
	public TweetsFileManager(Context ctx) {
		super(ctx);
	}

	@Override
	public List<LonelyTweet> loadTweets() {
		List<LonelyTweet> tweets = new ArrayList<LonelyTweet>();
	
		try {
			FileInputStream fis = ctx.openFileInput("file.sav");
			ObjectInputStream ois = new ObjectInputStream(fis);
	
			Object o = ois.readObject();
	
			if (o instanceof ArrayList) {
				tweets = (ArrayList<LonelyTweet>) o;
			} else {
				Log.i("LonelyTwitter", "Error casting");
			}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		return tweets;
	}

	@Override
	public void saveTweets(List<LonelyTweet> tweets) {
		try {
			FileOutputStream fos = ctx.openFileOutput("file.sav", 0);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
	
			oos.writeObject(tweets);
	
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
