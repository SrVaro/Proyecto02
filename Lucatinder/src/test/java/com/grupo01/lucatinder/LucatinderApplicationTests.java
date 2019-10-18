package com.grupo01.lucatinder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.grupo01.lucatinder.models.Profile;
import com.grupo01.lucatinder.repository.ProfileRepository;
import com.grupo01.lucatinder.services.ProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LucatinderApplicationTests {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private ProfileRepository profileRepository;

	@Test
	public void getSelectionTest() {
		
		profileRepository.deleteAll();
	
		Profile p1 = new Profile(0, "1", true, 25, "blabla", false, 25, 20, "blabla");
		Profile p2 = new Profile(0, "2", true, 2, "blabla", false, 25, 20, "blabla");
		Profile p3 = new Profile(0, "3", false, 1, "blabla", false, 25, 20, "blabla");
		Profile p4 = new Profile(0, "4", true, 5, "blabla", false, 25, 20, "blabla");
		Profile p5 = new Profile(0, "5", false, 6, "blabla", false, 25, 20, "blabla");
		Profile p6 = new Profile(0, "6", true, 7, "blabla", false, 25, 20, "blabla");
		
		profileService.getContactList(1);
		
	}
}
