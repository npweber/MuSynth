# v1_4d

*Established Pattern Sequencing for the Loop*

Additions:
- Added "Planner.java": Plots out the pattern for the next step of the program to establish notes on. This creates a guide to the tempo and placement of notes for the program to use.
- Added "RandomGeneration.java": Temporary utility class that generates random numbers and flags/booleans. *Will be moved to ApeRoots  API in the future.*

Changes:
- Generator.java is now used to generate one note, when called, given note parameters. Note parameters include MIDI note number and duration to play the note for.
