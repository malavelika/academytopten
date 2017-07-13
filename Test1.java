public class Test1 {
public static String removeScriptTag (String body) {
        StringBuilder sb = new StringBuilder();
        int firstI=-1;
        int lastI =-1;
        int i=0;
		while (i<body.length()){
				firstI = body.indexOf("<script", i); 
				lastI = body.indexOf("\\script>", firstI)+"\\script>".length(); 
				if (firstI<0) {
					sb.append(body.substring(i)); 
					i=body.length();
					}
				else {
					sb.append(body.substring(i, firstI)); 
					i = lastI;
					}
			}
        System.out.println (sb.toString());
        return sb.toString();
    }
public static void main (String [] arg) { 
	String body = "Danas nam je divan <script> scriptbrackets <\\script> dan. Sutra <script oa> scriptbrackets2 <\\script> zahladjenje? <script> scriptbrackets <\\script> Kraj."; 
	String temp = removeScriptTag(body);

}

}
