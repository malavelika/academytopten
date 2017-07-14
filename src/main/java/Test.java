public class Test {
public static String removeScriptTag (String body) {
        StringBuilder sb = new StringBuilder();
        int firstI=-1;
        int lastI =-1;
        int i=0;
		System.out.println ("body.length  " + body.length());
           // while (i<body.length()){
				i = 129;
				firstI = body.indexOf("<script", i); //System.out.println ("\n\n firstI  " + firstI);
				
                lastI = body.indexOf("\\script>", firstI)+"\\script>".length(); 
				
				System.out.println ("pocetak " +firstI + "  kraj  "+ lastI);
				//sb.append(body.substring(i, firstI));
					sb.append(body.substring(i));
				
				//i++;
				/*if ((firstI>0)&&(lastI>0)) {
					sb.append(body.substring(i, firstI)); 
					i = lastI+1;
					} //System.out.println ("lastI  " + lastI); 
				else if  ((firstI<0)&&(lastI>0))  { 
					sb.append(body.substring(lastI+1)); 
					i=body.length(); 
					}
				else { 
					sb.append(body.substring(i)); 
					i=body.length(); 
					}*/
               // }
        System.out.println (sb.toString());
        return sb.toString();
    }
public static void main (String [] arg) { 
	String body = "danas nam je divan <script> tekst izmedju script brackets <\\script> dan. Sutra <script oa> opet izmedju script brackets <\\script> zahladjenje?"; 
	String temp = removeScriptTag(body);

}

}
