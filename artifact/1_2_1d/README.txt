v1_2_1d
____________

*STARTING FRESH*

This version of MuSynth marks a new design to the way the program will work.   

  Changes:
    -No longer step by step in process: The program is given parameters & it completes the generation
    -This also means there will be no logging except for errors

  Additions:
    -Added "input" Package: Holds "Argumenter.java" that passes the parameters to the program
    -Added "Generator.java": Takes properties of sound (undefined for now) and uses them to generate a single chord for the generation of music (Needs Work)
    -Added "Classifier.java": Takes instruction from a higher class in the program hierarchy & creates a set of sound properties to use for generation (Needs Work)
    -Added "SoundType" Enum: Basic Enum defining different types of sound generated (Unused for now...)