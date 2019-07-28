package netprintfinder;


public class NetPrinter {
	
	String name, location, type;
	double lat, lng;
	PSchedule schedule;
	
	double distance;
	String availability;
	Boolean isAvailable;

	

	
	double gcDist(double lat_1, double lng_1, double lat_2, double lng_2) {
		double lat1 = Math.toRadians(lat_1); double lat2 = Math.toRadians(lat_2);
		double delLat = Math.toRadians(lat_1 - lat_2);
		double delLng = Math.toRadians(lng_1 - lng_2);
		double a = Math.pow(Math.sin(delLat/2), 2);
		a += Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin(delLng)/2, 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double km = 6367 * c;
		return km;
	}
	
	public void setDist(double userLat, double userLng) {
		distance = gcDist(userLat, userLng, lat, lng);
	}
	public void setAvail() {
		availability = schedule.Available();
		if (availability.equals("CLOSED")) {
			isAvailable = false;
		} else {
			isAvailable = true;
		}
	}
	
	public String toString() {
		String res = name + ", " + location + ", " + type + ", (";
		res += Double.toString(lat) + ", " + Double.toString(lng) + ")";
		res += schedule.toString() + ", ";
		res += Double.toString(distance);
		return res;
//		return name;
	}
	
	public NetPrinter(String nm, String loc, String ty, double la, double ln, PSchedule sched) {
		name = nm;
		location = loc;
		type = ty;
		lat = la;
		lng = ln;
		schedule = sched;
	}
	
	public NetPrinter() {
		
	}
	
//	public static void main(String[] args) {
//		NetPrinter a = new NetPrinter();
//		double test1 = a.gcDist(1.0, 1.0, 10.0, 10.0);
//		System.out.println(test1);
//		double test2 = a.gcDist(20, 20, 40, 40);
//		System.out.println(test2);
//
//	}

}
