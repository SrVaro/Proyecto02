package com.grupo01.lucatinder.converters;

import java.util.ArrayList;
import java.util.List;

import com.grupo01.lucatinder.models.Profile;

public class ProfileConverter {

	public static List<Profile> toProfileList(List<Object[]> rq) {

		List<Profile> profileList = new ArrayList<>();

		for (Object[] p : rq) {
			profileList.add(new Profile((int) p[0], (String) p[1], (Boolean) p[2], (int) p[3], (String) p[4],
					(boolean) p[5], (int) p[6], (int) p[7]));
		}

		return profileList;
	}

}
