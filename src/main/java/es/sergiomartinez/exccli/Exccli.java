/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package es.sergiomartinez.exccli;

import java.text.NumberFormat;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Exccli {

    public static void main(String[] args) {

        ///////////////////////////////////////////////////////////////////////
        // Fase 1: Configuramos las opciones de validación de entrada.
        ///////////////////////////////////////////////////////////////////////
        Options options = new Options();

        options.addOption("w", "hello world", false, "Imprimir hola mundo");

        OptionGroup group = new OptionGroup();
        group.addOption(new Option("s", "subir", false, "Imprime bonito"));
        group.addOption(new Option("c", "cruel", false, "Imprime cruel"));
        options.addOptionGroup(group);

        options.addOption("h", "help", false, "Imprime el mensaje de ayuda");
        options.addOption("y", "years", true, "Imprime tras n años de vida");
        ///////////////////////////////////////////////////////////////////////
        // Fase 2: Parseamos la entrada con la configuración establecida
        ///////////////////////////////////////////////////////////////////////

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            ///////////////////////////////////////////////////////////////////////
            // Fase 3: Analizamos los resultados y realizamos las tareas pertinentes
            ///////////////////////////////////////////////////////////////////////
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("time", options);
            } else if (cmd.hasOption("w")) {
                // print hola mundo
                System.out.print("Hola mundo");

                if (cmd.hasOption("n")) {
                    System.out.println(" bonito");
                } else if (cmd.hasOption("c")) {
                    System.out.println(" cruel");
                }

                if (cmd.hasOption("y")) {
                    try {
                        System.out.println(" tras " + Integer.parseInt(cmd.getOptionValue("y")) + " años de vida");
                    } catch (Exception e) {
                        System.err.println("No ");
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Exccli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
