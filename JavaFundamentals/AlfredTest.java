public class AlfredTest {

    public static void main(String[] args) {
        AlfredQuotes guest = new AlfredQuotes();
        System.out.println(guest.guestGreeting("Jamal Harb"));
        System.out.println(guest.guestGreeting("Jamal Harb", "morning"));
        System.out.println(guest.dateAnnouncement());
        System.out.println(guest.respondBeforeAlexis("Hey bot, this is Jamal. Can you call Sara?"));
    }

}