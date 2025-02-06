import java.util.Scanner;

public class Main {
    private static TelefonListen tlfListe = new TelefonListen();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        tlfListe = new TelefonListen(Persistens.indlaesTelefonbog());

        tlfListe.tilfoejKontakt("Kristian", "29105560");
        tlfListe.tilfoejKontakt("Susanne", "22684561");
        tlfListe.tilfoejKontakt("Knud", "22111027");
        tlfListe.tilfoejKontakt("Thomas", "43560219");
        tlfListe.tilfoejKontakt("Lars", "44656312");
        tlfListe.tilfoejKontakt("Kenneth", "91092345");
        tlfListe.tilfoejKontakt("Alberte", "76234567");
        tlfListe.tilfoejKontakt("Rasmus", "87623412");
        tlfListe.tilfoejKontakt("Sarah", "12345678");
        tlfListe.tilfoejKontakt("Freja", "91011123");

        while (true)
        {
            displayMenu();
            int valg = scanner.nextInt();
            scanner.nextLine();

            switch(valg) {
                case 1:
                    opretKontakt();
                    break;
                case 2:
                    redigerKontakt();
                    break;
                case 3:
                    soegKontakt();
                    break;
                case 4:
                    sletKontakt();
                    break;
                case 5:
                    udskrivListe();
                    break;
                case 6:
                    udskrivAlleNavne();
                    break;
                case 7:
                    System.out.println("Afslutter program...");
                    Persistens.gemTelefonbog(tlfListe.getTelefonbog());
                    return;
                default:
                    System.out.println("Ugyldigt valg - prøv igen.");
            }
        }
    }

    private static void displayMenu()
    {
        System.out.println("\nVelkommen til Telefonlisten!");
        System.out.println("1. Opret ny kontakt: ");
        System.out.println("2. Rediger kontakt: ");
        System.out.println("3. Søg efter kontakt: ");
        System.out.println("4. Slet kontakt: ");
        System.out.println("5. Udskriv kontaktliste: ");
        System.out.println("6. Udskriv alle navne på kontaker: ");
        System.out.println("7. Stop programmet: ");
        System.out.println("Vælg en valgmulighed: ");
    }

    private static void opretKontakt()
    {
        System.out.println("Opretter ny kontakt");
        System.out.println("\nIndtast navn på ny kontakt: ");
        String navn = scanner.nextLine();
        System.out.println("Indtast telefonnummer på ny kontakt: ");
        String telefonnummer = scanner.nextLine();

        tlfListe.tilfoejKontakt(navn, telefonnummer);
        System.out.println("Kontakt tilføjet: " + navn + " - " + telefonnummer);
    }

    private static void redigerKontakt()
    {
        System.out.println("Indtast navn på kontakt, der skal redigeres: ");
        String navn = scanner.nextLine();
        if (tlfListe.getTelefonbog().containsKey(navn))
        {
            System.out.println("Indtast nyt telefonnummer på kontakt: ");
            String nytTelefonnummer = scanner.nextLine();
            tlfListe.tilfoejKontakt(navn, nytTelefonnummer);

            System.out.println("Telefonnummer for " + navn + " er opdateret til " + nytTelefonnummer);
        } else
        {
            System.out.println("Kontakt ned navnet " + navn + " findes ikke.");
        }
    }

    private static void soegKontakt()
    {
        System.out.println("\nIndtast navn på person, som du gerne vil søge efter: ");
        String navn = scanner.nextLine();
        String telefonnummer = tlfListe.hentTelefonnummer(navn);

        if (telefonnummer != null)
        {
            System.out.println(navn + "'s telefonnummer er: " + telefonnummer);
        } else
        {
            System.out.println("Kontakt ikke fundet.");
        }
    }

    private static void sletKontakt()
    {
        System.out.println("\nIndtast navn på person, som skal slettes: ");
        String navn = scanner.nextLine();
        String telefonnummer = tlfListe.hentTelefonnummer(navn);

        if (telefonnummer != null)
        {
            tlfListe.sletKontakt(navn);
            System.out.println("Kontakt " + navn + " er nu slettet.");
        } else
        {
            System.out.println("Kontakt " + navn + " ikke fundet på liste.");
        }
    }

    private static void udskrivListe()
    {
        System.out.println("Udskriver telefonliste: \n");
        System.out.println(tlfListe.toString());
    }

    private static void udskrivAlleNavne()
    {
        System.out.println("Udskriver alle navne på kontakter: ");
        tlfListe.udskrivKunNavne();

        if (tlfListe.getTelefonbog().isEmpty())
        {
            System.out.println("Ingen kontaker fundet.");
        }
    }
}