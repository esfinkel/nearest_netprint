package netprintfinder;

import java.util.ArrayList;

public class NetprintData {


	public void addPrinter(ArrayList<NetPrinter> list, String name, String location, String type, double lat, double lng, PSchedule schedule) {
		NetPrinter p = new NetPrinter(name, location, type, lat, lng, schedule);
		list.add(p);
	}
	
	
	public void addAllBW(ArrayList<NetPrinter> bw) {
		PSchedule empty = new PSchedule();
		PSchedule sched = new PSchedule();

		//bw = nearest_netprint.printers_bw
		//for p in bw:
		//    if p[5] is None:
		//        psched = 'empty'
		//    else:
		//        psched = ', '.join([str(float(p[5][i][0])) + ', ' + str(float(p[5][i][1])) for i in range(7)])
		//        print('sched = new PSchedule(' + psched + ');')
		//        psched = 'sched'
		//    print('addPrinter(bw, "' + p[0] + '", "' + p[1] + '", "' + p[2] + '", ' + str(float(p[3])) + ', ' + str(float(p[4])) + ', ' + psched + ');')
		// manually escape quotes

		addPrinter(bw, "aap-nyc-1bw", "NYTech (direct print; card reader)", "campus-bw, campus-color", 40.7558, -73.9562, empty);
		addPrinter(bw, "aap-sib-1bw", "Sibley Hall - 3rd Floor Lab (Barclay Jones)", "campus-bw, campus-color", 42.4509802, -76.4840158, empty);
		addPrinter(bw, "aap-sib-3bw", "Sibley Hall - 2nd Floor Lab (ADMS) (direct print; card reader?)", "campus-bw, campus-color", 42.4509802, -76.4840158, empty);
		addPrinter(bw, "aap-sib-4bw", "Sibley Hall - 3rd Floor Balcony (inside dome) (direct print; card reader?)", "campus-bw, campus-color", 42.4509802, -76.4840158, empty);
		addPrinter(bw, "aap-tjaden-1bw", "Tjaden Hall - Take elev. to 2W (direct print or card reader)", "campus-bw, campus-color", 42.4509025, -76.4853131, empty);
		sched = new PSchedule(9.0, 23.0, 9.0, 23.0, 9.0, 23.0, 9.0, 23.0, 9.0, 17.0, 13.0, 17.0, 16.0, 23.0);
		addPrinter(bw, "afr-lib1", "Africana Library", "campus-bw, campus-color", 42.4573916, -76.4822137, sched);
		sched = new PSchedule(9.0, 22.0, 9.0, 22.0, 9.0, 22.0, 9.0, 22.0, 9.0, 22.0, 11.0, 22.0, 12.0, 22.0);
		addPrinter(bw, "appel1", "Appel Commons Community Center - 1st Floor", "campus-bw", 42.4535925, -76.4764187, sched);
		addPrinter(bw, "becker-nprint1", "Becker House - Room G39 - Computer Lab - North wing - Ground floor", "campus-bw", 42.448204, -76.4894583, empty);
		addPrinter(bw, "becker-nprint2", "Becker House - Computer lab - North wing - Ground floor Room# G39", "campus-bw", 42.448204, -76.4894583, empty);
		addPrinter(bw, "bin1", "Statler Hall 365 - by the lab monitor desk - fourth from window", "campus-bw", 42.4454727, -76.48206789999999, empty);
		addPrinter(bw, "bin2", "Statler Hall 365 - by the lab monitor desk - third from window", "campus-bw", 42.4454727, -76.48206789999999, empty);
		addPrinter(bw, "bin3", "Statler Hall 365 - by the lab monitor desk - second from window", "campus-bw", 42.4454727, -76.48206789999999, empty);
		addPrinter(bw, "catherwood-lnge", "Catherwood Library - 136 Ives Hall - First Floor Lounge", "campus-bw, campus-color", 42.4472562, -76.4811158, empty);
		addPrinter(bw, "catherwood-np1/catherwood-np2/catherwood-np3", "Catherwood Library - 236 Ives Hall - Reference Area", "campus-bw, campus-color", 42.4472562, -76.4811158, empty);
		addPrinter(bw, "cisuglab", "Gates Hall - Room G33 (CS majors/staff only. direct print; no card reader?)", "campus-bw", 42.4449769, -76.4810912, empty);
		sched = new PSchedule(0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0);
		addPrinter(bw, "cit-carp-1bw/cit-carp-3bw", "Carpenter Hall Computer Lab - Main Floor", "campus-bw, campus-color", 42.444767, -76.484124, sched);
		sched = new PSchedule(0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0);
		addPrinter(bw, "cit-carp-4bw/cit-carp-5bw", "Carpenter Hall Computer Lab - Second Floor Hallway", "campus-bw, campus-color", 42.444767, -76.484124, sched);
		addPrinter(bw, "cit-mann220a-1bw/cit-mann220a-2bw", "Mann Library Computer Lab - Room 220A - Second Floor", "campus-bw, campus-color", 42.448766, -76.4763118, empty);
		addPrinter(bw, "cit-ph318-1bw/cit-ph318-2bw", "Phillips Hall Computer Lab - Room 318", "campus-bw, campus-color", 42.4445768, -76.4820529, empty);
		sched = new PSchedule(9.0, 23.99, 9.0, 23.99, 9.0, 23.99, 9.0, 23.99, 9.0, 23.99, 11.0, 23.99, 12.0, 23.99);
		addPrinter(bw, "cit-rpcc-1bw/cit-rpcc-2bw", "Robert Purcell Community Center - RPCC - Computer Lab - Room 207", "campus-bw, campus-color", 42.4562967, -76.4783146, sched);
		addPrinter(bw, "cit-surge-1bw", "Ag Quad - Academic Surge B - Room 159", "campus-bw, campus-color", 42.4488081, -76.4780298, empty);
		addPrinter(bw, "cit-upson-1bw/cit-upson-2bw", "Upson Hall - Room 225", "campus-bw, campus-color", 42.4439852, -76.4828736, empty);
		sched = new PSchedule(8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 21.0, 12.0, 21.0, 10.0, 25.0);
		addPrinter(bw, "cit-uris-1bw/cit-uris-2bw", "Uris Library - Tower Room Computer Lab - Downstairs from Entrance", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 21.0, 12.0, 21.0, 10.0, 25.0);
		addPrinter(bw, "cit-uris-3bw", "Uris Library - Electronic Classroom - Room B05", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(9.0, 16.0, 9.0, 16.0, 9.0, 16.0, 9.0, 16.0, 9.0, 16.0, 0.0, -1.0, 0.0, -1.0);
		addPrinter(bw, "cit-wsh-1bw/cit-wsh-2bw", "Willard Straight Hall - Computer Lab - Basement Level", "campus-bw, campus-color", 42.4465919, -76.4856765, sched);
		addPrinter(bw, "ciw2", "District of Columbia - Cornell in Washington", "campus-bw, campus-color", 42.4358405, -76.493497, empty);
		addPrinter(bw, "cook-nprint1", "Alice Cook House - Computer Lab", "campus-bw", 42.4489805, -76.4896109, empty);
		addPrinter(bw, "dss-mps-lab1", "MPS Statistics computing lab room Mallot 301A - card reader door access for MPS students only", "campus-bw", 42.4479101, -76.4800518, empty);
		addPrinter(bw, "gs1", "Goldwin Smith Hall - Room 338 (direct print; card reader?)", "campus-bw", 42.44907329999999, -76.4835344, empty);
		addPrinter(bw, "gs3", "Goldwin Smith Hall – Room 213 (direct print; card reader?)", "campus-bw", 42.44907329999999, -76.4835344, empty);
		addPrinter(bw, "hollister1", "Hollister 202 CEE Undergrad Lounge (direct print; card reader?)", "campus-bw", 42.4443332, -76.4847092, empty);
		addPrinter(bw, "house5", "Rose House - Computer Lab - Room# 110", "campus-bw", 42.4477928, -76.4888006, empty);
		sched = new PSchedule(8.0, 23.0, 8.0, 23.0, 8.0, 23.0, 8.0, 23.0, 8.0, 17.0, 0.0, 0.0, 14.0, 23.0);
		addPrinter(bw, "ilr-lab1/ilr-lab2", "Ives Hall - Room 118 - Computer Lab", "campus-bw, campus-color", 42.4472571, -76.4811162, sched);
		addPrinter(bw, "keeton-nprint1", "Keeton House - Room 151 - Computer Lab", "campus-bw", 42.4467158, -76.4894902, empty);
		sched = new PSchedule(8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 22.0, 10.0, 22.0, 10.0, 26.0);
		addPrinter(bw, "kroch-lib1", "Kroch Library - 1st floor Asia reading room", "campus-bw, campus-color", 42.4477741, -76.4841596, sched);
		addPrinter(bw, "laprinter2", "Kennedy Hall - Room 467 (direct print; card reader?)", "campus-bw", 42.4482603, -76.4793974, empty);
		sched = new PSchedule(8.0, 20.0, 8.0, 20.0, 8.0, 20.0, 8.0, 20.0, 8.0, 17.0, 11.0, 17.0, 12.0, 20.0);
		addPrinter(bw, "law-lib1", "Law Library - 3rd floor", "campus-bw", 42.4438549, -76.48577239999997, sched);
		sched = new PSchedule(8.0, 24.0, 8.0, 24.0, 8.0, 24.0, 8.0, 24.0, 8.0, 18.0, 12.0, 19.0, 12.0, 24.0);
		addPrinter(bw, "mann1/mann2/mann3", "Mann Library - First Floor", "campus-bw, campus-color", 42.4487577, -76.47631179999999, sched);
		sched = new PSchedule(8.0, 24.0, 8.0, 24.0, 8.0, 24.0, 8.0, 24.0, 8.0, 18.0, 12.0, 19.0, 12.0, 24.0);
		addPrinter(bw, "mann6", "Mann Library - 2nd Floor", "campus-bw, campus-color", 42.448766, -76.47631179999999, sched);
		sched = new PSchedule(8.0, 20.0, 8.0, 20.0, 8.0, 20.0, 8.0, 20.0, 8.0, 20.0, 0.0, 0.0, 13.0, 22.0);
		addPrinter(bw, "math-lib2", "Mallott Hall - Math Library - Fourth Floor", "campus-bw", 42.4482224, -76.4802083, sched);
		addPrinter(bw, "mcfaddin1/mcfaddin2", "McFaddin - Room G22 - Computer Lab", "campus-bw", 42.447337, -76.487931, empty);
		addPrinter(bw, "morrison-1", "Morrison Hall - Animal Science Undergraduate Student Lounge - Room 140 (direct print; card reader?)", "campus-bw", 42.446309, -76.469368, empty);
		addPrinter(bw, "mseugrad", "Bard Lab 247 (direct print; card reader?)", "campus-bw", 42.4439614, -76.5018807, empty);
		addPrinter(bw, "mth-372/mth-373/mth-374/mth-375", "Myron Taylor Hall 2nd Floor Computer Lab (direct print; card reader?)", "campus-bw", 42.44446, -76.486113, empty);
		addPrinter(bw, "mth-ilj", "Myron Taylor Hall International Law Journal Office (direct print; card reader?)", "campus-bw", 42.44446, -76.486113, empty);
		addPrinter(bw, "mth-jlpp", "Myron Taylor Hall Journal Law and Public Policy Office (direct print; card reader?)", "campus-bw", 42.44446, -76.486113, empty);
		addPrinter(bw, "mth-lawreview", "Myron Taylor Hall Law Review Office (direct print; card reader?)", "campus-bw", 42.44446, -76.486113, empty);
		addPrinter(bw, "mth-studentorg", "Myron Taylor Hall Student Organizations Office (direct print; card reader?)", "campus-bw", 42.44446, -76.486113, empty);
		sched = new PSchedule(9.0, 22.0, 9.0, 22.0, 9.0, 22.0, 9.0, 22.0, 9.0, 17.0, 12.0, 5.0, 14.0, 22.0);
		addPrinter(bw, "music-lib1", "Music Library - 3rd floor Lincoln Hall", "campus-bw, campus-color", 42.4501817, -76.4833675, sched);
		sched = new PSchedule(8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 22.0, 10.0, 22.0, 10.0, 26.0);
		addPrinter(bw, "olin-lib1/olin-lib2/olin-lib3/olin-lib4", "Olin Library - behind the reference desk", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 22.0, 10.0, 22.0, 10.0, 26.0);
		addPrinter(bw, "olin-lib6", "Olin Library - B12", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 22.0, 10.0, 22.0, 10.0, 26.0);
		addPrinter(bw, "olin-lib7", "Olin Library - 5th floor Grad Study", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		addPrinter(bw, "orie-netprint2", "Rhodes Hall - Room 453 (direct print; no card reader)", "campus-bw", 42.4433613, -76.4812668, empty);
		addPrinter(bw, "orie-netprint3", "Rhodes Hall - Room 421 (moved to 411? direct print; no card reader)", "campus-bw", 42.4433613, -76.4812668, empty);
		sched = new PSchedule(0.0, 1000.0, 0.0, 1000.0, 0.0, 1000.0, 0.0, 1000.0, 0.0, 1000.0, 0.0, 1000.0, 0.0, 1000.0);
		addPrinter(bw, "physci-lib1", "Clark Hall - Physical Sciences Library", "campus-bw, campus-color", 42.4497606, -76.4812001, sched);
		addPrinter(bw, "sage-205/sage-205-bw2", "Sage Hall - Room 205 Suite - Next to Dean's Office", "campus-bw, campus-color", 42.4458918, -76.4833009, empty);
		addPrinter(bw, "sage-301-bw", "Sage Hall Library - Room 301 - Third Floor Collaboration Space", "campus-bw, campus-color", 42.4458947, -76.4832581, empty);
		addPrinter(bw, "sage-basement-a/sage-basement-b", "Sage Hall - Basement - Near Student Mailboxes", "campus-bw", 42.4458918, -76.4833009, empty);
		sched = new PSchedule(7.0, 21.0, 7.0, 21.0, 7.0, 21.0, 7.0, 21.0, 7.0, 21.0, 7.0, 21.0, 7.0, 21.0);
		addPrinter(bw, "sage-lib1-bw/sage-lib2-bw", "Sage Hall - Library - First Floor", "campus-bw", 42.4458918, -76.4833009, sched);
		addPrinter(bw, "schwartz1", "Schwartz Center - Second Floor - Near elevator (direct print; card reader?)", "campus-bw", 42.4424328, -76.4859273, empty);
		addPrinter(bw, "sha-grad1", "Statler Hall G0032 (direct print; card reader?)", "campus-bw", 42.4668288, -76.4851556, empty);
		addPrinter(bw, "sha-grad2", "Statler Hall 245", "campus-bw (direct print; card reader?)", 42.4668288, -76.4851556, empty);
		sched = new PSchedule(8.0, 23.5, 8.0, 23.5, 8.0, 23.5, 8.0, 23.5, 8.0, 18.5, 12.0, 18.5, 12.0, 23.5);
		addPrinter(bw, "sha-mslc-front1/sha-mslc-front2/sha-mslc-front3", "Nestle Library - west side of reference desk", "campus-bw", 42.446092, -76.4815932, sched);
		addPrinter(bw, "sha-mslc-lounge", "Statler Hall Ground Floor Student Lounge - North side of room", "campus-bw", 42.4668288, -76.4851556, empty);
		addPrinter(bw, "sha-mslc-quick", "Nestle Library - by the standup \"Quick Print\" stations", "campus-bw", 42.446092, -76.4815932, empty);
		addPrinter(bw, "snee-netprint1", "Snee Hall Student Lounge", "campus-bw", 42.443653, -76.484938, empty);
		sched = new PSchedule(8.0, 23.0, 8.0, 23.0, 8.0, 23.0, 8.0, 23.0, 8.0, 17.5, 0.0, 0.0, 15.0, 23.0);
		addPrinter(bw, "tatkon1", "South Balch Hall - Tatkon Center - Front Desk", "campus-bw", 42.453212, -76.479392, sched);
		sched = new PSchedule(8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 21.0, 12.0, 21.0, 10.0, 25.0);
		addPrinter(bw, "uris-lib1", "Uris Library - In Front of Circulation Desk", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 21.0, 12.0, 21.0, 10.0, 25.0);
		addPrinter(bw, "uris-lib3", "Uris Library - Austen Room", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 21.0, 12.0, 21.0, 10.0, 25.0);
		addPrinter(bw, "uris-lib5", "Uris Library - CL3 Lab", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(7.5, 23.0, 7.5, 23.0, 7.5, 23.0, 7.5, 23.0, 7.5, 20.0, 10.0, 20.0, 10.0, 23.0);
		addPrinter(bw, "vetlib2", "Schurman Hall - S1201 (direct print; card reader?)", "campus-color", 42.4480179, -76.4661765, sched);
		sched = new PSchedule(7.5, 23.0, 7.5, 23.0, 7.5, 23.0, 7.5, 23.0, 7.5, 20.0, 10.0, 20.0, 10.0, 23.0);
		addPrinter(bw, "vetlib3", "Schurman Hall - S1201 (direct print; card reader?)", "campus-bw", 42.4480179, -76.4661765, sched);
		addPrinter(bw, "vm-bilinski-01", "Bilinski Lab (direct print; card reader?)", "campus-bw", 42.4799809, -76.4511259, empty);
		addPrinter(bw, "vm-wiswall-01/vm-wiswall-02", "Wiswall Lab (direct print; card reader?)", "campus-bw", 42.4799809, -76.4511259, empty);
		addPrinter(bw, "whitelab", "White Hall - Room B10 (direct print; faculty and grads only)", "campus-bw", 42.4502416, -76.4853705, empty);	
	}
	
	
	public void addAllCol(ArrayList<NetPrinter> col) {
		PSchedule empty = new PSchedule();
		PSchedule sched = new PSchedule();
		
		addPrinter(col, "aap-sib-1c", "Sibley Hall - 3rd Floor Lab (Barclay Jones),", "campus-bw, campus-color", 42.4509802, -76.4840158, empty);
		addPrinter(col, "aap-sib-3c", "Sibley Hall - 2nd Floor Lab (ADMS) (direct print; card reader?)", "campus-bw, campus-color", 42.4509802, -76.4840158, empty);
		addPrinter(col, "aap-sib-3mfp/aap-sib-4c", "Sibley Hall - 3rd Floor Balcony (inside dome) (direct print; card reader?)", "campus-bw, campus-color", 42.4509802, -76.4840158, empty);
		sched = new PSchedule(9.0, 16.0, 9.0, 16.0, 9.0, 16.0, 9.0, 16.0, 9.0, 16.0, 0.0, 0.0, 0.0, 0.0);
		addPrinter(col, "aap-tjaden-1c", "Tjaden Hall - Take elev. to 2W (broken as of spr 2019; direct print or card reader)", "campus-bw, campus-color", 42.4509025, -76.4853131, sched);
		addPrinter(col, "aep-netprint1", "Clark Hall - Room 244 (AEP only) (direct print; card reader?)", "campus-bw, campus-color", 42.4497606, -76.4812001, empty);
		sched = new PSchedule(9.0, 23.0, 9.0, 23.0, 9.0, 23.0, 9.0, 23.0, 9.0, 17.0, 13.0, 17.0, 16.0, 23.0);
		addPrinter(col, "africana-1st-floor", "Africana first floor", "campus-bw, campus-color", 42.457403, -76.482239, sched);
		addPrinter(col, "bin-color", "Statler Hall 365 - by the lab monitor desk - closest to window", "campus-bw, campus-color", 42.4668288, -76.4851556, empty);
		addPrinter(col, "catherwood-library1", "Catherwood Library", "campus-bw, campus-color", 42.4472562, -76.4811158, empty);
		addPrinter(col, "catherwood-np4c", "Catherwood Library - 236 Ives Hall - Reference Area", "campus-bw, campus-color", 42.4472562, -76.4811158, empty);
		sched = new PSchedule(8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 22.0, 10.0, 22.0, 10.0, 26.0);
		addPrinter(col, "cbs-olin-basement-2c", "Olin Library", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0, 0.0, 600.0);
		addPrinter(col, "cit-carp-2c", "Carpenter Hall Computer Lab - Main Floor", "campus-bw, campus-color", 42.444767, -76.484124, sched);
		sched = new PSchedule(8.0, 24.0, 8.0, 24.0, 8.0, 24.0, 8.0, 24.0, 8.0, 18.0, 12.0, 19.0, 12.0, 24.0);
		addPrinter(col, "cit-mann220a-3c", "Mann Library Computer Lab - Room 220A - Second Floor", "campus-bw, campus-color", 42.448766, -76.476312, sched);
		addPrinter(col, "cit-ph318-3c", "Phillips Hall Computer Lab - Room 318", "campus-bw, campus-color", 42.4445768, -76.4820529, empty);
		sched = new PSchedule(9.0, 23.99, 9.0, 23.99, 9.0, 23.99, 9.0, 23.99, 9.0, 23.99, 11.0, 23.99, 12.0, 23.99);
		addPrinter(col, "cit-rpcc-3c", "Robert Purcell Community Center - RPCC - Computer Lab - Room 207", "campus-bw, campus-color", 42.4562967, -76.4783146, sched);
		addPrinter(col, "cit-upson-3c", "Upson Hall - Room 225", "campus-bw, campus-color", 42.4439852, -76.4828736, empty);
		sched = new PSchedule(8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 21.0, 12.0, 21.0, 10.0, 25.0);
		addPrinter(col, "cit-uris-4c", "Uris Library - Tower Room Computer Lab - Downstairs from Entrance", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		addPrinter(col, "cit-weill-1c", "B25 Weill Hall - 237 Tower Road", "campus-bw, campus-color", 42.4468068, -76.477214, empty);
		sched = new PSchedule(9.0, 16.0, 9.0, 16.0, 9.0, 16.0, 9.0, 16.0, 9.0, 16.0, 0.0, -1.0, 0.0, -1.0);
		addPrinter(col, "cit-wsh-3c", "Willard Straight Hall - Computer Lab - Basement Level", "campus-bw, campus-color", 42.4465919, -76.4856765, sched);
		addPrinter(col, "ciw1", "District of Columbia - Cornell in Washington", "campus-bw, campus-color", 38.908422, -77.048536, empty);
		addPrinter(col, "csmenglab", "Gates Hall - Room G23 (direct print; card reader? under construction as of Spr 2019)", "campus-bw, campus-color", 42.4449769, -76.4810912, empty);
		addPrinter(col, "hollister2c", "Hollister 202 CEE Undergrad Lounge (direct print; card reader?)", "campus-bw, campus-color", 42.444368, -76.48463919999999, empty);
		sched = new PSchedule(8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 22.0, 10.0, 22.0, 10.0, 26.0);
		addPrinter(col, "kroch-lib-2-mfp/kroch-lib-3-mfp", "Kroch Library", "campus-bw, campus-color", 42.447774, -76.48416, sched);
		addPrinter(col, "lacolor1", "Kennedy Hall - Room 467 (direct print; card reader?)", "campus-bw, campus-color", 42.4482603, -76.4793974, empty);
		sched = new PSchedule(8.0, 20.0, 8.0, 20.0, 8.0, 20.0, 8.0, 20.0, 8.0, 17.0, 11.0, 17.0, 12.0, 20.0);
		addPrinter(col, "law-mfp1", "Law", "campus-bw, campus-color", 42.4438549, -76.48577239999997, sched);
		sched = new PSchedule(9.0, 22.0, 9.0, 22.0, 9.0, 22.0, 9.0, 22.0, 9.0, 17.0, 12.0, 5.0, 14.0, 22.0);
		addPrinter(col, "lincoln-2floor", "lincoln-second floor", "campus-bw, campus-color", 42.4501817, -76.4833675, sched);
		sched = new PSchedule(8.0, 24.0, 8.0, 24.0, 8.0, 24.0, 8.0, 24.0, 8.0, 18.0, 12.0, 19.0, 12.0, 24.0);
		addPrinter(col, "mann-mfp1/mann-mfp2", "Mann", "campus-bw, campus-color", 42.448766, -76.47631179999999, sched);
		sched = new PSchedule(8.0, 24.0, 8.0, 24.0, 8.0, 24.0, 8.0, 24.0, 8.0, 18.0, 12.0, 19.0, 12.0, 24.0);
		addPrinter(col, "mann4c", "Mann Library - First Floor", "campus-bw, campus-color", 42.448766, -76.47631179999999, sched);
		sched = new PSchedule(8.0, 22.0, 8.0, 22.0, 8.0, 22.0, 8.0, 22.0, 8.0, 17.0, 0.0, 0.0, 0.0, 0.0);
		addPrinter(col, "mann5color", "Mann Library - Basement B30 Area", "campus-bw, campus-color", 42.448766, -76.47631179999999, sched);
		sched = new PSchedule(8.0, 20.0, 8.0, 20.0, 8.0, 20.0, 8.0, 20.0, 8.0, 20.0, 0.0, 0.0, 13.0, 22.0);
		addPrinter(col, "math-lib3c", "Mallott Hall - Math Library - Fourth Floor", "campus-bw, campus-color", 42.4482224, -76.4802083, sched);
		addPrinter(col, "mpslab", "Gates Hall - Room G23 (direct print; card reader? under construction as of Spr 2019)", "campus-bw, campus-color", 42.4449769, -76.4810912, empty);
		addPrinter(col, "mth-color", "Myron Taylor Hall 2nd Floor Computer Lab (direct print; card reader?)", "campus-bw, campus-color", 42.44446, -76.486113, empty);
		addPrinter(col, "nytech-netprnt1", "Roosevelt Island - Bloomberg Center Room 181 (direct print; card reader?)", "campus-color", 40.76050310000001, -73.9509934, empty);
		addPrinter(col, "nytech-netprnt2", "NYTech - 111 8th Avenue (direct print; card reader?)", "campus-color", 42.4439614, -76.5018807, empty);
		sched = new PSchedule(8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 22.0, 10.0, 22.0, 10.0, 26.0);
		addPrinter(col, "olin-lib-4thfloor", "Olin Library - Room 425 - Fourth Floor", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 22.0, 10.0, 22.0, 10.0, 26.0);
		addPrinter(col, "olin-lib-gradlounge", "Olin Library Graduate Lounge", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 26.0, 8.0, 22.0, 10.0, 22.0, 10.0, 26.0);
		addPrinter(col, "olin-lib5c", "Olin Library - behind the reference desk", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		addPrinter(col, "sage-301-color", "Sage Hall Library - Room 302 - Third Floor Collaboration Space", "campus-bw, campus-color", 42.4458947, -76.4832581, empty);
		addPrinter(col, "sage-lib1-color", "Sage Hall - Library - First Floor", "campus-bw, campus-color", 42.4458918, -76.4833009, empty);
		addPrinter(col, "sage-mfp1", "Sage Johnson First Floor Room 101", "campus-bw, campus-color", 42.4458947, -76.4832581, empty);
		addPrinter(col, "sage-mfp2/sage-mfp3", "Sage", "campus-bw, campus-color", 42.4397199, -76.49146619999999, empty);
		addPrinter(col, "scl-malott", "Mallot (?)", "campus-bw, campus-color", 42.4482224, -76.4802083, empty);
		addPrinter(col, "sha-mslc-color", "Nestle Library - west side of reference desk", "campus-bw, campus-color", 42.445541, -76.48215429999999, empty);
		addPrinter(col, "sibley1-b56", "Sibley", "campus-bw, campus-color", 42.4509802, -76.4840158, empty);
		addPrinter(col, "sips-ps170-1c", "Plant Science Building - Room 170", "campus-bw, campus-color", 42.4483258, -76.4770262, empty);
		sched = new PSchedule(8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 21.0, 12.0, 21.0, 10.0, 25.0);
		addPrinter(col, "uris-lib-mfp1", "Uris Library Austen Room", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 21.0, 12.0, 21.0, 10.0, 25.0);
		addPrinter(col, "uris-lib-mfp2", "Uris Main Library (direct print; card reader?)", "campus-color", 42.447905, -76.484293, sched);
		sched = new PSchedule(8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 25.0, 8.0, 21.0, 12.0, 21.0, 10.0, 25.0);
		addPrinter(col, "uris-lib2c", "Uris Library - In Front of Circulation Desk", "campus-bw, campus-color", 42.447905, -76.484293, sched);
		addPrinter(col, "vetlib5", "Schurman Hall - S1201 (direct print; card reader?)", "campus-bw, campus-color", 42.4480179, -76.4661765, empty);
		sched = new PSchedule(7.5, 23.0, 7.5, 23.0, 7.5, 23.0, 7.5, 23.0, 7.5, 20.0, 10.0, 20.0, 10.0, 23.0);
		addPrinter(col, "vetschool-library1", "Vet School Library", "campus-bw, campus-color", 42.4474921, -76.4658424, sched);
	}
	
	public NetprintData() {

	}

}
