package domaincore;

public final class SlideHelpers {

    public static String CreateTextLine(String tag, String text) {
        // It doesnt manner how many spaces are before or after the delimiter,it has to be splitted
        String delimiters = " ;\\s*|\\; \\s*";
        String[] arrOfStr = text.split(delimiters);
        String newString = "";
        for (String a : arrOfStr) {
            newString += CreateTag(tag).concat(a).concat("\r\n");
        };
        return newString;
    }

    public static String CreateTag(String tag) {
        return "<" + tag + ">:";
    }

    public static boolean isTagInString(String data, String tag) {
        return data.contains(tag);
    }
}
