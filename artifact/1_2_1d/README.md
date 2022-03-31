# v1_2_1d

*STARTING FRESH*

This version of MuSynth marks a new design to the way the program will work.   

Changes:
- No longer step by step in process: the program is given parameters, and it completes the generation of the music.
- Consequently, there will be no logging except for errors.

Additions:
- Added "input" package: Holds "Argumenter.java" that passes the parameters to the program
- Added "Generator.java": Takes properties of sound (undefined for now) and uses them to generate a single note of music. *The functionality at this stage of development is WIP.*
- Added "Classifier.java": Takes instruction from a higher class in the program hierarchy and creates a set of sound properties to use for generation. *The functionality at this stage of development is WIP.*
- Added "SoundType.java" Enum: Defines different types of sounds that can be generated. *This is unused for now*.
