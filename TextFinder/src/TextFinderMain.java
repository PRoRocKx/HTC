public class TextFinderMain {

    public static void main(String... arg){
        TextFinder textFinder = new FileFinder();
        System.out.println(textFinder.getSubstringCount("contact.txt", ";"));
    }
}
