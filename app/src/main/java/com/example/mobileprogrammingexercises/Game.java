    package com.example.mobileprogrammingexercises;

    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.Random;

    public class Game {
        private static final List<String> options = List.of("ROCK", "SCISSORS", "PAPER");
        private static final Map<String, Boolean> rules = new HashMap<>();
        private static final Map<String, Integer> optionDrawable = new HashMap<>();

        static {
            rules.put("ROCK-SCISSORS", true);
            rules.put("ROCK-PAPER", false);
            rules.put("SCISSORS-PAPER", true);
            rules.put("SCISSORS-ROCK", false);
            rules.put("PAPER-ROCK", true);
            rules.put("PAPER-SCISSORS", false);

            optionDrawable.put("ROCK", R.drawable.rock);
            optionDrawable.put("SCISSORS", R.drawable.scissors);
            optionDrawable.put("PAPER", R.drawable.paper);
        }

        public static String pickRandomOption() {
            return options.get(new Random().nextInt(options.size()));
        }

        public static int pickDrawable(String option) {
            return optionDrawable.get(option);
        }

        public static Boolean isDraw(String from, String to) {
            return from.equals(to);
        }

        public static Boolean isWin(String from, String to) {
            return rules.getOrDefault(from + "-" + to, false);
        }
    }
