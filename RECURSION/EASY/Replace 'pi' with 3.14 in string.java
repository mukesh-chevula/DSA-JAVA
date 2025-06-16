public class ReplacePi {
    public static String replacePi(String str) {
        if(str.length()<=1) return str;

        if(str.startsWith("pi")) return "3.14"+replacePi(str.substring(2));
        else return str.charAt(0)+replacePi(str.substring(1));
    }
}