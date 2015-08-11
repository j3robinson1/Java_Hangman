public class Game {
  public static final int MAX_MISSES = 7;
  private String mAnswer;
  private String mHits;
  private String mMisses;

  public Game(String answer) {

    mAnswer = answer;
    mHits = "";
    mMisses = "";

  }
  private char validateGuess(char letter) {

    if (!Character.isLetter(letter)) {

      throw new IllegalArgumentException("A letter is required");

    }
    letter = Character.toLowerCase(letter);
    if (mMisses.indexOf(letter) >= 0 || mHits.indexOf(letter) >= 0) {
      throw new IllegalArgumentException(letter + " has already been guessed");
    }
    System.out.printf("Used: %s\n", mMisses);
    return letter;
  }
  public boolean applyGuess(String letters) {

    if (letters.length() == 0) {

      throw new IllegalArgumentException("No letter found");

    }
    return applyGuess(letters.charAt(0));
  }
  public boolean applyGuess(char letter) {

    letter = validateGuess(letter);
    boolean isHit = mAnswer.indexOf(letter) >= 0;
    if (isHit) {
      mHits += letter;
    } else {
      mMisses += letter;
    }
    return isHit;

  }
  public String getCurrentProgress() {

    String progress = "";
    for (char letter: mAnswer.toCharArray()) {

      char display = '-';
      if (mHits.indexOf(letter) >= 0) {

        display = letter;
      
      }
      progress += display;
    }
    return progress;
  }
  public String getMan() {

    String man[] = new String[8];
    man[0] = " --\n   |\n   |\n   |\n_____\n";
    man[1] = " --\n o |\n   |\n   |\n_____\n";
    man[2] = " --\n o |\n | |\n   |\n_____\n";
    man[3] = " --\n o |\n/| |\n   |\n_____\n";
    man[4] = " --\n o |\n/|\\|\n   |\n_____\n";
    man[5] = " --\n o |\n/|\\|\n/  |\n_____\n";
    man[6] = " --\n o |\n/|\\|\n/ \\|\n_____\n";
    System.out.println(man[mMisses.length()]);
    return man[0];
  }
  public int getRemainingTries() {

    return MAX_MISSES - mMisses.length();

  }
  public String getAnswer() {

    return mAnswer;

  }
  public boolean isSolved() {

    return getCurrentProgress().indexOf('-') == -1;

  }
}