package net.npwdev.msnth.pattern;

//Durations: Defined intervals of note durations to be used when specifying how long a note should play
//(Pre-defined to generate ALL types of patterns)

public enum Durations {

    FAST(new int[]{ 100, 150, 175 }),
    MEDIUM_FAST(new int[]{ 175, 200, 225 }),
    MODERATE(new int[]{ 250, 275, 300 }),
    SLOW(new int[]{ 300, 350, 400 });

    private final int[] durationSelection;

    Durations(int[] durationSelection){
        this.durationSelection = durationSelection;
    }

    //Use the specified duration
    public static int[] useDuration(String durationType){ return valueOf(durationType).durationSelection; }
}
