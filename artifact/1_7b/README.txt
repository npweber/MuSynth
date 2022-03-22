v1_7b
_____________

**Establishes FULLY FUNCTIONAL Loop Patterns

Additions:
  -Durations Enum: Defines the different durations of notes by subjective qualities
    *Makes the desired tempo of loop obtainable by definition
  -Sizes Enum: Defines the different amounts of notes to play in a loo
    *Makes the desired loop length obtainable

Fixes:
  -Fixed the fact that the generator produces notes that overlap each other
    *Due to the note playing its duration longer than the program could sleep  
      **Fixed by turning the note off immediately after the sleep method
