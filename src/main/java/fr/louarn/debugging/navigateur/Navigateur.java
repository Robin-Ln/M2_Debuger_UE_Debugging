package fr.louarn.debugging.navigateur;

import fr.louarn.debugging.printer.Printer;
import fr.louarn.debugging.program.trace.ProgramTrace;
import fr.louarn.debugging.trace.Level;
import fr.louarn.debugging.utils.Constants;
import fr.louarn.debugging.utils.MethodesUtils;

import java.util.Scanner;

public class Navigateur {

    Printer printer;
    StringBuilder helper;

    public Navigateur() {
        this.printer = new Printer(System.out, Level.FAIBLE);
        this.helper = this.getHelper();
    }

    private StringBuilder getHelper() {
        StringBuilder helper = new StringBuilder();
        return helper.append("-----------------------\n")
                .append("Liste des commande utilisable\n")
                .append("Suivant : s\n")
                .append("Précedent : p\n")
                .append("Quitter : q\n")
                .append("-----------------------\n");
    }

    public static void main(String[] args) {
        Navigateur navigateur = new Navigateur();
        ProgramTrace programTrace = (ProgramTrace) MethodesUtils.readObject(Constants.PATH_FILE_SAVE);
        navigateur.run(programTrace);
    }

    private void run(ProgramTrace programTrace) {
        Scanner scanner = new Scanner(System.in);
        programTrace.next().accept(this.printer);
        while (true) {
            String val = scanner.nextLine();

            switch (val) {
                case "n":
                    this.handlerNext(programTrace);
                    break;
                case "p":
                    this.handlerPrevious(programTrace);
                    break;
                case "q":
                    this.handlerQuit();
                    break;
                default:
                    System.out.println(this.helper);
            }

        }

    }

    private void handlerNext(ProgramTrace programTrace) {
        try {
            programTrace.next().accept(this.printer);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("fin du programme");
        }
    }

    private void handlerPrevious(ProgramTrace programTrace) {
        try {
            programTrace.previous().accept(this.printer);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("debut du programme");
        }
    }

    private void handlerQuit() {
        System.exit(0);
    }

}
