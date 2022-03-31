# v1_6_1b

Additions:
- Set up a base implementation for the selection of a "sound profile", the virtual instrument the program will use the generate the note sequence. *This functionality is a WIP for the next update.*

Changes:
- Generator.java now logs the notes played.
- Generation procedure now uses "Synthesizer" and "Channel" interfaces to generate the notes, which replaces the "Sequencer" interface used within `javax.sound.midi`.
