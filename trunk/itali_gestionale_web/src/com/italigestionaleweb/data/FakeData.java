package com.italigestionaleweb.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.italigestionaleweb.bean.PostBean;

public class FakeData {
	
	private static List<PostBean> posts = null;

	public static List<PostBean> getPosts() {
		
		if (posts == null) {
			posts = new ArrayList<PostBean>();
			
			Calendar now = Calendar.getInstance();
			
			PostBean post = new PostBean();
			post.setAuthor("Alessandro Martorello");
			post.setContent("<p> Benvenuto nel Gestionale Italian Express - Il Gusto Italino in viaggio </p>");
			post.setTime(now.getTime());
			
			posts.add(post);
			
		}
		
		return posts;
	}

	public static void setPosts(List<PostBean> posts) {
		FakeData.posts = posts;
	}

}
