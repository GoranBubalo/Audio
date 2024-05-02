
//Include this import 
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Main {

	// AUDIO !!!!

	// static means that the method or variable belongs to the class
	// rather than the specified instance
	// "throws" = = = > is used to create a costume error OR ues try/catch code
	// block's
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		// Create a File class, instantiating a object

		File file = new File("FunkManFUNK.wav");

		Scanner scanner = new Scanner(System.in);

		// It's an input stream with a specified audio format and length
		// the length is expressed in sample frames
		// method = > " getAudioInputStream = > Obtains an audio input stream from the
		// provided file
		// AudioSystem Class = = > entry point to audio system resources, access and
		// query mixers
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);// File is in the brackets because file =
																				// newFile("...
		// Interface = > blue print of a class. It has static constants and (  abstract methods ) => implemented by sub classes and interface
		// = = = = = > abstract methods. It's a a mechanism 
		// Create an = > clip object
		// " Clip " !!! = > Special kind of data line whose audio can be loaded prior to
		// play-back
		Clip clip = AudioSystem.getClip();

		clip.open(audioStream);

		String respons = "";

		while (!respons.equals("Q")) {
			System.out.println("P = play, S = stop, R = reset, Q = Quit");
			System.out.println("Enter your choice");

			respons = scanner.next();
			//If we don't put this method toUpperCase 
			//when the user puts the letter but the lower case is will go to "Not a valid response"
			//So with this it's not case sensitive
			respons = respons.toUpperCase();

			switch (respons) {
			case ("P"): clip.start();
			break;
			case ("S"): clip.stop();
			break;
			case ("R"): clip.setMicrosecondPosition(0);//Setting the position from witch the audio will play 
			break;
			case ("Q"): clip.close();
			break;
			default: System.out.println("Not a valid response!! ");
			break;
			}

		}
		
		System.out.println("BYE!!!!!!!!!!!!!!");
		scanner.close();

	}

}
