package com.virtualsofia.brokkr.tier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TierSystem {
    private static Map<String, Integer> tierMap = new HashMap<String, Integer>();

    public static void makeVanillaTiers() {
        // Insert vanilla tiers
    }

    private static void add(Tier tier) {
        String tierName = tier.modid + ":" + tier.name;
        int tierLevel = tier.level;
        for (String x : tierMap.keySet()) {
            int entryLevel = tierMap.get(x);
            if (entryLevel >= tierLevel)
                tierMap.put(x, entryLevel + 1);
        }
        tierMap.put(tierName, tierLevel);
    }
    private static Integer get(String id) {
        return tierMap.get(id);
    }
    public static class Tier {
        private String name;
        private String modid;
        private int level;
        private List<String> blocks;
        private Tier() {

        }
        private Tier(String name, String modid, int level, List<String> blocks) {
            this();
            this.name = name;
            this.modid = modid;
            this.level = level;
            this.blocks = blocks;
        }
        public static Tier from(String name, String modid, int level, List<String> blocks) {
            Tier tier = new Tier(name, modid, level, blocks)
                    .register();
            return tier;
        }
        private Tier register() {
            TierSystem.add(this);
            return this;
        }
        public String getName() {
            return name;
        }
        public String getModid() {
            return modid;
        }
    }
}
