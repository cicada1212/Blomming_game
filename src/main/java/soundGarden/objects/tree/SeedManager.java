package soundGarden.objects.tree;

import java.util.ArrayList;

public class SeedManager {
    public static ArrayList<Seed> seeds = new ArrayList<Seed>();
    public static int maxSeeds = 10;

    public static void add(Seed s) {
        if (seeds.size() <= 15)
            seeds.add(s);
        else {
            s.isFertile = false;
            s.growProb = 0;
        }
    }

    public static void remove(Seed s) {
        for (int i = seeds.size() - 1; i >= 0; i--) {
            Seed seed = seeds.get(i);
            if (seed.equals(s))
                seeds.remove(i);
        }
    }

    public static Seed getFurthestSeed() {
        int prevX = 0;
        //println(seeds.size());
        if (seeds.size() == 0) return null;
        Seed returnSeed = seeds.get(0);

        for (int i = 0; i < seeds.size(); i++) {
            Seed seed = seeds.get(i);
            seed.isFertile = false;
            if (seed.position.x > prevX) {
                returnSeed = seed;
                prevX = (int)seed.position.x;
                returnSeed.isFertile = true;
            }
        }

        return returnSeed;
    }
}