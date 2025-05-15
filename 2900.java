 List<String> result = new ArrayList<>();
        if (words.length == 0) return result;

        result.add(words[0]);
        int lastGroup = groups[0];

        for (int i = 1; i < words.length; i++) {
            if (groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }

        return result;