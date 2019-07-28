package netprintfinder;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;



public class NetprintFinder {
	
	static ArrayList<NetPrinter> bw;
	static ArrayList<NetPrinter> color;
	static ArrayList<NetPrinter> bwOpen;
	static ArrayList<NetPrinter> colOpen;
	
	
	public static String getUserLatLng() {
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new SafariDriver();                
		
		String ERR_MESSAGE = "Error finding your location. Check your internet connection.";
		
		long starttime = System.currentTimeMillis();
		
		driver.get("https://www.gps-coordinates.net/");
		String latlong = "";
		int TIMEOUT = 15000;
		long tick = System.currentTimeMillis(); long tock;
		List<WebElement> elems = driver.findElements(By.id("latlong"));

		while (latlong.equals("") && System.currentTimeMillis()-starttime < TIMEOUT) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println(ERR_MESSAGE);
				e.printStackTrace();
			}
        	elems = driver.findElements(By.id("latlong"));
        	latlong = elems.get(0).getAttribute("value");
        	
            tock = System.currentTimeMillis();
            if (tock-tick >= 1000) {
                tick = tock;
                System.out.println("...");
            }
        }
		driver.quit();
//		System.out.println("Finished successfully.");
		return latlong;
	}

	
	public static void getData() {
		NetprintData Data = new NetprintData();
		bw = new ArrayList<NetPrinter>();
		Data.addAllBW(bw);
		color = new ArrayList<NetPrinter>();
		Data.addAllCol(color);
	}
	
	
	public static void findClosest(double lat, double lng) {
		getData();
		
		bwOpen = new ArrayList<NetPrinter>();
		for (NetPrinter p : bw) {
			p.setDist(lat, lng);
			p.setAvail();
			if (p.isAvailable) {
				bwOpen.add(p);
			}
		}
		bwOpen.sort((p1, p2) -> Double.compare(p1.distance, p2.distance));
//		System.out.println(bwOpen);
		
		colOpen = new ArrayList<NetPrinter>();
		for (NetPrinter p : color) {
			p.setDist(lat, lng);
			p.setAvail();
			if (p.isAvailable) {
				colOpen.add(p);
			}
		}
		colOpen.sort((p1, p2) -> Double.compare(p1.distance, p2.distance));

	}

	public static void printPrinter(NetPrinter p, int i) {
		String msg = "Option " + (i+1) + ": ";
		msg += "go to printer '" + p.location;
		msg += "', which is " + Math.round(p.distance*100)/100.0 + " km away. " + p.availability;
		System.out.println(msg + "\n");
	}
	
	private static void listResults() {
		int N1 = 5;
		int N2 = 5;
		
		System.out.println("Nearest black-and-white printers:\n");
		for (int i = 0; i<N1; i++) {
			NetPrinter p = bwOpen.get(i);
			printPrinter(p, i);
		}
		
		System.out.println("\nNearest color printers:\n");
		for (int i = 0; i<N2; i++) {
			NetPrinter p = colOpen.get(i);
			printPrinter(p, i);
		}
		
	}

	
	

	public static void main(String[] args) {

		char Mode = 's';
		
		if (Mode=='c') {
			try {
				String parentFolder = new File(NetprintFinder.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParent(); 
				String pathstring = parentFolder.concat("/other_dependencies/chromedriver");
				System.setProperty("webdriver.chrome.driver", pathstring);			
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
		
		String msg = "Searching for GPS info - please wait a few seconds.";
		msg = msg.concat("\nIf browser requests any permissions, accept; otherwise don\'t touch computer.");
		System.out.println(msg);
		
		String latlng = getUserLatLng();
		double lat = Double.parseDouble(latlng.substring(0, latlng.indexOf(",")));
		double lng = Double.parseDouble(latlng.substring(latlng.indexOf(",")+1, latlng.length()));

//		System.out.println(latlng);
		
		findClosest(lat, lng);
		
//		NetPrinter p = bwOpen.get(2);
//		System.out.println(p.location + ", " + p.lat + ", " +  p.lng + ", dist " + p.distance);
		
		listResults();

		
	}


}
