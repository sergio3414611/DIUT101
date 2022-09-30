/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sergiomartinez.tempagua;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author jv
 */
public class Vista {

    private Controlador controlador;

    Vista(Controlador controlador) {
        this.controlador = controlador;
    }

    public void convertir(String[] args) {

        ///////////////////////////////////// 1. FASE DE DEFINICIÓN
        // create Options object
        Options options = new Options();
        Option oSubir = Option.builder("s").hasArg()
                .desc("Aumenta la temperatura").build();
        Option oBajar = Option.builder("b").hasArg()
                .desc("Baja la temperatura").build();

        OptionGroup group = new OptionGroup();
        group.addOption(oSubir);
        group.addOption(oBajar);
        options.addOptionGroup(group);
        options.addOption("h", "help", false, "display help");

        ///////////////////////////////////// 2. FASE DE PARSEO
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            ///////////////////////////////////// 3. FASE DE INTERROGACIÓN
            // Si opción -h
            if (cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("time", options);
            } else {
                // Si conversión a pesetas
                if (cmd.hasOption("s")) {
                    controlador.auTemperatura(Integer.parseInt(cmd.getOptionValue("s")));

                } else if (cmd.hasOption("b")) {
                    controlador.bjTemperatura(Integer.parseInt(cmd.getOptionValue("b")));
                } else {
                    controlador.compTemp();
                }

            }

        } catch (ParseException ex) {
            System.err.println(ex.getLocalizedMessage());

        }
    }

    public void showT(int temp) {
        if (temp > 100) {
            System.out.println("Error, has hervido el agua a mas de 100");

        } else if (temp < 0) {
            System.out.println("Error has congelado el agua");
        } else {
            System.out.println("La temperatura es: " + temp);
        }

    }

}
