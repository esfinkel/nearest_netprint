package netprintfinder;

import java.time.LocalDateTime;

public class PSchedule {

	double ms, me, ts, te, ws, we, rs, re, fs, fe, ss, se, us, ue;
	
	Boolean empty;
	
	
	public PSchedule() {
		empty = true;
	}
	
	public PSchedule(double mS, double mE, double tS, double tE,
			double wS, double wE, double rS, double rE, double fS,
			double fE, double sS, double sE, double uS, double uE) {
		ms = mS; mE = me;				
		ts = tS; te = tE;
		ws = wS; we = wE;
		rs = rS; re = rE;
		fs = fS; fe = fE;
		ss = sS; se = sE;
		us = uS; ue = uE;
		empty = false;
	}

	public String Available() {
		LocalDateTime now = LocalDateTime.now();
		if (empty) return "It may be open.";
		
		double starttime, endtime;
		switch(now.getDayOfWeek().ordinal()) {
			case 0: starttime = ms; endtime = me;
				break;
			case 1: starttime = ts; endtime = te;
				break;
			case 2: starttime = ws; endtime = we;
				break;
			case 3: starttime = rs; endtime = re;
				break;
			case 4: starttime = fs; endtime = fe;
				break;
			case 5: starttime = ss; endtime = se;
				break;
			case 6: starttime = us; endtime = ue;
				break;
			default: starttime = us; endtime = ue;
				break;
		}
		
		String status = "";
		double currtime = now.getHour() + now.getMinute()/60;
		if (currtime < endtime) {
			String closesin = String.valueOf(Math.round(60 * (endtime - currtime)));
			status = "It closes in " + closesin  + " minutes.";
		} else if (currtime < starttime) {
			String opensin = String.valueOf(starttime - currtime);
			status = "It opens in " + opensin + " minutes.";			
		} else {
			status = "CLOSED";
		}

		return status;
	}
	
	public String toString() {
		if (empty) return "{UNKNOWN}";
		String ret = "{";
		ret += Double.toString(ms) + ", " + Double.toString(me) + ", ";
		ret +=		Double.toString(ts) + ", " + Double.toString(te) + ", ";
		ret +=		Double.toString(ws) + ", " + Double.toString(we) + ", ";
		ret +=		Double.toString(rs) + ", " + Double.toString(re) + ", ";
		ret +=		Double.toString(fs) + ", " + Double.toString(fe) + ", ";
		ret +=		Double.toString(ss) + ", " + Double.toString(se) + ", ";
		ret +=		Double.toString(us) + ", " + Double.toString(ue);
		ret += "}";
		return ret;
	}
	
	
		
}
