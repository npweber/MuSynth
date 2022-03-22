MuSynth
__________________

MuSynth: Music Synthetically Generated

The goal or idea was to create a program that can autonomously generate either an EDM track or EDM music loop. The track could then be paired lyrics should the end result be a synthetically generated track, or the loop could serve as a component of a production that would be created in a Sound Production Editing Software. Two end results were considered, and the project worked towards either goal.

This project, at its current state, generates any possible musically sound loop and presents it to the user. It does this based on the parameters it is given to generate: its instrument choice (run by soundfonts in Java's MIDI lib), the keys to include in the loop, the musical ordering of the keys (ASCENDING/DESCENDING), the speed of the loop (tempo), and the size of the loop (number of notes). It is then able to generate any loop within those bounds.

This project is the most prioritized project in the portfolio, also the most creative and innovative by far. I plan to advance it past loop generation, possibly to generation of tracks, should the solution be found. But for now, this is a handy utility that is able to provide music loop ideas to go off of when producing sound. 

Update (3/22/2022): MuSynth is now the base backend of an Android app, synthOS, which allows for the interfacing of the project's capabilities. So now MuSynth has been taken beyond command-line.

Feel free to look at the source, it's complex enough to execute the task of creating music!