# v1_6b

*First Beta Stage (b) Build of Project*
- The program can now undergo development tests for reliability.

Additions:
- Added "play()" to main so the playback can be called separately from the main process.

Changes:
- Corrected the infinite looping in Placer.java by forcibly exiting the program upon a count of 1M iterations. This will remove the infinite looping, but the program now has a limitation of not always successfully returning Exit Code 0.
