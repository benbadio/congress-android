package com.sunlightlabs.android.congress.notifications.finders;

import java.util.Arrays;
import java.util.List;

import android.content.Intent;
import android.util.Log;

import com.sunlightlabs.android.congress.LegislatorTabs;
import com.sunlightlabs.android.congress.notifications.Subscription;
import com.sunlightlabs.android.congress.notifications.NotificationFinder;
import com.sunlightlabs.android.congress.utils.Utils;
import com.sunlightlabs.youtube.Video;
import com.sunlightlabs.youtube.YouTube;
import com.sunlightlabs.youtube.YouTubeException;

public class YoutubeFinder extends NotificationFinder {

	@Override
	public String decodeId(Object result) {
		if (!(result instanceof Video))
			throw new IllegalArgumentException("The result must be of type com.sunlightlabs.youtube.Video");
		return String.valueOf(((Video) result).timestamp.toMillis(true));
	}

	@Override
	public List<?> fetchUpdates(Subscription subscription) {
		try {
			String username = subscription.data;
			return Arrays.asList(new YouTube().getVideos(username));
		} catch (YouTubeException e) {
			Log.w(Utils.TAG, "YoutubeFinder: Could not fetch youtube videos for " + subscription, e);
			return null;
		}
	}

	@Override
	public Intent notificationIntent(Subscription subscription) {
		return Utils.legislatorLoadIntent(subscription.id, Utils
				.legislatorTabsIntent().putExtra("tab", LegislatorTabs.Tabs.videos));
	}
}