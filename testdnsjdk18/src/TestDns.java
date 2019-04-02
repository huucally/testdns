

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.Security;


public class TestDns {
	static {
	    java.security.Security.setProperty ("networkaddress.cache.ttl" , "10");   
	}
	
	final static String hostname = "rps.hanafostv.com";
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// only required for Java SE 5 and lower:
        //Security.setProperty("networkaddress.cache.ttl", "30");

		//java.security.Security.setProperty ("networkaddress.cache.ttl" , "5");
        int i = 0;
        while(true) {
            
            try {
               // makeRequest();
                InetAddress inetAddress = InetAddress.getLocalHost();
                //System.out.println(new Date());
                inetAddress = InetAddress.getByName(hostname);
                displayStuff(hostname, inetAddress);
                jvmttlPrint(i);
                
//                if(i==40) {
//                	java.security.Security.setProperty("networkaddress.cache.ttl", "0");
//                	//static {
//                	//    java.security.Security.setProperty ("networkaddress.cache.ttl" , "60");   
//                	//}
//                }
//                if(i==60) {
//                	java.security.Security.setProperty("networkaddress.cache.ttl", "-1");
//               
//                }
               
                
            } catch (UnknownHostException e) {
                e.printStackTrace();
                break;
            }
            try {
                Thread.sleep(1000);
            } catch(Exception ex) {}
            i++;
            //if(i==30) break;
        }
		
	    
	}

	public static void jvmttlPrint(int i) {
		 System.out.println(i + "\tSecurity.ttl:" + Security.getProperty("networkaddress.cache.ttl") + " System.ttl:" + System.getProperty("networkaddress.cache.ttl") + " "
		 		+ "Security.negative.ttl:" + Security.getProperty("networkaddress.cache.negative.ttl") + " System.negative.ttl:" + System.getProperty("networkaddress.cache.negative.ttl"));
         
	}
	
    public static void displayStuff(String whichHost, InetAddress inetAddress) {
        System.out.println("==>Which Host:" + whichHost +" Canonical Host Name:" + inetAddress.getCanonicalHostName() +" Host Name:" + inetAddress.getHostName() + " Host Address:" + inetAddress.getHostAddress());
    }

    public static void makeRequest() {
        try {
            URL url = new URL("http://"+hostname+":8080/");
            URLConnection conn = url.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            InputStreamReader ird = new InputStreamReader(is);
            BufferedReader rd = new BufferedReader(ird);
            String res;
            while((res = rd.readLine()) != null) {
                //System.out.println(res);
                break;
            }
            rd.close();
            
       	 	ird.close();
       	 	is.close();
       	 	
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}




