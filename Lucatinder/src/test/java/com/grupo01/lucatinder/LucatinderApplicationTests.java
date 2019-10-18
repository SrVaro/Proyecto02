package com.grupo01.lucatinder;

import static org.junit.Assert.assertEquals;

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
import org.springframework.test.context.junit4.SpringRunner;

import com.grupo01.lucatinder.models.Profile;
import com.grupo01.lucatinder.repository.ProfileRepository;
import com.grupo01.lucatinder.services.ProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LucatinderApplicationTests {

	/**
	 * @author AR
	 * 
	 * creacion de comentarios necesarios y prueba  testaddProfile
	 * comprueba que se añade el profile y comprueba que hay un elemento nuevo en la base de datos
	 */
	private static Logger logger;
	
	@Autowired
	private ProfileRepository conex;
	
	@Autowired
	private ProfileService conex1;

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

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		logger.info("@BeforeClass: Al inicio de las pruebas");
	}

	@Before
	public void executedBeforeEach() {
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
	 * -----
	 * TEST
	 * -----
	 */
	
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
		cantidadInicial = conex.findAll().size();
		logger.info("Numero de perfiles iniciales: " + cantidadInicial);
	
		//2. creo un elemento
		logger.info("Creando Perfil");
		conex1.addProfile(p);
	
		//3. compruebo que se ha añadido el elemento
		cantidadFinal = conex.findAll().size();
		logger.info("Numero de perfiles finales: " + cantidadFinal);
		
		//4. compruebo que el elemento está añadido
		assertEquals(cantidadFinal, cantidadInicial + 1);
		assertEquals(p.getName(), conex1.getProfile(p.getName()).get().getName());
	}
}
