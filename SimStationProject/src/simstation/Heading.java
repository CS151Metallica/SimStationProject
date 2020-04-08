package simstation;

import java.util.Random;

public enum Heading {
	N,
	S,
	E,
	W;
	
	public static Heading random() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
};


