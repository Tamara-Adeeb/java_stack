public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        return str1.trim() + str2.trim();
    }
    public Integer getIndexOrNull(String str1, char l) {
        if (str1.indexOf(l) == -1 ) {
            return null;
        }
        return str1.indexOf(l);
    }
    public Integer getIndexOrNull(String str1, String str2) {
        if (str1.indexOf(str2) == -1 ) {
            return null;
        }
        return str1.indexOf(str2);
    }
    public String concatSubstring (String str1, int start, int end, String str2) {
        return str1.substring(start,end) + str2 ;
    }
}