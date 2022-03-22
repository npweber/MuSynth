v1_0
_____________

Release Build.
  *Complete functionality and CMD interface
  **Overhaul and prime of all existing frameworks

Additions:
  -More parameters - Hardcoded values in process are now inputted into the program:
    -'sb': Soundbank file location
    -'sz': Loop note length
    -'spd': Note duration profile
    -'ord': Loop musical order (ASCENDING OR DESCENDING)
  -The user is "greeted" by CMD logging overview of the program environment

Changes:
  -Extra sleep time on last note
    *Fixes the loop being "chopped off"
  -Changed 'chdin' parameter to 'keys'
  -Every while loop now has a control count fail safe
    *Stops the program when the loop has overflowed