# v1_0

*Release build, having complete functionality as a [CLI](https://en.wikipedia.org/wiki/Command-line_interface). All existing code has been overhauled to finalize the project.*

Additions:
- Added more parameters: Values that were hardcoded during Beta are now inputted into the program at execution:
  1. `sb` : Soundbank file path
  2. `sz` : Size of loop or how many notes to include
  3. `spd` : Tempo of loop
  4. `ord` : "Musical ordering" of loop,`ASCENDING` OR `DESCENDING`, `Low to High` OR `High to Low` pitches.
- Added user "greeting": A logging of program info and what parameters it will use to generate the loop, before it starts generation.

Changes:
- Changed `chdin` parameter name to `keys`.
- Every while loop now has a control count that prevents an infinite loop, similar to the control count in build [v1_6b](https://github.com/npweber/MuSynth/tree/main/artifact/1_6b).
