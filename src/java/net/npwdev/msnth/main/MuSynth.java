package net.npwdev.msnth.main;

import net.npwdev.msnth.toning.Placer;
import tech.npwd.roots.*;

import net.npwdev.msnth.generation.Generator;
import net.npwdev.msnth.pattern.Planner;

import javax.sound.midi.*;
import java.io.*;

import static javax.sound.midi.MidiSystem.getSoundbank;
import static tech.npwd.roots.Inputter.charTranslator;
import static tech.npwd.roots.Printer.*;
import static tech.npwd.roots.Sleeper.sleep;

//MuSynth: Main of MuSynth

public class MuSynth {

    private static final String version = "1_1";

    private static Argumenter argumenter;
    private final static String[] parameters = { "-keys", "-sb", "-spd", "-sz", "-ord" };

    //Program init
    public static void main(String[] args) {
        //Intake arguments
        intakeArgs(args);

        //Greet the user with the initialization msg
        greet();

        //Start Program Protocol
        new MuSynth();
    }

    //Main Constructor
    private MuSynth(){
        //Generate loops until the user wants to exit
        char genAgain;
        do {
            //Create pattern
            Planner pattern = new Planner();

            //Place notes onto pattern
            net.npwdev.msnth.toning.Placer formattedPattern = new Placer(pattern);

            //Get Note Sequence from Formatted Pattern
            Grouper<net.npwdev.msnth.toning.Note> notes = formattedPattern.createNoteSequence();

            //Play the note sequence
            play(notes);

            System.out.println();
            print("Generate New Loop from Existing Parameters? (Y/N)");
            genAgain = charTranslator();
            System.out.println();
        } while(genAgain == 'Y');

        //Exit with msg
        print("Finished Generation from Given Instruction - Exiting MuSynth...");
    }

    //Play the sequence until the user wants to continue
    private void play(Grouper<net.npwdev.msnth.toning.Note> notes){
        try {
            //Init custom synthesizer
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            customizeSynthesizer(synthesizer);

            //Generate the note sequence
            print("BEGIN LOOP:\n-----------------------------------------");
            notes.forEach(note -> {
                //Generate the note
                new Generator(synthesizer, note.getKey(), note.getDuration(), notes.indexOf(note) + 1);
                //FIX: Sleep extra on the last note to prevent chop off
                if(notes.indexOf(note) == (notes.size() - 1)) { sleep(notes.get(notes.size() - 1).getDuration()); }
            });
        } catch (MidiUnavailableException e){
            printError("Error in MidiGeneration. Troubleshooting is necessary.", e);
        }

        //Ask if the user wants to hear again, else continue
        System.out.println();
        print("Play Again? (Y/N)");
        if(charTranslator() == 'Y'){
            System.out.println();
            play(notes);
        }
    }

    //Customize Synthesizer to play a custom instrument
    private void customizeSynthesizer(Synthesizer synthesizer){
        try {
            //Unload default soundbank
            synthesizer.unloadAllInstruments(synthesizer.getDefaultSoundbank());
            //Load custom instrument
            synthesizer.loadInstrument(getSoundbank(new File(argumenter.getValue("-sb"))).getInstruments()[0]);
            //Select Instrument
            Patch instrumentMeta = synthesizer.getLoadedInstruments()[0].getPatch();
            //Log Instrument In-Use Readably
            print("Using Instrument \"" + synthesizer.getLoadedInstruments()[0].getName() + "\"\n");
            sleep(600);
            //Change to the instrument
            synthesizer.getChannels()[0].programChange(instrumentMeta.getBank(), instrumentMeta.getProgram());
        } catch (InvalidMidiDataException | IOException e){
            printError("Error in setting up Synthesizer. Troubleshooting is necessary.", e);
        }
    }

    //Greets the user upon the program init
    private static void greet() {
        print("Starting MuSynth v" + version + "...");
        sleep(600);
        print("Using Soundbank \"" + argumenter.getValue("-sb") + "\"");
        sleep(600);
        print("Inputted Keys: " + argumenter.getValue("-keys"));
        sleep(600);
        print("Going by parameters: \n---------------------------------");
        sleep(400);
        print("Size: " + argumenter.getValue("-sz"));
        sleep(400);
        print("Speed: " + argumenter.getValue("-spd"));
        sleep(400);
        print("Order: " + argumenter.getValue("-ord") + "\n");
        sleep(600);
    }

    //Intake of program arguments
    private static void intakeArgs(String[] args){
        //Intake from Argumenter
        argumenter = new Argumenter(new Grouper<String>(){{ importFromArray(parameters); }});
        argumenter.intake(args);
    }

    public static Argumenter argumenter(){ return argumenter; }
}
