class PuzzleJavaTest {
    public static void main(String[] args){
        PuzzleJava puzzle = new PuzzleJava();
        System.out.println(puzzle.getTenRolls(10, 10, 20));
        System.out.println(puzzle.getRandomLetter());
        System.out.println(puzzle.generatePassword());
        System.out.println(puzzle.getNewPasswordSet(7));
    }
}