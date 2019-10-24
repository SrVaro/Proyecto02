package com.grupo01.lucatinder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
	
	/**
	 * @author AR
	 * 
	 * creacion de comentarios necesarios y prueba  testaddProfile
	 * comprueba que se añade el profile y comprueba que hay un elemento nuevo en la base de datos
	 */
	private static Logger logger;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@BeforeClass
	public static void onceExecutedBeforeAll() {
		logger.info("@BeforeClass: Al inicio de las pruebas");
	}

	@Before
	public void executedBeforeEach() {
		profileRepository.deleteAll();
		logger.info("@Before: Antes de cada prueba");
	}

	@AfterClass
	public static void onceExecutedAfterAll() {
		logger.info("@AfterClass: Al final de las pruebas");
	}

	@After
	public void executedAfterEach() {
		logger.info("@After: Despues de cada prueba");
	}
	
	@Ignore
	//Se usa para que no tengas que cometar un metodo, en vez de eso que se ignore y no se ejecute
	public void executionIgnored() {
		logger.info("@Ignore: This Test is ignored");
	}
	
	/*
	 * Inicializamos
	 */
	static {
		try {
			logger = LogManager.getLogger(LucatinderApplicationTests.class);
		} catch (Throwable e) {
			System.out.println("Dont work");
		}
	}

	/**
	 * @author AL
	 */
	@Test
	public void getSelectionTest() {
		
		profileRepository.deleteAll();
		
		ArrayList<Profile> pl = new ArrayList<>();
	
		Profile p1 = new Profile(1, "1", true, 25, "blabla", false, 25, 20, "blabla");
		
		Profile p2 = new Profile(2, "2", true, 2, "blabla", false, 25, 20, "blabla");
		Profile p3 = new Profile(3, "3", false, 1, "blabla", false, 25, 20, "blabla");
		Profile p4 = new Profile(4, "4", true, 5, "blabla", false, 25, 20, "blabla");
		Profile p5 = new Profile(5, "5", false, 6, "blabla", false, 25, 20, "blabla");
		Profile p6 = new Profile(6, "6", true, 7, "blabla", false, 25, 20, "blabla");
		
		profileService.addProfile(p1);
		profileService.addProfile(p2);
		profileService.addProfile(p3);
		profileService.addProfile(p4);
		profileService.addProfile(p5);
		profileService.addProfile(p6);
		
		pl.add(p1);
		pl.add(p2);
		pl.add(p3);
		pl.add(p4);
		pl.add(p5);
		pl.add(p6);
		
		assertEquals(profileService.getProfileSelection(1).size(), pl.size());
		
	}
	
	/**
	 * @author AR
	 */
	@Test
	public void testAddProfile() {
		logger.info("Prueba para comprobar que se ha añadido un perfil");
		
		int cantidadInicial = 0;
		int cantidadFinal = 0;
		Profile p = new Profile("prueba2", false, 24, "asdasd", true, 20, 30);
		
		//1. miro cuantos elementos hay
		cantidadInicial = profileRepository.findAll().size();
		logger.info("Numero de perfiles iniciales: " + cantidadInicial);
	
		//2. creo un elemento
		logger.info("Creando Perfil");
		profileService.addProfile(p);
	
		//3. compruebo que se ha añadido el elemento
		cantidadFinal = profileRepository.findAll().size();
		logger.info("Numero de perfiles finales: " + cantidadFinal);
		
		//4. compruebo que el elemento está añadido
		assertEquals(cantidadFinal, cantidadInicial + 1);
		assertEquals(p.getName(), profileService.getProfile(p.getName()).get().getName());
	}

	/**
	 * @author MC
	 */
	
	@Test
	public void testEditProfile() {
		logger.info("Prueba para comprobar que se ha editado un perfil");
		
		final Profile p = new Profile(0, "pruebaEdit", false, 24, "asdasd", true, 20, 30, "sdjugtr");
		
		logger.info("Se crea Perfil");
		profileService.addProfile(p);
		
		Profile edit= new Profile(p.getId_profile(),"pruebaEdit2",false, 24, "asdasd", true, 20, 30,"dkjfldkj");
		logger.info("Se actualiza perfil");
		profileService.updateProfile(edit);
		
		logger.info("Se lee perfil");
		Profile nuevo= profileRepository.findById(p.getId_profile()).get();
		
		
		assertNotEquals(profileService.getProfileId(p.getId_profile()),p);
		assertEquals(profileService.getProfileId(p.getId_profile()).get(),nuevo);
		assertEquals(edit,nuevo);
		assertNotEquals(p,nuevo);
	}
	/*
	 * Inicializamos
	 */
	static {
		try {
			logger = LogManager.getLogger(LucatinderApplicationTests.class);
		} catch (Throwable e) {
			System.out.println("Dont work");
		}
	}
	
	@Test
	public void testDeleteProfile() {
		logger.info("Prueba para comprobar que se ha borrado un perfil");
		
		int cantidadInicial;
		int cantidadFinal;
		
			Profile p = profileRepository.save(new Profile("prueba2", false, 24, "asdasd", true, 20, 30));
		
			//Paso 1. Miro cuantos elementos hay
			cantidadInicial = profileRepository.findAll().size();
			logger.info("Numero de perfiles iniciales: " + cantidadInicial);
			
			//Paso 2. Borro un perfil escogido anteriormente para probar
			profileService.deleteProfile(p.getId_profile());
			
			//Paso 3. Compruebo que hay uno menos
			cantidadFinal = profileRepository.findAll().size();
			logger.info("Numero de perfiles finales: " + cantidadFinal);
			
			//Paso 4. Compruebo que se ha eliminado
			assertEquals(cantidadInicial - 1, cantidadFinal);
			assertNull(profileService.getProfileId(p.getId_profile()).orElse(null));
		
	}
	
}
